package lesson_10.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {

    // Локаторы для куки
    @FindBy(xpath = "//div[@class='cookie__wrapper']//button[text()='Отклонить']")
    private List<WebElement> cookieDeclineButton;

    // Вкладки различных услуг
    private final By serviceTabs = By.xpath("//div[contains(@class, 'pay__tabs')]//span");

    // Маппинг названий вкладок на их локаторы
    private final Map<String, By> tabLocators = new HashMap<>();

    public HomePage() {
        super();
        initTabLocators();
    }

    private void initTabLocators() {
        tabLocators.put("Услуги связи", By.xpath("//class[contains(text(),'Услуги связи')]"));
        tabLocators.put("Домашний интернет", By.xpath("//class[contains(text(),'Домашний интернет')]"));
        tabLocators.put("Рассрочка", By.xpath("//span[contains(text(),'Рассрочка')]"));
        tabLocators.put("Задолженность", By.xpath("//span[contains(text(),'Задолженность')]"));
    }

    // Открыть страницу
    public void open() {
        driver.get("https://www.mts.by");
    }

    // Закрыть окно cookie
    public void declineCookiesIfPresent() {
        if (!cookieDeclineButton.isEmpty() && cookieDeclineButton.get(0).isDisplayed()) {
            cookieDeclineButton.get(0).click();
        }
    }

    // Выбрать вкладку услуги
    public void selectServiceTab(String serviceName) {
        By tabLocator = tabLocators.get(serviceName);
        if (tabLocator != null) {
            wait.until(ExpectedConditions.elementToBeClickable(tabLocator)).click();
        } else {
            throw new IllegalArgumentException("Неизвестная услуга: " + serviceName);
        }
    }

    // Получить все надписи (плейсхолдеры) в полях для текущей выбранной услуги
    public List<String> getPlaceholdersForCurrentService() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[contains(@class, 'pay-form')]//input")));

        List<WebElement> inputFields = driver.findElements(By.xpath("//form[contains(@class, 'pay-form')]//input"));
        return inputFields.stream()
                .map(input -> input.getAttribute("placeholder"))
                .filter(placeholder -> placeholder != null && !placeholder.isEmpty())
                .toList();
    }

    // Получить все надписи в незаполненных полях для конкретной услуги
    public Map<String, List<String>> getAllServicePlaceholders() {
        Map<String, List<String>> servicePlaceholders = new HashMap<>();
        String[] services = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};

        for (String service : services) {
            selectServiceTab(service);
            try {
                Thread.sleep(500); // Небольшая задержка для загрузки формы
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<String> placeholders = getPlaceholdersForCurrentService();
            servicePlaceholders.put(service, placeholders);
        }

        return servicePlaceholders;
    }
}