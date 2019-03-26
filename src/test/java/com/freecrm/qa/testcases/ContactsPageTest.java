package com.freecrm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public String sheetName="Contacts";

	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=new HomePage();
		contactsPage=new ContactsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	//	testUtil.switchToFrame();
		homePage.clickonContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest(){
		 Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts label not displayed");
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}	
	
	
	@Test(priority=2,dataProvider="getCRMTestData")
	public void validateContactAddTest(String title,String firstName,
			String lastName,String company){
		homePage.clickonNewContactLink();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		contactsPage.addNewContact(title,firstName,lastName,company);
	}
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
	

}
