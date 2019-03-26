package com.freecrm.qa.pages;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.util.TestUtil;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase{
	//Page factory
	@FindBy(xpath="//td[contains(text(),'User: r gupta ')]")
	WebElement UserNameLabel;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement Taskslnk;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement Dealslnk;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement Contactslnk;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement NewContactslnk;
	//create constructor of HomePage for initializing Pagefactory
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public TasksPage clickOnTasksLink(){
		
		
		return new TasksPage();
	}
	
	public ContactsPage clickonContactsLink(){
		TestUtil.switchToFrame();
		Contactslnk.click();
		return new ContactsPage();
	}
	
	public void clickonNewContactLink(){
	//	TestUtil.switchToFrame();
		Actions act=new Actions(driver);
		act.moveToElement(Contactslnk).build().perform();
		NewContactslnk.click();
	
	}
	
	
	public DealsPage clickonDealsPageLink(){
		return new DealsPage();
	}
	
	public boolean verifyUserNameLabel(){
		driver.switchTo().frame("main panel");
		return UserNameLabel.isDisplayed();
	}

	
	
	
	
			
			
			
	
	
	

	

}
