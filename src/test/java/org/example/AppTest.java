package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest extends AbstractAppTest {

    @Test
    void loginIn() throws InterruptedException {
        new TMKMainPage(getWebDriver()).goToSignIn();
        new TMKMainPage(getWebDriver()).waitSignIn();
        new LoginPage(getWebDriver())
                .loginIn("vav+2017@d-element.ru", "ybK~N@?vi|ba1");
        Thread.sleep(2000);
        new TMKMainPage(getWebDriver()).goToSignIn();
        Assertions.assertTrue(getWebDriver().getTitle().equals("Профиль"), "Страница аккаунта недоступна");
    }

}
