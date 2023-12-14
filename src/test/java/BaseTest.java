import static constants.Urls.*;
import static constants.Timeouts.*;


import client.UserClient;
import data.UserData;
import data.UserGenerator;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    protected UserClient userClient;
    protected String accessToken;
    protected UserData user;

    @Before
    public void startUp(){


       driver = Browser.getDriver(BrowserType.CHROME);


        userClient = new UserClient();
        user = UserGenerator.getRandomUser();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        driver.get(MAIN_PAGE_URL);
        driver.manage().window().maximize();


    }
    @After
    public void tearDown(){

        if(accessToken != null) {
            userClient.deleteUser(accessToken);

        }

        driver.quit();
    }

}
