package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class ForgotPasswordPage extends MainPage{
    public ForgotPasswordPage(WebDriver driver){
        super(driver);
    }

    private final By loginLink = By.xpath(".//a[@class='Auth_link__1fOlj' and @href ='/login']");

    @Step("Нажатие на ссылку входа на странице забытого пароля")
    public void loginLinkClick(){

        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(loginLink));


    }

}
