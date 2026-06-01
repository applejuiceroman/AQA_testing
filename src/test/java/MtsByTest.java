import lesson_9.SeleniumDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MtsByTest extends BaseTest {
    private WebDriver driver = SeleniumDriver.getInstance();

    @BeforeEach
    public void homePage() throws InterruptedException {
        driver.get("https://www.mts.by");
        Thread.sleep(500);//Без таймера окно куки не успевает появиться, в результате провал теста
        driver.findElement(By.id("cookie-agree")).click();
    }

    @Test
    @DisplayName("Проверка названия блока платежей")
    public void sectionTitleCheck() {
        WebElement title = driver.findElement(By.xpath("//section[@class='pay']//h2"));
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", title.getText());
    }

    @Test
    @DisplayName("Проверка наличия логотипов платёжных систем")
    public void paymentSystemLogosCheck() {
        By visaLogo = By.xpath("//img[contains(@alt, 'Visa') or contains(@alt, 'Verified By Visa')]");
        By mastercardLogo = By.xpath("//img[contains(@src, 'MasterCard') or contains(@alt, 'MasterCard Secure Code')]");
        By belkartLogo = By.xpath("//img[contains(@alt, 'Белкарт')]");

        WebElement visa = driver.findElement(visaLogo);
        Assertions.assertTrue(visa.isDisplayed());

        WebElement mastercard = driver.findElement(mastercardLogo);
        Assertions.assertTrue(mastercard.isDisplayed());

        WebElement belkart = driver.findElement(belkartLogo);
        Assertions.assertTrue(belkart.isDisplayed());
    }

    @Test
    @DisplayName("Проверка работы ссылки «Подробнее о сервисе»")
    public void serviceDetailsCheck() {
        driver.findElement(By.xpath("//div[@class='pay__wrapper']/a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']")).click();
        driver.findElement(By.xpath("//body")).isDisplayed();
    }

    @Test
    @DisplayName("Заполнение полей и проверка работы кнопки «Продолжить»")
    public void fieldsFillingContinueCheck() throws InterruptedException {
        WebElement connectionPhone = driver.findElement(By.xpath("//section[@class='pay']//input[@id='connection-phone']"));
        WebElement connectionSum = driver.findElement(By.xpath("//section[@class='pay']//input[@id='connection-sum']"));
        WebElement connectionMail = driver.findElement(By.xpath("//section[@class='pay']//input[@id='connection-email']"));

        connectionPhone.sendKeys("297777777");
        connectionSum.sendKeys("5");
        connectionMail.sendKeys("email@mail.ru");
        driver.findElement(By.xpath("//form[@class='pay-form opened']/button[@class='button button__default ' and @type='submit']")).click();
        Thread.sleep(1000);

        By paymentContinueFrame = By.xpath("//iframe[@class='payment-widget-iframe']");
        WebElement paymentContinueFrameOpened = driver.findElement(paymentContinueFrame);
        Assertions.assertTrue(paymentContinueFrameOpened.isDisplayed());
        Thread.sleep(2000);
    }
}
