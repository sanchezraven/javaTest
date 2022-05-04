package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id=\"form-auth-email\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id=\"form-auth-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class=\"btn btn--full-width\"]")
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginIn(String email, String password) {

        Actions action = new Actions(getDriver());
        action.sendKeys(this.emailInput, email)
                .sendKeys(this.passwordInput, password)
                .click(this.submit)
                .build()
                .perform();
    }
}
