package com.freecrm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;
public class HomePageTest extends TestBase{
	HomePage homePage;
	LoginPage loginPage;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super(); 
	}

	@BeforeMethod
	public void setup(){
		initialization();
		//now home page is coming from the method loginTest()
		 loginPage=new LoginPage();
		//since homepage is being returned by the login() of login class
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void validateGetTitleTest(){
	String actualTitle=homePage.verifyHomePageTitle();
	Assert.assertEquals(actualTitle, driver.getTitle());
	}
	
/*	@Test(priority=2)
	public void verifyUserNameLabelTest(){
		Assert.assertTrue(homePage.verifyUserNameLabel());
	}*/
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		TestUtil.switchToFrame();
		contactsPage= homePage.clickonContactsLink();
	}
	
	
	
	
}
