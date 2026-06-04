package lesson_10.page;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class PaySectionPage {
    @FindBy(xpath = "//div[@id='pay-section']//section[@class='pay']//h2");
    private WebElement title;
    return this;

    @FindBy(xpath = "//div[@id='pay-section']//div[@class='pay__partners']//li/img");
    private WebElement payLogos;

    @FindBy(xpath = "//form[@id='pay-form opened']//button[@type='submit']");
    private WebElement continueButton;

    @FindBy(xpath = "//section[@class='pay']//input[@id='connection-phone']");
    private WebElement phoneField;

    @FindBy(xpath = "//section[@class='pay']//input[@id='connection-sum']");
    private WebElement sumField;

    @FindBy(xpath = "//section[@class='pay']//input[@class='connection-email']");
    private WebElement emailField;

}
