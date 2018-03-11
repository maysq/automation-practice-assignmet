package automation_practices;

import commons.read.ReadProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testng_config_methods.TestNGConfig;

/**
 * Created by Ismail on 3/4/2018.
 */
public class AddItems extends TestNGConfig {

    // Add Item URL
    String addItemURL = "?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
    // Web Driver Wait Object
    WebDriverWait webDriverWait = null;
    // Actions Object
    Actions actions = null;

    // Read By locators from properties file By locators
    String firstitemLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties","firstitemLocator");
    String firstItemAddCartBtnLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "firstItemAddCartBtnLocator");
    String proceedToCheckoutLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties","proceedToCheckoutLocator");
    String actualItem = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "actualItem");
    String expectedItem= ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties","expectedItem");

    @BeforeMethod
    public void setUpAddItem(){
        driver.navigate().to(baseURL + addItemURL);
        webDriverWait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
    }


    @Test(groups = "addItemsToCart")
    public void verifyValidAddItemToCart(){
        actions.moveToElement(webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath (firstitemLocator)))).perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath (firstItemAddCartBtnLocator))).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath (proceedToCheckoutLocator))).click();

        // Assertion Item added to cart
        String expectedItemText= driver.findElement (By.xpath(expectedItem)).getText ().toLowerCase ();
        String actualItemText= driver.findElement (By.id (actualItem)).getText ().toLowerCase ();
        System.out.println ("Expceted= "+ expectedItemText);
        System.out.println ("Actual = "+ actualItemText);
    }

}
