package POM_pages;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import helper.BasePage;
	public class LoginPage_POM extends BasePage 
	{
	    private Logger log = LogManager.getLogger(LoginPage_POM.class);
	    public LoginPage_POM(WebDriver driver) {
	       super(driver);
	    }
	 // Locators repository
	    @FindBy(name = "uid")
	    private WebElement usernameInput;

	    @FindBy(name = "password")
	    private WebElement passwordInput;

	    @FindBy(name = "btnLogin")
	    private WebElement loginButton;
	    
	    @FindBy(name = "btnReset")
	    private WebElement ResetButton;
	    
	    // Actions repository
	    public void enterUsername(String user) {
	        usernameInput.sendKeys(user);
	        log.info("Entered username: {}", user);
	    }
	    public void clickReset()
	    {
	    	ResetButton.click();
	        log.info("Clicked Reset button");
	    }
	    
	                                                                                         
	    public void enterPassword(String pass) {
	        passwordInput.sendKeys(pass);
	        log.info("Entered password");
	    }

	    public void clickLogin()
	    {
	        loginButton.click();
	        log.info("Clicked login button");
	    }

	    public void login(String user, String pass) {
	        enterUsername(user);
	        enterPassword(pass);
	        clickLogin();
	    }
	}
	
