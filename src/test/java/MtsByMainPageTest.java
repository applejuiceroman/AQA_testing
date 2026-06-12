import lesson_11.pages.HomePage;
import lesson_11.steps.PaymentPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByMainPageTest extends BasicTest {

    private HomePage homePage;
    private PaymentPage paymentPage;

    private static final String TEST_PHONE = "297777777";
    private static final String TEST_AMOUNT = "5";
    private static final String TEST_EMAIL = "email@mail.ru";

    @BeforeAll
    public static void createEnvironmentFile() {
        Properties props = new Properties();
        props.setProperty("Browser", "Chrome 149.0.7827.115");
        props.setProperty("Environment", "https://www.mts.by");
        props.setProperty("OS", System.getProperty("os.name"));
        props.setProperty("Java Version", System.getProperty("java.version"));

        String path = System.getProperty("user.dir") + "/target/allure-results/";
        new File(path).mkdirs();

        try (FileOutputStream fos = new FileOutputStream(path + "environment.properties")) {
            props.store(fos, "Allure Environment Properties");
        } catch (IOException e) {
            System.err.println("Не удалось создать файл окружения: " + e.getMessage());
        }
    }

    @BeforeEach
    public void setUpPage() {
        homePage = new HomePage();
        paymentPage = new PaymentPage();

        homePage.open();
        homePage.declineCookiesIfPresent();
    }

    @Test
    @DisplayName("Получение плейсхолдеров в незаполненных полях каждой услуги")
    public void checkPlaceholdersForAllServices() {
        Map<String, List<String>> servicePlaceholders = homePage.getAllServicePlaceholders();

        for (Map.Entry<String, List<String>> entry : servicePlaceholders.entrySet()) {
            String serviceName = entry.getKey();
            List<String> placeholders = entry.getValue();

            System.out.println("Услуга: " + serviceName);
            System.out.println("Плейсхолдеры в полях: " + placeholders);

            assertNotNull(placeholders, "Плейсхолдеры не должны быть пустыми для услуги: " + serviceName);
            assertFalse(placeholders.isEmpty(), "Должны быть поля для заполнения для услуги: " + serviceName);
            System.out.println();
        }
    }

    @Test
    @DisplayName("Заполнение формы «Услуги связи» и получение плейсхолдеров в незаполненных полях платёжного окна")
    public void checkPaymentFrameForCommunicationService() {
        homePage.selectService("Услуги связи");
        paymentPage.fillCommunicationForm(TEST_PHONE, TEST_AMOUNT, TEST_EMAIL);
        paymentPage.clickContinueButton();

        boolean framePresent = paymentPage.waitForPaymentFrame(10);
        assertTrue(framePresent, "Платёжное окно не появилось");

        System.out.println("\nСумма в окне: " + paymentPage.getAmountFromFrame());
        System.out.println("Номер телефона: " + paymentPage.getPhoneNumberFromFrame());
        System.out.println("Кнопка: " + paymentPage.getAmountOnPayButton());

        System.out.println("\nПлейсхолдеры полей данных карты: " + paymentPage.getCardInputPlaceholders());
        System.out.println("Иконки платёжных систем: " + (paymentPage.areAllPaymentIconsDisplayed() ? "есть" : "нет"));

        assertNotNull(paymentPage.getAmountFromFrame(), "Сумма должна отображаться");
        assertNotNull(paymentPage.getPhoneNumberFromFrame(), "Номер телефона должен отображаться");
        assertTrue(paymentPage.areAllPaymentIconsDisplayed(), "Иконки платёжных систем должны отображаться");

        paymentPage.switchToDefaultContent();
    }
}