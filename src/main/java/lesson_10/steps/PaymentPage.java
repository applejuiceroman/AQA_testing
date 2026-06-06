package lesson_10.steps;

import lesson_10.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class PaymentPage extends BasePage {

    // Поля ввода для услуги связи
    @FindBy(xpath = "//form[contains(@class, 'pay-form')]//input[@id='connection-phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//form[contains(@class, 'pay-form')]//input[@id='connection-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//form[contains(@class, 'pay-form')]//input[@id='connection-email']")
    private WebElement emailInput;

    // Кнопка "Продолжить"
    @FindBy(xpath = "//form[contains(@class, 'pay-form')]//button[@type='submit']")
    private WebElement continueButton;

    // Платежный фрейм
    private final By paymentFrame = By.xpath("//iframe[contains(@class, 'app-wrapper__content ng-tns-c107495084-0')]");

    // Элементы внутри платежного фрейма
    private final By frameAmount = By.xpath("//span[contains(@class, 'amount')]");
    private final By framePhoneNumber = By.xpath("//span[contains(@class, 'phone')]");
    private final By frameCardNumberInput = By.xpath("//input[@placeholder='Номер карты']");
    private final By frameCardExpiryInput = By.xpath("//input[@placeholder='Срок действия']");
    private final By frameCardCvvInput = By.xpath("//input[@placeholder='CVC']");
    private final By frameCardholderNameInput = By.xpath("//input[@placeholder='Имя держателя (как на карте)']");
    private final By framePaymentSystems = By.xpath("//img[contains(@src, 'visa') or contains(@src, 'mastercard') or contains(@src, 'belkart')]");
    private final By framePayButton = By.xpath("//button[contains(text(), 'Оплатить')]");

    public PaymentPage() {
        super();
    }

    // Заполнить номер телефона
    public void enterPhoneNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    // Заполнить сумму
    public void enterAmount(String amount) {
        sumInput.clear();
        sumInput.sendKeys(amount);
    }

    // Заполнить email
    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    // Заполнить форму для услуги связи
    public void fillCommunicationForm(String phone, String amount, String email) {
        enterPhoneNumber(phone);
        enterAmount(amount);
        enterEmail(email);
    }

    // Нажать кнопку "Продолжить"
    public void clickContinueButton() {
        continueButton.click();
    }

    // Переключиться на платежный фрейм
    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
    }

    // Переключиться обратно на основной контент
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // Получить сумму из платежного фрейма
    public String getAmountFromFrame() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(frameAmount));
        return driver.findElement(frameAmount).getText();
    }

    // Получить номер телефона из платежного фрейма
    public String getPhoneNumberFromFrame() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(framePhoneNumber));
        return driver.findElement(framePhoneNumber).getText();
    }

    // Получить сумму на кнопке "Оплатить"
    public String getAmountOnPayButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(framePayButton));
        return driver.findElement(framePayButton).getText();
    }

    // Получить все плейсхолдеры полей ввода карты
    public List<String> getCardInputPlaceholders() {
        By[] inputLocators = {frameCardNumberInput, frameCardExpiryInput, frameCardCvvInput, frameCardholderNameInput};
        return List.of(inputLocators).stream()
                .map(locator -> driver.findElement(locator).getAttribute("placeholder"))
                .toList();
    }

    // Проверить наличие иконок платежных систем
    public boolean arePaymentSystemIconsDisplayed() {
        List<WebElement> icons = driver.findElements(framePaymentSystems);
        return icons.size() >= 3; // Visa, Mastercard, Белкарт
    }

    // Дождаться появления платежного фрейма
    public boolean waitForPaymentFrame(int seconds) {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}