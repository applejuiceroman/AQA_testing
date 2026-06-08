package lesson_10.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {

    private final By serviceSelectField = By.xpath("//div[contains(@class, 'select__wrapper')]");

    private final By communicationServiceOption = By.xpath("//p[@class='select__option' and contains(text(), 'Услуги связи')]");
    private final By homeInternetOption = By.xpath("//p[@class='select__option' and contains(text(), 'Домашний интернет')]");
    private final By installmentOption = By.xpath("//p[@class='select__option' and contains(text(), 'Рассрочка')]");
    private final By debtOption = By.xpath("//p[@class='select__option' and contains(text(), 'Задолженность')]");


    private final Map<String, By> serviceOptionLocators = new HashMap<>();

    public HomePage() {
        super();
        initServiceLocators();
    }

    private void initServiceLocators() {
        serviceOptionLocators.put("Услуги связи", communicationServiceOption);
        serviceOptionLocators.put("Домашний интернет", homeInternetOption);
        serviceOptionLocators.put("Рассрочка", installmentOption);
        serviceOptionLocators.put("Задолженность", debtOption);
    }

    public void open() {
        driver.get("https://www.mts.by");
    }


    public void declineCookiesIfPresent() {
        try {
            List<WebElement> declineButtons = driver.findElements(By.xpath("//button[@class='btn btn_gray cookie__cancel']"));
            if (!declineButtons.isEmpty() && declineButtons.get(0).isDisplayed()) {
                declineButtons.get(0).click();
                return;
            }

            List<WebElement> agreeButtons = driver.findElements(By.id("cookie-agree"));
            if (!agreeButtons.isEmpty() && agreeButtons.get(0).isDisplayed()) {
                agreeButtons.get(0).click();
            }
        } catch (Exception e) {
            System.out.println("Окно куки не появилось или уже обработано");
        }
    }


    public void selectService(String serviceName) {

        try {
            WebElement selectField = wait.until(ExpectedConditions.elementToBeClickable(serviceSelectField));
            selectField.click();

            By optionLocator = serviceOptionLocators.get(serviceName);

            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
            wait.until(ExpectedConditions.elementToBeClickable(option));
            option.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(optionLocator));

        } catch (Exception e) {
            throw new RuntimeException("Не удалось выбрать услугу: " + serviceName, e);
        }
    }

    public String getSelectedService() {
        WebElement selectedField = wait.until(ExpectedConditions.visibilityOfElementLocated(serviceSelectField));
        return selectedField.getText();
    }

    public List<String> getPlaceholdersForCurrentService() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[contains(@class, 'pay-form opened')]//input")));

        List<WebElement> inputFields = driver.findElements(By.xpath("//form[contains(@class, 'pay-form opened')]//input"));

        return inputFields.stream()
                .map(input -> {
                    String placeholder = input.getAttribute("placeholder");
                    String label = input.getAttribute("data-placeholder");
                    return (placeholder != null && !placeholder.isEmpty()) ? placeholder : label;
                })
                .filter(text -> text != null && !text.isEmpty())
                .toList();
    }

    public Map<String, List<String>> getAllServicePlaceholders() {
        Map<String, List<String>> servicePlaceholders = new HashMap<>();
        String[] services = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};

        for (String service : services) {
            try {
                selectService(service);
                List<String> placeholders = getPlaceholdersForCurrentService();
                servicePlaceholders.put(service, placeholders);
            } catch (Exception e) {
                System.out.println("Ошибка при загрузке плейсхолдеров для: " + service);
                servicePlaceholders.put(service, List.of("Ошибка загрузки"));
            }
        }
        return servicePlaceholders;
    }
}