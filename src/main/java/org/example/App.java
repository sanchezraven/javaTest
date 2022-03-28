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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://tmk:tmk@test-stock.tmk-group.com/");
        Thread.sleep(10000);

        driver.findElement(By.xpath("//div[@class=\"header__aux\"]/ul/li/button")).click();
        driver.findElement(By.xpath("//input[@id=\"form-auth-email\"]")).sendKeys("info@d-element.ru");
        driver.findElement(By.xpath("//input[@id=\"form-auth-password\"]")).sendKeys("p4Tu|6l{Gg?p");
        driver.quit();
    }
}
