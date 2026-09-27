package POM_pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import helper.BasePage;

public class NewAccount_POM extends BasePage {

    private Logger log =
            LogManager.getLogger(NewAccount_POM.class);
    private WebElement generatedAccountNumberElement;

    public String getGeneratedAccountNumber() {
        WebElement element = waitUtility.waitForVisibility(generatedAccountNumberElement);
        return element.getText().trim();
    }
    

    public NewAccount_POM(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // New Account link
    @FindBy(linkText = "New Account")
    private WebElement newAccount;

    // Customer ID
    @FindBy(name = "cusid")
    private WebElement customerId;

    // Account Type
    @FindBy(name = "selaccount")
    private WebElement accountType;

    // Initial Deposit
    @FindBy(name = "inideposit")
    private WebElement initialDeposit;

    // Submit button
    @FindBy(name = "button2")
    private WebElement submit;

    // Reset button
    @FindBy(name = "reset")
    private WebElement reset;


    // Click New Account
    public void clickNewAccount() {

        WebElement element =
                waitUtility.waitForClickable(newAccount);

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

        log.info("Clicked New Account");
    }


    // Enter Customer ID
    public void enterCustomerId(String id) {

        WebElement element =
                waitUtility.waitForVisibility(customerId);

        element.clear();
        element.sendKeys(id);

        log.info("Customer ID entered: " + id);
    }


    // Select Account Type
    public void selectAccountType(String type) {

        WebElement element =
                waitUtility.waitForVisibility(accountType);

        Select select = new Select(element);

        select.selectByVisibleText(type);

        log.info("Account Type selected: " + type);
    }


    // Enter Initial Deposit
    public void enterInitialDeposit(String deposit) {

        WebElement element =
                waitUtility.waitForVisibility(initialDeposit);

        element.clear();
        element.sendKeys(deposit);

        log.info("Initial Deposit entered: " + deposit);
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

        log.info("Clicked New Account Submit");
    }


    // Click Reset
    public void clickReset() {

        waitUtility.waitForClickable(reset).click();

        log.info("Clicked Reset");
    }


    // Complete New Account operation
    public void createNewAccount(
            String id,
            String type,
            String deposit) {

        clickNewAccount();

        enterCustomerId(id);

        selectAccountType(type);

        enterInitialDeposit(deposit);

        clickSubmit();
        log.info("New Account created successfully");
        }
    
    }
