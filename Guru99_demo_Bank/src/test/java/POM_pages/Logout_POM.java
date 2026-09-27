package POM_pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;

public class Logout_POM extends BasePage {

    private Logger log = LogManager.getLogger(Logout_POM.class);

    // Constructor
    public Logout_POM(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Logout locator
    @FindBy(xpath = "//a[@href='Logout.php']")
    private WebElement Logout;

    public void clickLogout() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until Logout is present
        WebElement logoutElement = wait.until(
                ExpectedConditions.visibilityOf(Logout)
        );

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        // Scroll Logout into the center of the screen
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                logoutElement
        );

        // Small wait for page to settle
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Click Logout using JavaScript
        js.executeScript(
                "arguments[0].click();",
                logoutElement
        );

        log.info("Clicked Logout successfully");
    }

    public void logout() {
        clickLogout();
    }
}
//
//import java.time.Duration;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import helper.BasePage;
//
//public class Logout_POM extends BasePage {
//
//    private Logger log = LogManager.getLogger(Logout_POM.class);
//
//    // Constructor
//    public Logout_POM(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    // Logout locator
//    @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
//    private WebElement Logout;
//
//    public void clickLogout() {
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Wait for Logout
//        WebElement logoutElement = wait.until(
//                ExpectedConditions.visibilityOf(Logout)
//        );
//
//        // Scroll to Logout
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//        js.executeScript(
//                "arguments[0].scrollIntoView({block:'center'});",
//                logoutElement
//        );
//
//        // Click Logout
//        wait.until(
//                ExpectedConditions.elementToBeClickable(logoutElement)
//        );
//
//        logoutElement.click();
//
//        log.info("Clicked Logout successfully");
//    }
//
//    public void logout() {
//        clickLogout();
//    }
//}