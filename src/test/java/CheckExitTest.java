import data.UserCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import pageobject.RegisterPage;

import static constants.Urls.*;

public class CheckExitTest extends BaseTest{

    @Before
    public void start(){
        ValidatableResponse response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken").toString().substring(7);

    }

    @Test
    @DisplayName("Проверка выхода авторизованного пользователя")
    public void checkSuccessExitTest(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.headerPersonalAccountLinkClick();
        loginPage.setLogin(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.loginButtonClick();
        mainPage.headerPersonalAccountLinkClick();
        profilePage.exitButtonClick();
        Assert.assertTrue(loginPage.isDisplayedLoginForm());


    }



}
