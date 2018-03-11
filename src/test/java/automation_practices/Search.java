package automation_practices;

import commons.read.ReadProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testng_config_methods.TestNGConfig;
import org.testng.Assert;

import java.security.spec.ECParameterSpec;
import java.util.List;

/**
 * Created by Ismail on 3/4/2018.
 */
public class Search extends TestNGConfig {

    // Search Page URL
    String searchURL = "";
    // Web Driver Wait Object
    WebDriverWait webDriverWait = null;

    //Read locator value from properties file
    String searchFieldLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "searchFieldLocator");
    String searchBtnLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "searchBtnLocator");

    //Read Search keyword from properies file
    String searchKeyword = ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "searchKeyword").toLowerCase ();

    // By locators object
//    By searchFieldLocator = By.id("search_query_top");
//    By searchBtnLocator = By.name("submit_search");


    // With keyword

    // Without Keyword


    @BeforeMethod
    public void setUpSearch ( ) {
        driver.navigate ( ).to (baseURL + searchURL);
        webDriverWait = new WebDriverWait (driver, 10);
    }

    @Test
    public void verifyValidSearchItems ( ) {
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.id (searchFieldLocator))).sendKeys (searchKeyword);
        webDriverWait.until (ExpectedConditions.visibilityOfElementLocated (By.name (searchBtnLocator))).click ( );
       SoftAssert softAssert= new SoftAssert ();
// Assertion of search
//Define a Web Element for container
        WebElement searchResultContainer = driver.findElement (By.xpath ("//*[@id=\"center_column\"]/ul"));
        //Define a List that contains all search results as "li" in container "ul"
        List <WebElement> searchResultsList = searchResultContainer.findElements (By.xpath ("//*[@id=\"center_column\"]/ul/li"));
        // Assert that each element in search result contains the search keyword.
        //The assertion will return false because the search results will contain wrong results.
        // Soft Assert is used to execute the test without stopping the scenario
        for (int i= 0; i< searchResultsList.size (); i++){
            String value = searchResultsList.get(i).getText ().toLowerCase ();
            softAssert.assertTrue (value.contains (searchKeyword));
            //If the following statement is used then the test will return "fail".
            //softAssert.assertAll ();
        }
    }

}
