import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.MainPage;

public class CheckConstructorNavigationTest extends BaseTest{

    @Test
    @DisplayName("Проверка перехода к разделу булки в конструкторе")
    public void checkBunClickTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.constructorFillingClick();
        Thread.sleep(1000);
        mainPage.constructorBunClick();
        Assert.assertTrue(mainPage.isDisplayedConstructorBun());


    }
    @Test
    @DisplayName("Проверка перехода к разделу соусы в конструкторе")
    public void checkSauceClickTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.constructorSauceClick();
        Assert.assertTrue(mainPage.isDisplayedConstructorSauce());

    }
    @Test
    @DisplayName("Проверка перехода к разделу начинки в конструкторе")
    public void checkFillingClickTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.constructorFillingClick();
        Assert.assertTrue(mainPage.isDisplayedConstructorFilling());

    }


}
