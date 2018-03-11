package automation_practices;

import commons.read.ReadProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testng_config_methods.TestNGConfig;

/**
 * Created by Ismail on 3/4/2018.
 */
public class Login extends TestNGConfig {

    String loginURL = "?controller=authentication&back=my-account";
    WebDriverWait webDriverWait = null;
    //Read locator value from properties file
    static public String usernameLocator= ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "usernameLocator");
    static public String passwordLocator= ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "passwordLocator");
    static public String signInLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "signInLocator");
    //Read Username and Password values from properties file
    static public String email = ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "username");
    static public String password = ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "password");

    @BeforeMethod
    public void setUpLogin(){
        // Navigate to login page
        driver.navigate().to(baseURL + loginURL);
        webDriverWait = new WebDriverWait (driver, 10);

    }
    //@Parameters({"email", "password"})
    @Test
    public void verifyValidLogin(){
        // Type username and password
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id (usernameLocator))).sendKeys (email);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id (passwordLocator))).sendKeys (password);
        // Click Login
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id (signInLocator))).click ();
        // Assert if I logged in successfully
        //Check that navigated URL is correct
        String currentURL = driver.getCurrentUrl();
        String expectedURL = baseURL + "?controller=my-account";
        String errorMsg = "Navigation after Sign-up fail";
        Assert.assertEquals(currentURL, expectedURL, errorMsg);

    }

}
