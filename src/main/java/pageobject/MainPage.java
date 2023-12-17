package pageobject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {
    protected WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    protected void elementClick(By elem){
        driver.findElement(elem).click();
    }


    private final By headerPersonalAccountLink = By.xpath(".//p[text()='Личный Кабинет']/parent::a");


    private final By headerBurgerLogoLink = By.xpath(".//div[contains(@class,'AppHeader_header__logo__2D0X2')]//a");

    private final By headerConstructorLink = By.xpath(".//p[text()='Конструктор']/parent::a");

    private final By constructorHeader =By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10']");

    private final By orderButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");
    private final By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']");

    private final By constructorBun = By.xpath(".//span[text()='Булки']/parent::div");
    private final By constructorSauce = By.xpath(".//span[text()='Соусы']/parent::div");
    private final By constructorFilling = By.xpath(".//span[text()='Начинки']/parent::div");

    private final By constructorActiveBun = By.xpath(".//span[text()='Булки']/parent::div[contains(@class,'current')]");
    private final By constructorActiveSauce = By.xpath(".//span[text()='Соусы']/parent::div[contains(@class,'current')]");
    private final By constructorActiveFilling = By.xpath(".//span[text()='Начинки']/parent::div[contains(@class,'current')]");

    private final By fillingHeader = By.xpath(".//h2[text()='Начинки']");



    @Step("Нажатие на ссылку личного кабинета")
    public void headerPersonalAccountLinkClick(){
        elementClick(headerPersonalAccountLink);
    }

    @Step("Нажатие на ссылку конструктора в заголовке")
    public void headerConstructorLinkClick(){

        driver.findElement(headerConstructorLink).click();
    }
    @Step("Нажатие на лого")
    public void headerBurgerLogoLinkClick(){
        elementClick(headerBurgerLogoLink);
    }

    @Step("Проверка отображения оформить заказ на главной странице")
    public boolean isDisplayedOrderButton(){
        return driver.findElement(orderButton).isDisplayed();
    }
    @Step("Нажатие на кнопку войти на главной странице")
    public void loginButtonClick(){
        elementClick(loginButton);
    }
    @Step("Проверка отображения ссылки конструктор в заголовке")
    public boolean isDisplayedConstructorHeader() {
        return driver.findElement(constructorHeader).isDisplayed();
    }

    @Step("Нажатие на раздел булки в конструкторе")
    public void constructorBunClick(){

        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(constructorBun));

    }
    @Step("Нажатие на раздел соусы в конструкторе")
    public void constructorFillingClick(){
        elementClick(constructorFilling);

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.numberOfElementsToBe(constructorActiveBun,0));

    }
    @Step("Нажатие на раздел соусы в конструкторе")
    public void constructorSauceClick(){
            elementClick(constructorSauce);
        }
    @Step("Проверка отображения активного раздела булки в конструкторе")
    public boolean isDisplayedConstructorBun() {
//    
        return driver.findElement(constructorActiveBun).isDisplayed();
    }
    @Step("Проверка отображения активного раздела соусы в конструкторе")
    public boolean isDisplayedConstructorSauce() {
        return driver.findElement(constructorActiveSauce).isDisplayed();
    }
    @Step("Проверка отображения активного раздела начинки в конструкторе")
    public boolean isDisplayedConstructorFilling() {
        return driver.findElement(constructorActiveFilling).isDisplayed();
    }


}
