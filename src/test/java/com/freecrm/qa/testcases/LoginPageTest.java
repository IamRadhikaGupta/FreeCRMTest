package com.freecrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	/*super keyword calls constructor of the parent class we need to read the 
	properties file of parent class so we need to initialize the constructor
	of parent class
	control flow-first constructor of base class will be called by super()
	then BeforeMethod()
	which will then read browser,open browser,maximize window,implicit wait time set etc.
	then @test based on priorities set */
	LoginPage loginPage; 
	HomePage homePage;
	
	public LoginPageTest(){
		super();//will call TestBase class constructor
		//however since the parent class constructor is not parameterized so even if we do
		//not write super() keyword in the child class constructor
		//it will anyway call the super class constructor
	}
	@BeforeMethod
	public void setup(){
		initialization();
		//create object of LoginPage as we need its members
		loginPage=new LoginPage();
		
	}
	
	@AfterMethod()
	public void tearDown(){
		driver.quit();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title=loginPage.validateGetTitle(); //since in the LoginPage class the method
		//is not static that's why to access it we have created the object of
		//LoginPage class
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		
	}
	@Test(priority=2)
	public void crmLogoPageTest(){
		boolean flag=loginPage.validateLoginLogo();
		Assert.assertTrue(flag);
		//if flag is true assertion will pass else it will fail
	}
	@Test(priority=3)
	public void loginTest(){
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	 //since Login() method in LoginPage class is returning home page   
	}
	
	
	
	
	
	

}
