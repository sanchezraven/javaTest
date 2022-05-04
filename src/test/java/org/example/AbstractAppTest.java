package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public abstract class AbstractAppTest {

    static WebDriver webdriver;
    static EventFiringWebDriver eventDriver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");

        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));
    }

    @BeforeEach
    void goTo() throws InterruptedException {
        eventDriver.get("https://tmk:tmk@test-stock.tmk-group.com/");
        eventDriver.get("https://test-stock.tmk-group.com/");
        Thread.sleep(7000);
    }

    @AfterAll
    static void close() {
        eventDriver.quit();
    }

    public WebDriver getWebDriver() {
        return this.eventDriver;
    }
}
