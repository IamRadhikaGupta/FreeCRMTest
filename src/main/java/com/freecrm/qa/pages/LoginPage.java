package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory(OR for login Page)
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Loginbtn;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/register/']")
	WebElement signUpLink;
	
	@FindBy(xpath="//img[contains(@alt,'free crm logo')]")
	WebElement Logo;
	
	//initialize Page factory
	public LoginPage(){
		//PageFactory.initElements(driver, pageClassToProxy)
		PageFactory.initElements(driver, this);//this-current class object
		//u may use LoginPage.class
	}
	//Actions
	public String validateGetTitle(){
			return driver.getTitle();
	}
	
	public boolean validateLoginLogo(){
		return Logo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd){
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
        Loginbtn.click();
        //from login page we eneter to home page..so home page is landing page
        //of home page
        return new HomePage();
	}
	
}
	

