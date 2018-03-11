package automation_practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testng_config_methods.TestNGConfig;

/**
 * Created by Ismail on 3/4/2018.
 */
public class CheckoutProcess extends TestNGConfig{

    WebDriverWait webDriverWait = null;
    //By Locators
    By chkOutBtn= By.xpath ("//*[@id=\"center_column\"]/p[2]/a[1]");
    By chkOutAddressBtn = By.name ("processAddress");
    By agreementChkBox= By.xpath ("//*[@id=\"uniform-cgv\"]");
    By shippingBtn= By.name ("processCarrier");
    By payByBankBtn= By.xpath ("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p");
    By confirmBtn= By.xpath ("//*[@id=\"cart_navigation\"]/button");


    @BeforeMethod
    public void setUpAddItem(){

        webDriverWait = new WebDriverWait (driver, 10);

    }
    @Test
    public void verifyCheckOutSuccessful()
    {
        //Check if user is logged
              webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (chkOutBtn)).click ( );
            //Check if user is logged in by checking if the 'Sign Out' button is displayed
        Boolean isLoggedIn = (driver.findElement (By.xpath ("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]")).getText ().trim ()).equals ("Sign out");
      //If user is not logged in then sign in
        if (!isLoggedIn) {
            //Sign In
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id (Login.usernameLocator))).sendKeys (Login.email);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id (Login.passwordLocator))).sendKeys (Login.password);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id (Login.signInLocator))).click ();
        }
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (chkOutAddressBtn)).click ( );
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (agreementChkBox)).click ( );
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (shippingBtn)).click ( );
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (payByBankBtn)).click ( );
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (confirmBtn)).click ( );
    }
}
