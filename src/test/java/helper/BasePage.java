package helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utility_Files.Wait_Utility;

public class BasePage {
	protected WebDriver driver;
	   

	    protected Wait_Utility waitUtility;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {

            waitUtility = new Wait_Utility(driver);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
