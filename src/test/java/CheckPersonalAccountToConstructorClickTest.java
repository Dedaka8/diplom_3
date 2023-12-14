import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;



public class CheckPersonalAccountToConstructorClickTest extends BaseTest {
    @Before
    public void start(){
        ValidatableResponse response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken").toString().substring(7);

    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор")
    public void checkConstructorLinkClick(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.headerPersonalAccountLinkClick();
        loginPage.setLogin(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.loginButtonClick();
        mainPage.headerPersonalAccountLinkClick();
        profilePage.headerConstructorLinkClick();
        Assert.assertTrue(mainPage.isDisplayedConstructorHeader());

    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор при клике на лого")
    public void checkLogoClick(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.headerPersonalAccountLinkClick();
        loginPage.setLogin(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.loginButtonClick();

        mainPage.headerPersonalAccountLinkClick();
        profilePage.headerBurgerLogoLinkClick();
        Assert.assertTrue(mainPage.isDisplayedConstructorHeader());
    }



}
