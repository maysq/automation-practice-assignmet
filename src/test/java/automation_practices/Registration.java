package automation_practices;

import commons.read.ReadProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testng_config_methods.TestNGConfig;

/**
 * Created by Ismail on 3/4/2018.
 */
public class Registration extends TestNGConfig {
    // Registration URL
    String regURL = "?controller=authentication&back=my-account";
    // Wait Driver Object
    WebDriverWait webDriverWait = null;

    // Read By locators variables from properies file
    String emailLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "emailLocator");
    String createAccountButtonLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "createAccountButtonLocator");
    String mrTitleRadioLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "mrTitleRadioLocator");
    String firstNameLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "firstNameLocator");
    String lastNameLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "lastNameLocator");
    String passwordLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "passwordLocator");
    String DOBDaysLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "DOBDaysLocator");
    String DOBMonthsLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "DOBMonthsLocator");
    String DOBYearsLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "DOBYearsLocator");
    String addressFirstNameLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "addressFirstNameLocator");
    String addressLastNameLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "addressLastNameLocator");
    String addressFieldLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "addressFieldLocator");
    String addressCityLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "addressCityLocator");
    String addressStateLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "addressStateLocator");
    String addressPostalCodeLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "addressPostalCodeLocator");
    String addressCountryLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "addressCountryLocator");
    String addressMobileNoLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "addressMobileNoLocator");
    String addressAliasEmailLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "addressAliasEmailLocator");
    String submitRegistrationBtnLocator = ReadProperty.readProperty ("src/test/resources/properties_files/locators.properties", "submitRegistrationBtnLocator");

    @BeforeMethod
    public void setUpRegistration(){
        driver.navigate().to(baseURL + regURL);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @Test
    public void verifyValidRegistration(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(emailLocator))).sendKeys(Login.email);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(createAccountButtonLocator))).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mrTitleRadioLocator))).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(firstNameLocator))).sendKeys(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "firstName"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(lastNameLocator))).sendKeys(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "lastName"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(passwordLocator))).sendKeys(Login.password);

        Select daysSelect = new Select(driver.findElement(By.id(DOBDaysLocator)));
        daysSelect.selectByValue(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "day"));

        Select monthsSelect = new Select(driver.findElement(By.id(DOBMonthsLocator)));
        monthsSelect.selectByValue(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "month"));

        Select yearsSelect = new Select(driver.findElement(By.id(DOBYearsLocator)));
        yearsSelect.selectByValue(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "year"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(addressFirstNameLocator))).sendKeys(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "addressFirstName"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(addressLastNameLocator))).sendKeys(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "addressLastName"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(addressFieldLocator))).sendKeys(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "addressField"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(addressCityLocator))).sendKeys(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "addressCity"));

        Select stateSelect = new Select(driver.findElement(By.id(addressStateLocator)));
        stateSelect.selectByValue(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "addressState"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(addressPostalCodeLocator))).sendKeys(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "addressPostalCode"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(addressMobileNoLocator))).sendKeys(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "addressMobileNo"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(addressAliasEmailLocator))).sendKeys(ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "addressAliasEmail"));

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(submitRegistrationBtnLocator))).click();

        // Assertion statements
        // Check if displayed first name and last name is the same as registered
        String expectedName= ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "firstName")+ " " + ReadProperty.readProperty ("src/test/resources/properties_files/test_data.properties", "lastName");
        String displayedName= driver.findElement (By.xpath ("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]")).getText ();
        Assert.assertEquals (displayedName , expectedName, "The name of displayed user does not match registered user");

    }

}
