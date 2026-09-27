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

public class DeleteAccount_POM extends BasePage {

    private Logger log =
            LogManager.getLogger(DeleteAccount_POM.class);

    public DeleteAccount_POM(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Delete Account link
    @FindBy(linkText = "Delete Account")
    private WebElement deleteAccount;

    // Account Number
    @FindBy(name = "accountno")
    private WebElement accountNumber;

    // Submit button
    @FindBy(name = "AccSubmit")
    private WebElement submit;

    // Reset button
    @FindBy(name = "res")
    private WebElement reset;

    // Click Delete Account
    

    public void clickDeleteAccount() {

        WebElement element =
                waitUtility.waitForClickable(deleteAccount);

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

        log.info("Clicked Delete Account");
    }


    // Enter Account Number
  

    public void enterAccountNumber(String accountNo) {

        WebElement element =
                waitUtility.waitForVisibility(accountNumber);

        element.clear();
        element.sendKeys(accountNo);

        log.info("Account Number entered: " + accountNo);
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

        log.info("Clicked Delete Account Submit");

        try {

            Alert alert =
                    waitUtility.waitForAlert();

            log.info(
                    "Alert Message: " +
                    alert.getText()
            );

            alert.accept();

            log.info("Alert accepted");

        } catch (org.openqa.selenium.TimeoutException e) {

            log.info(
                    "No alert displayed after Delete Account Submit"
            );
        }
    }


    
    // Click Reset
    

    public void clickReset() {

        waitUtility.waitForClickable(reset).click();

        log.info("Clicked Reset");
    }


   
    // Browser Back Button
    

    public void clickBrowserBack() {

        driver.navigate().back();

        log.info("Browser Back button clicked");
    }


   
    // Complete Delete Account Operation
  

    public void deleteAccount(String accountNo) {

        clickDeleteAccount();

        enterAccountNumber(accountNo);

        clickSubmit();

        log.info("Delete Account operation completed");
    }
}