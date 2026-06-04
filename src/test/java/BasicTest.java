import io.github.bonigarcia.wdm.WebDriverManager;
import lesson_10.driver.SeleniumDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasicTest {

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        SeleniumDriver.setOptions(options);
    }

    @AfterAll
    public static void tearDown() {
        SeleniumDriver.getInstance().quit();
    }
}
