package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://tmk:tmk@test-stock.tmk-group.com/");
        driver.get("https://test-stock.tmk-group.com/");
        Thread.sleep(7000);

        driver.findElement(By.xpath("//div[@class=\"header__aux\"]/ul/li/button")).click();
        driver.findElement(By.xpath("//input[@id=\"form-auth-email\"]")).sendKeys("vav+2017@d-element.ru");
        driver.findElement(By.xpath("//input[@id=\"form-auth-password\"]")).sendKeys("ybK~N@?vi|ba1");
        driver.findElement(By.xpath("//button[@class=\"btn btn--full-width\"]")).submit();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div/ul/li/a[@href=\"/personal/\"]")).click();
        Thread.sleep(500);
        String profile = driver.findElement(By.xpath("//header/h1")).getText();
        if (profile == "Профиль"){
            System.out.println("Зашел");
        }
        driver.quit();
    }
}
