////import java.io.IOException;
//

package Testcases;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import POM_pages.DeleteAccount_POM;
import POM_pages.DeleteCustomer_POM;
import POM_pages.LoginPage_POM;
import POM_pages.Logout_POM;
import POM_pages.NewAccount_POM;
import POM_pages.NewCustomerPage_POM;
import Utility_Files.Excel_utility;
import helper.BaseTest;

public class Guru99_demo_bank_All_Testcases extends BaseTest 
{
@Test
public void login_testcase() throws InterruptedException, IOException {
	//login using excel data
	String user=Excel_utility.getCellData(System.getProperty("user.dir")+"/src/test/resources/Guru99_Test_Data.xlsx","Guru99_Bank_Login", 1, 0);
	String pass=Excel_utility.getCellData(System.getProperty("user.dir")+"/src/test/resources/Guru99_Test_Data.xlsx","Guru99_Bank_Login", 1, 1);
	LoginPage_POM l=new LoginPage_POM(wd);
	
	l.login(user,pass);
	Thread.sleep(2000);
}


@Test(dependsOnMethods = "login_testcase")
public void new_customer_testcase() throws InterruptedException {

    NewCustomerPage_POM customer =
            new NewCustomerPage_POM(wd);

    customer.clickNewCustomer();

    // your customer details
    customer.enterCustomerName("Sonal");
    customer.selectFemale("Female");
    customer.enterDateOfBirth("02/10/1995");
    customer.enterAddress("Mumbai");
    customer.enterCity("Mumbai");
    customer.enterState("Maharashtra");
    customer.enterPin("400001");
    customer.enterMobileNumber("9876543210");
    customer.enterEmail("sonal" + System.currentTimeMillis() + "@gmail.com");
    customer.enterPassword("Test@123");

    customer.clickSubmit();

    Thread.sleep(2000);

    log.info("New Customer test case completed");
}

//@Test(dependsOnMethods = "new_customer_testcase")
//public void new_account_testcase() throws InterruptedException {
//
//    NewAccount_POM account =
//            new NewAccount_POM(wd);
//
//    WebElement accountNumber =
//            account.createNewAccount(
//                   11304,
//                    "Savings",
//                    "5000"
//            );
//
//    log.info(
//            "Account Number stored: "
//            + accountNumber
//    );
//
//    Thread.sleep(2000);
//}
@Test(dependsOnMethods = "new_customer_testcase")
public void new_account_testcase() throws InterruptedException {

    NewAccount_POM account =
            new NewAccount_POM(wd);

    account.createNewAccount("11304",
            "Savings",
            "5000"
    );

    Thread.sleep(2000);

    log.info("New Account test case completed");
}


@Test(dependsOnMethods = "new_account_testcase")
public void delete_account_testcase() throws InterruptedException {

    DeleteAccount_POM deleteAccount =
            new DeleteAccount_POM(wd);

    deleteAccount.deleteAccount("185606");
    deleteAccount.clickBrowserBack();


    Thread.sleep(2000);

    log.info("Delete Account test case completed");
}


@Test(dependsOnMethods = "delete_account_testcase")
public void delete_customer_testcase() throws InterruptedException {

    DeleteCustomer_POM deleteCustomer =
            new DeleteCustomer_POM(wd);

//	
//	  deleteCustomer.openDeleteCustomerPage();
//	  
//	  //deleteCustomer.enterCustomerId("11304");
//	 
//	  deleteCustomer.clickSubmit();
	 
    Thread.sleep(2000);
    deleteCustomer.deleteCustomer("30656");

    Thread.sleep(2000);

    log.info("Delete Customer test case completed");
}


@Test(dependsOnMethods = "delete_customer_testcase")
public void logout_testcase() throws InterruptedException {

    Logout_POM logout =
            new Logout_POM(wd);

    logout.logout();

    Thread.sleep(2000);

    log.info("Logout test case completed");
}
}
