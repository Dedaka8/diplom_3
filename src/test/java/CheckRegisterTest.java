import data.UserCredentials;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

import static constants.Urls.REGISTER_PAGE_URL;

public class CheckRegisterTest extends BaseTest{
    @Before
    public void start(){
        driver.get(REGISTER_PAGE_URL);
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void checkSuccessRegisterTest(){
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.setName(user.getName());
        registerPage.setLogin(user.getEmail());
        registerPage.setPassword(user.getPassword());
        registerPage.registerButtonClick();
        Assert.assertTrue(loginPage.isDisplayedLoginForm());

        ValidatableResponse response = userClient.loginUser(UserCredentials.from(user));
        accessToken = response.extract().path("accessToken").toString().substring(7);



    }

    @Test
    @DisplayName("Ошибка регистрации при коротком пароле")
    public void checkShortPasswordRegisterTest(){

        RegisterPage registerPage = new RegisterPage(driver);


        registerPage.setName(user.getName());
        registerPage.setLogin(user.getEmail());
        registerPage.setPassword(user.getPassword().substring(0,5));
        registerPage.registerButtonClick();
        Assert.assertTrue(registerPage.isDisplayedErrorMessage());

    }
}
