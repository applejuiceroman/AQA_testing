package lesson_10.steps;
import org.openqa.selenium.WebElement;
import lesson_10.page.PaySectionPage;

import java.util.List;

public class PaySectionSteps {
    private PaySectionPage paySectionPage = new PaySectionPage();

    public String getTitle(){
        return paySectionPage.getTitle().getText();
    }

    public List<WebElement> getPayLogos(){
        return PaySectionPage.getPayLogos();
    }

}
