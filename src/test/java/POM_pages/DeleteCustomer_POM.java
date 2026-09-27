package POM_pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.BasePage;

public class DeleteCustomer_POM extends BasePage {

    private Logger log =
            LogManager.getLogger(DeleteCustomer_POM.class);

    public DeleteCustomer_POM(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Delete Customer menu
    @FindBy(linkText = "Delete Customer")
    private WebElement deleteCustomer;

    // Customer ID textbox
    @FindBy(name = "cusid")
    private WebElement customerId;

    // Submit button
    @FindBy(name = "AccSubmit")
    private WebElement submit;

    // Reset button
    @FindBy(name = "res")
    private WebElement reset;


    public void openDeleteCustomerPage() {

        driver.get(
            "https://demo.guru99.com/V4/deleteCustomerInput.php"
        );

        log.info("Opened Delete Customer page");
    
    }
    
    // CLICK DELETE CUSTOMER MENU
  

    public void clickDeleteCustomer() {

        WebElement element =
                waitUtility.waitForClickable(deleteCustomer);

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

        log.info("Clicked Delete Customer");
    }


    
    // ENTER CUSTOMER ID
  

    public void enterCustomerId(String id) {

        WebElement element =
                waitUtility.waitForVisibility(customerId);

        element.clear();
        element.sendKeys(id);

        log.info("Customer ID entered: " + id);
    }


    
    // CLICK SUBMIT
   

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

        log.info("Clicked Delete Customer Submit");

        try {

            Alert alert =
                    waitUtility.waitForAlert();

            String message = alert.getText();

            log.info("Delete Customer Alert: " + message);

            alert.accept();

            log.info("Delete Customer alert accepted");

        } catch (org.openqa.selenium.TimeoutException e) {

            log.info("No alert displayed after Delete Customer");
        }
    }


    // RESET
    

    public void clickReset() {

        waitUtility.waitForClickable(reset).click();

        log.info("Clicked Reset");
    }


    // COMPLETE DELETE CUSTOMER OPERATION
    
    public void deleteCustomer(String id) {

        // Open Delete Customer page
        clickDeleteCustomer();

        // Enter Customer ID
        enterCustomerId(id);

        // Delete Customer
        clickSubmit();
    }
    
}
