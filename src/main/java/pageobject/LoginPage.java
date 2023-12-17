package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends MainPage{

    public LoginPage(WebDriver driver){
        super(driver);
    }
    private final By loginInput = By.xpath(".//input[@name='name']");
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");
    private final By loginButton = By.xpath(".//form/button");

    private final  By loginForm = By.xpath(".//div[@class='Auth_login__3hAey']");


    @Step("Заполнение email на странице авторизации")
    public void setLogin(String login) {
        driver.findElement(loginInput).clear();
        driver.findElement(loginInput).sendKeys(login);

    }

    @Step("Заполнение пароля на странице авторизации")
    public void setPassword(String password) {

        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);

    }
    @Step("Нажатие кнопки входа на странице авторизации")
    public void loginButtonClick(){
        elementClick(loginButton);

    }
    @Step("Проверка отображения формы входа пользователя")
    public boolean isDisplayedLoginForm(){
        return driver.findElement(loginForm).isDisplayed();
    }
}
