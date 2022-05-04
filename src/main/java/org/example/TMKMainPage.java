package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TMKMainPage extends AbstractPage {
    @FindBy(xpath = "//div[@class=\"header__aux\"]/ul/li[2]")
    private WebElement signIn;

    @FindBy(css = "aside.is-opened")
    private WebElement modalSignOpen;

    public TMKMainPage(WebDriver driver) {
        super(driver);
    }

    public void goToSignIn() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(signIn));
        this.signIn.click();
        //new WebDriverWait(getDriver(), Duration.ofSeconds(5))
        //        .until(ExpectedConditions.visibilityOf(modalSignOpen));
    }
    public void waitSignIn() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(modalSignOpen));
    }
}
