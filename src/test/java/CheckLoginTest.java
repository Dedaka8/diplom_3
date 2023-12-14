import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;
import pageobject.ForgotPasswordPage;

import static constants.Urls.*;

public class CheckLoginTest extends BaseTest {

    @Before
    public void start(){
        ValidatableResponse response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken").toString().substring(7);
    }


    @Test
    @DisplayName("Проверка входа через кнопку личный кабинет")
    public void checkLoginHeaderTest(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.headerPersonalAccountLinkClick();
        loginPage.setLogin(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.loginButtonClick();
        Assert.assertTrue(mainPage.isDisplayedOrderButton());

    }

    @Test
    @DisplayName("Проверка входа через кнопку войти на главной странице")
    public void checkLoginLoginButtonTest(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.loginButtonClick();
        loginPage.setLogin(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.loginButtonClick();

        Assert.assertTrue(mainPage.isDisplayedOrderButton());

    }

    @Test
    @DisplayName("Проверка входа через ссылку на странице регистрации")
    public void checkLoginRegisterLinkTest(){
        driver.get(REGISTER_PAGE_URL);
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.loginLinkClick();
        loginPage.setLogin(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.loginButtonClick();

        Assert.assertTrue(mainPage.isDisplayedOrderButton());

    }

    @Test
    @DisplayName("Проверка входа через ссылку на странице забытого пароля")
    public void checkLoginForgotPasswordLinkTest(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.get(FORGOT_PASSWORD_PAGE_URL);
        forgotPasswordPage.loginLinkClick();
        loginPage.setLogin(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.loginButtonClick();

        Assert.assertTrue(mainPage.isDisplayedOrderButton());
    }

}
