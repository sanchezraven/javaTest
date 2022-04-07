package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest extends AbstractAppTest
{
    //static Logger logger = LoggerFactory.getLogger(AppTest.class);
    @Test
    void myActionTest() throws InterruptedException {
        getDriver().findElement(By.xpath("//div[@class=\"header__aux\"]/ul/li/button")).click();
        Thread.sleep(2000);
        Actions loginIn = new Actions(getDriver());

        loginIn.sendKeys(getDriver().findElement(By.xpath("//input[@id=\"form-auth-email\"]")),
                "vav+2017@d-element.ru")
                .click(getDriver().findElement(By.xpath("//input[@id=\"form-auth-password\"]")))
                .sendKeys("ybK~N@?vi|ba1")
                .click(getDriver().findElement(By.xpath("//button[@class=\"btn btn--full-width\"]")))
                .build()
                .perform();

        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//li[@class=\"header__actions-item\"]/a[@href=\"/personal/\"]")).click();
        Assertions.assertTrue(getDriver().findElement(By.xpath("//h1")).getText().equals("Профиль"));
    }

}
