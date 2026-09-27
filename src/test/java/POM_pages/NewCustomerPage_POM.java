package POM_pages;


import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility_Files.Wait_Utility;
import helper.BasePage;

public class NewCustomerPage_POM extends BasePage {

    private Logger log = LogManager.getLogger(NewCustomerPage_POM.class);
    private WebElement generatedCustomerIdElement;

    public String getGeneratedCustomerId() {
        WebElement element = waitUtility.waitForVisibility(generatedCustomerIdElement);
        return element.getText().trim();
    }

    public NewCustomerPage_POM(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

   
    // Locators
    

    @FindBy(linkText = "New Customer")
    private WebElement newCustomer;

    @FindBy(name = "name")
    private WebElement customerName;

    @FindBy(xpath = "//input[@value='m']")
    private WebElement male;

    @FindBy(xpath = "//input[@value='f']")
    private WebElement female;

    @FindBy(name = "dob")
    private WebElement dateOfBirth;

    @FindBy(name = "addr")
    private WebElement address;

    @FindBy(name = "city")
    private WebElement city;

    @FindBy(name = "state")
    private WebElement state;

    @FindBy(name = "pinno")
    private WebElement pin;

    @FindBy(name = "telephoneno")
    private WebElement mobileNumber;

    @FindBy(name = "emailid")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "sub")
    private WebElement submit;

    @FindBy(name = "res")
    private WebElement reset;


  
    // Click New Customer
   

    public void clickNewCustomer() {


    	waitUtility.waitForClickable(newCustomer).click();

        log.info("Clicked New Customer");
    }


    
    // Customer Name
   

    public void enterCustomerName(String name) {

    	WebElement element =
                waitUtility.waitForVisibility(customerName);

        element.clear();
        element.sendKeys(name);

        log.info("Customer Name entered: " + name);


    }



    // Gender
    

    public void selectMale() {


        waitUtility.waitForClickable(male).click();
        log.info("Male selected");
    }


    public void selectFemale(String string) {


    	  waitUtility.waitForClickable(female).click();
    	  log.info("Female selected"+ string);
    }


   
    // Date of Birth
    

    public void enterDateOfBirth(String dob) {


    	 WebElement element =
    	            waitUtility.waitForVisibility(dateOfBirth);

    	    element.clear();
    	    element.sendKeys(dob);


        log.info("Date of Birth entered: " + dob);
    }


    
    // Address
    

    public void enterAddress(String customerAddress) {

        address.clear();
        address.sendKeys(customerAddress);

        log.info("Address entered: " + customerAddress);
    }



    // City
   

    public void enterCity(String customerCity) {

        city.clear();
        city.sendKeys(customerCity);

        log.info("City entered: " + customerCity);
    }


    
    // State
    

    public void enterState(String customerState) {

        state.clear();
        state.sendKeys(customerState);

        log.info("State entered: " + customerState);
    }


    
    // PIN
   

    public void enterPin(String customerPin) {

        pin.clear();
        pin.sendKeys(customerPin);

        log.info("PIN entered: " + customerPin);
    }


 
    // Mobile Number
   

    public void enterMobileNumber(String mobile) {

        mobileNumber.clear();
        mobileNumber.sendKeys(mobile);

        log.info("Mobile Number entered: " + mobile);
    }


    
    // Email
   

    public void enterEmail(String customerEmail) {

        email.clear();
        email.sendKeys(customerEmail);

        log.info("Email entered: " + customerEmail);
    }


  
    // Password
    

    public void enterPassword(String customerPassword) {

        password.clear();
        password.sendKeys(customerPassword);

        log.info("Password entered");
    }



    // Check All Fields
    

    public void checkAllFields() {

        log.info("========== Checking New Customer Fields ==========");

        log.info("Name: " + customerName.getAttribute("value"));
        log.info("DOB: " + dateOfBirth.getAttribute("value"));
        log.info("Address: " + address.getAttribute("value"));
        log.info("City: " + city.getAttribute("value"));
        log.info("State: " + state.getAttribute("value"));
        log.info("PIN: " + pin.getAttribute("value"));
        log.info("Mobile: " + mobileNumber.getAttribute("value"));
        log.info("Email: " + email.getAttribute("value"));
        log.info("Password: " + password.getAttribute("value"));

        log.info("Male selected: " + male.isSelected());
        log.info("Female selected: " + female.isSelected());

        log.info("================================================");
    }


    
    // Click Submit
    

    public void clickSubmit() {


    	 WebElement element =
    	            waitUtility.waitForClickable(submit);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );

        js.executeScript(
                "arguments[0].click();",
                element
        );

        log.info("Clicked Submit");

        // Handle alert
        try {
        	Alert alert = waitUtility.waitForAlert();

            String alertMessage = alert.getText();

            log.info("Alert Message: " + alertMessage);

            alert.accept();

            log.info("Alert accepted");

        } catch (Exception e) {

            log.info("No alert displayed after Submit");


        }
    }


    
    // Reset
  

    public void clickReset() {


    	 waitUtility.waitForClickable(reset).click();

    	    log.info("Clicked Reset");
    }


   
    // Complete New Customer
    

    public void createNewCustomer(
            String name,
            String dob,
            String customerAddress,
            String customerCity,
            String customerState,
            String customerPin,
            String mobile,
            String customerEmail,
            String customerPassword) {

        enterCustomerName(name);

        selectMale();

        enterDateOfBirth(dob);

        enterAddress(customerAddress);

        enterCity(customerCity);

        enterState(customerState);

        enterPin(customerPin);

        enterMobileNumber(mobile);

        enterEmail(customerEmail);

        enterPassword(customerPassword);

        // Check values before Submit
        checkAllFields();

        clickSubmit();

        log.info("New Customer form submitted");
    }
}

