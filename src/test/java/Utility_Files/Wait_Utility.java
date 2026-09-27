package Utility_Files;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Utility {

    private WebDriver driver;
    private WebDriverWait wait;

    public Wait_Utility(WebDriver driver) throws IOException {

        this.driver = driver;

        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir")
                + "/src/test/resources/config.properties"
        );

        prop.load(fis);

        int waitTime = Integer.parseInt(
                prop.getProperty("explicitWait")
        );

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(waitTime)
        );
    }

    public WebElement waitForVisibility(WebElement element) {

        return wait.until(
                ExpectedConditions.visibilityOf(element)
        );
    }

    public WebElement waitForClickable(WebElement element) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }
    public Alert waitForAlert() {

        return wait.until(
                ExpectedConditions.alertIsPresent()
        );
    }
}