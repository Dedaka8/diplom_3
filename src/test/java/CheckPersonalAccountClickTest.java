import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

import static constants.Urls.LOGIN_PAGE_URL;
import static constants.Urls.MAIN_PAGE_URL;

public class CheckPersonalAccountClickTest extends BaseTest{
    @Before
    public void start(){
        ValidatableResponse response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken").toString().substring(7);

    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет автаризованного пользователя")
    public void checkPersonalAccountAuthUserClick(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.headerPersonalAccountLinkClick();
        loginPage.setLogin(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.loginButtonClick();
        mainPage.headerPersonalAccountLinkClick();
        Assert.assertTrue(profilePage.isDisplayedProfileForm());
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет неавтаризованного пользователя")
    public void checkPersonalAccountNotAuthUserClick(){

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.headerPersonalAccountLinkClick();
        Assert.assertTrue(loginPage.isDisplayedLoginForm());
    }


}
