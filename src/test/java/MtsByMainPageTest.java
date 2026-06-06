import lesson_10.pages.HomePage;
import lesson_10.steps.PaymentPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByMainPageTest extends BasicTest {

    private HomePage homePage;
    private PaymentPage paymentPage;

    // Тестовые данные
    private static final String TEST_PHONE = "297777777";
    private static final String TEST_AMOUNT = "5";
    private static final String TEST_EMAIL = "email@mail.ru";

    @BeforeEach
    public void homePage() {
        homePage = new HomePage();
        paymentPage = new PaymentPage();

        homePage.open();
        homePage.declineCookiesIfPresent();
    }

    // ==================== ТЕСТ 1 ====================
    @Test
    @DisplayName("1. Проверка надписей в незаполненных полях каждого варианта оплаты")
    public void checkPlaceholdersForAllServices() {
        Map<String, List<String>> servicePlaceholders = homePage.getAllServicePlaceholders();

        System.out.println("=== Проверка плейсхолдеров для всех услуг ===\n");

        for (Map.Entry<String, List<String>> entry : servicePlaceholders.entrySet()) {
            String serviceName = entry.getKey();
            List<String> placeholders = entry.getValue();

            System.out.println("📌 Услуга: " + serviceName);
            System.out.println("   Надписи в полях:");

            assertNotNull(placeholders, "Плейсхолдеры не должны быть null для услуги: " + serviceName);
            assertFalse(placeholders.isEmpty(), "Должны быть поля для заполнения для услуги: " + serviceName);

            for (String placeholder : placeholders) {
                System.out.println("      - " + placeholder);
                assertNotNull(placeholder, "Плейсхолдер не должен быть null");
                assertFalse(placeholder.isEmpty(), "Плейсхолдер не должен быть пустым");
            }
            System.out.println();
        }
    }

    // ==================== ТЕСТ 2 ====================
    @Test
    @DisplayName("2. Заполнение формы «Услуги связи» и проверка данных в платежном окне")
    public void checkPaymentFrameForCommunicationService() {
        // 2.1 Выбираем услугу связи
        homePage.selectServiceTab("Услуги связи");

        // 2.2 Заполняем поля
        paymentPage.fillCommunicationForm(TEST_PHONE, TEST_AMOUNT, TEST_EMAIL);

        // 2.3 Нажимаем кнопку "Продолжить"
        paymentPage.clickContinueButton();

        // 2.4 Проверяем, что появился платежный фрейм
        boolean framePresent = paymentPage.waitForPaymentFrame(5);
        assertTrue(framePresent, "Платежный фрейм не появился");

        // 2.5 Переключаемся во фрейм
        paymentPage.switchToPaymentFrame();

        System.out.println("\n=== Проверка данных в платежном окне ===\n");

        // 2.6 Проверка корректности отображения суммы
        String amountInFrame = paymentPage.getAmountFromFrame();
        System.out.println("💰 Сумма в окне: " + amountInFrame);
        assertNotNull(amountInFrame, "Сумма должна отображаться");
        assertTrue(amountInFrame.contains(TEST_AMOUNT),
                "Сумма в окне должна содержать " + TEST_AMOUNT + ", актуально: " + amountInFrame);

        // 2.7 Проверка номера телефона
        String phoneInFrame = paymentPage.getPhoneNumberFromFrame();
        System.out.println("📞 Номер телефона: " + phoneInFrame);
        assertNotNull(phoneInFrame, "Номер телефона должен отображаться");
        assertTrue(phoneInFrame.contains(TEST_PHONE),
                "Номер телефона должен содержать " + TEST_PHONE + ", актуально: " + phoneInFrame);

        // 2.8 Проверка суммы на кнопке "Оплатить"
        String amountOnButton = paymentPage.getAmountOnPayButton();
        System.out.println("🔘 Кнопка: " + amountOnButton);
        assertNotNull(amountOnButton, "На кнопке должна быть сумма");
        assertTrue(amountOnButton.contains(TEST_AMOUNT),
                "На кнопке должна быть сумма " + TEST_AMOUNT + ", актуально: " + amountOnButton);

        // 2.9 Проверка надписей в незаполненных полях для ввода реквизитов карты
        List<String> cardInputPlaceholders = paymentPage.getCardInputPlaceholders();
        System.out.println("\n💳 Надписи в полях для ввода карты:");

        String[] expectedPlaceholders = {"Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)"};

        for (int i = 0; i < cardInputPlaceholders.size(); i++) {
            System.out.println("   - " + cardInputPlaceholders.get(i));
            assertEquals(expectedPlaceholders[i], cardInputPlaceholders.get(i),
                    "Плейсхолдер должен быть: " + expectedPlaceholders[i]);
        }

        // 2.10 Проверка наличия иконок платёжных систем
        boolean iconsPresent = paymentPage.arePaymentSystemIconsDisplayed();
        System.out.println("\n🏦 Иконки платежных систем: " + (iconsPresent ? "присутствуют" : "отсутствуют"));
        assertTrue(iconsPresent, "Иконки платежных систем (Visa, Mastercard, Белкарт) должны отображаться");

        // 2.11 Возвращаемся к основному контенту
        paymentPage.switchToDefaultContent();

        System.out.println("\n✅ Все проверки успешно пройдены!");
    }
}