package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends MainPage{

    public ProfilePage(WebDriver driver){
        super(driver);
    }

    private final By exitButton = By.xpath(".//li[@class='Account_listItem__35dAP']/button");
    private final By profileForm = By.xpath(".//div[@class='Profile_profile__3dzvr']");



    @Step("Нажатие на кнопку выхода из профиля")
    public void exitButtonClick(){
         elementClick(exitButton);

    }
    @Step("Проверка отображения профиля пользователя")
    public boolean isDisplayedProfileForm(){
        return driver.findElement(profileForm).isDisplayed();

    }


}
