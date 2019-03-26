package com.freecrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.util.TestUtil;

public class ContactsPage extends TestBase {
	
	//page factory
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement ContactsLabel;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement TitleDropdown;
	
	@FindBy(name="surname")
	WebElement LastNameTextbox;
	
	@FindBy(name="first_name")
	WebElement FtNameTextbox;
	
	@FindBy(xpath="//input[@name='client_lookup'] ")
	WebElement CompanyTextbox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement Savebtn;
	
   public ContactsPage(){
	   PageFactory.initElements(driver, this);
   }
	
   public boolean verifyContactsLabel(){
	//  TestUtil.switchToFrame();
	  return ContactsLabel.isDisplayed();
  }
   
   public void selectContacts(String name){
	   String xpath1="//a[contains(text(),'" +name +"')]/parent::*/preceding-sibling::td[@class='datalistrow']"
				+ "//input[@name='contact_id']";
		//name='rad te
		
	  driver.findElement(By.xpath(xpath1)).click();
  }
   
   public void addNewContact(String title,String firstName,String lastName,String companyName){
	 
	 Select s = new Select(TitleDropdown);  
	 s.selectByVisibleText(title);
	 
	 FtNameTextbox.sendKeys(firstName);
	 LastNameTextbox.sendKeys(lastName);
	 CompanyTextbox.sendKeys(companyName);
	 
	 Savebtn.click();
 }
   
   
   
   
   
   




	

}
