package testng_config_methods;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Created by Ismail on 3/4/2018.
 */
public class TestNGConfig {
    protected static WebDriver driver = null;
    public static String baseURL = null;

    @BeforeTest
    @Parameters({"baseURL", "browser"})
    public void setUpScenario(String baseURL, String browser){
        this.baseURL = baseURL;
        switch (browser.toLowerCase()) {
            case "chrome": {
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            }
            default: {
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
            }
        }
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDownScenario()
    {
        driver.close();
    }

}
