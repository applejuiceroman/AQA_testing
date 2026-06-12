package lesson_11.steps;

import io.qameta.allure.Step;
import lesson_11.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentPage extends BasePage {

    private final By phoneInput = By.xpath("//input[@id='connection-phone'] | //input[contains(@placeholder, 'Номер')]");
    private final By sumInput = By.xpath("//input[@id='connection-sum'] | //input[contains(@placeholder, 'Сумма')]");
    private final By emailInput = By.xpath("//input[@id='connection-email'] | //input[contains(@placeholder, 'Email')]");
    private final By continueButton = By.xpath("//button[contains(text(), 'Продолжить')]");
    private final By paymentFrame = By.xpath("//iframe[contains(@class, 'payment-widget-iframe')]");

    private final By frameAmount = By.xpath("//div[contains(@class, 'pay-description__cost')]");
    private final By framePhoneNumber = By.xpath("//div[contains(@class, 'pay-description__text')]");
    private final By framePayButton = By.xpath("//button[contains(@type, 'submit')]");

    private final By frameCardNumberInput = By.xpath("//label[@class='ng-tns-c2312288139-2 ng-star-inserted']");
    private final By frameCardExpiryInput = By.xpath("//label[@class='ng-tns-c2312288139-4 ng-star-inserted']");
    private final By frameCardCvvInput = By.xpath("//label[@class='ng-tns-c2312288139-5 ng-star-inserted']");
    private final By frameCardholderNameInput = By.xpath("//label[@class='ng-tns-c2312288139-3 ng-star-inserted']");

    private final By visaIcon = By.xpath("//img[contains(@src, 'visa')]");
    private final By mastercardIcon = By.xpath("//img[contains(@src, 'mastercard')]");
    private final By belkartIcon = By.xpath("//img[contains(@src, 'belkart')]");
    private final By maestromirIcon = By.xpath("//img[contains(@src, 'maestro')] | //img[contains(@src, 'mir')]");

    @Step("Проверяем наличие логотипов платёжных систем в окне платежа")
    public boolean areAllPaymentIconsDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

            wait.until(ExpectedConditions.visibilityOfElementLocated(visaIcon));
            wait.until(ExpectedConditions.visibilityOfElementLocated(mastercardIcon));
            wait.until(ExpectedConditions.visibilityOfElementLocated(belkartIcon));
            wait.until(ExpectedConditions.visibilityOfElementLocated(maestromirIcon));

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public PaymentPage() {
        super();
    }

    @Step("Вводим номер телефона")
    public void enterPhoneNumber(String phone) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneInput));
        element.clear();
        element.sendKeys(phone);
    }

    @Step("Вводим сумму платежа")
    public void enterAmount(String amount) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(sumInput));
        element.clear();
        element.sendKeys(amount);
    }

    @Step("Вводим адрес электронной почты")
    public void enterEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        element.clear();
        element.sendKeys(email);
    }

    public void fillCommunicationForm(String phone, String amount, String email) {
        enterPhoneNumber(phone);
        enterAmount(amount);
        enterEmail(email);
    }

    @Step("Нажимаем кнопку «Продолжить»")
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    @Step("Ожидаем появления платёжного окна")
    public boolean waitForPaymentFrame(int seconds) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
            return true;
        } catch (Exception e) {
            System.out.println("Платёжное окно не найдено: " + e.getMessage());
            return false;
        }
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    @Step("Получаем ранее введённую сумму платежа из платёжного окна")
    public String getAmountFromFrame() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(frameAmount));
        return element.getText();
    }

    @Step("Получаем ранее введённый номер телефона из платежного окна")
    public String getPhoneNumberFromFrame() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(framePhoneNumber));
        String fullText = element.getText();

        Pattern pattern = Pattern.compile("375\\d{9}");
        Matcher matcher = pattern.matcher(fullText.replaceAll("\\s", ""));

        if (matcher.find()) {
            return matcher.group();
        }

        throw new RuntimeException("Не удалось извлечь номер телефона из текста: " + fullText);
    }

    @Step("Получаем сумму платежа, указанную в кнопке «Оплатить»")
    public String getAmountOnPayButton() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(framePayButton));
        return element.getText();
    }

    @Step("Получаем плейсхолдеры полей данных карты")
    public List<String> getCardInputPlaceholders() {
        List<By> locators = List.of(frameCardNumberInput, frameCardExpiryInput, frameCardCvvInput, frameCardholderNameInput);

        return locators.stream()
                .map(locator -> {
                    try {
                        return driver.findElement(locator).getText();
                    } catch (Exception e) {
                        return "не найден";
                    }
                })
                .toList();
    }
}
