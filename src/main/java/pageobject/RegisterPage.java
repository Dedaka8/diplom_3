package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class RegisterPage extends MainPage{
    public RegisterPage(WebDriver driver){
        super(driver);
    }

    private final By loginLink = By.xpath(".//a[text()='Войти']");
    private final By errorMessage = By.xpath(".//p[@class='input__error text_type_main-default']");
    private final By nameInput = By.xpath(".//label[text()='Имя']/parent::div/input");
    private final By loginInput = By.xpath(".//label[text()='Email']/parent::div/input");
    private final By passwordInput = By.xpath(".//input[@name='Пароль']");
    private final By registerButton = By.xpath(".//form/button");


    @Step("Нажатие кнопки зарегистрироваться на странице регистрации")
    public void registerButtonClick(){

        driver.findElement(registerButton).click();


    }
    @Step("Нажатие на ссылку входа на странице регистрации")
    public void loginLinkClick(){

        ((JavascriptExecutor)driver).executeScript("arguments[0].isClickable", driver.findElement(loginLink));
        elementClick(loginLink);

    }
    @Step("Заполнение email на странице регистрации")
    public void setLogin(String login) {
        driver.findElement(loginInput).clear();
        driver.findElement(loginInput).sendKeys(login);

    }

    @Step("Заполнение пароля на странице регистрации")
    public void setPassword(String password) {

        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }
    @Step("Заполнение имени на странице регистрации")
    public void setName(String name) {

        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Проверка отображения ошибки пароля на странице регистрации")
    public boolean isDisplayedErrorMessage(){
        return driver.findElement(errorMessage).isDisplayed();
    }

}
