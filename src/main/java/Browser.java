import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    public static WebDriver getDriver(BrowserType browserType) {

        switch (browserType) {
            case CHROME:

                return new ChromeDriver();

            case YANDEX:
               System.setProperty("webdriver.chrome.driver","C:/tools/yandexdriver.exe");
                return new ChromeDriver();

            default:
                throw new RuntimeException("Browser undefined");
        }

    }
}
