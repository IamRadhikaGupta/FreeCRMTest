package com.freecrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.freecrm.qa.util.TestUtil;

public class TestBase {
public static WebDriver driver =null;
String SystemDir="C:\\Users\\radhika.gupta\\workspace\\FreeCRMTest";
public static Properties prop;
	
public TestBase(){
		try {
			prop=new Properties();
FileReader reader =new FileReader("C:\\Users\\radhika.gupta\\workspace\\FreeCRMTest\\src\\main\\java\\com\\freecrm\\qa\\configfile\\config.properties");
prop.load(reader);
} catch (FileNotFoundException e) {
		  e.printStackTrace();
} catch (IOException e) {
			e.printStackTrace();
		}
}
public static void initialization() {
	    String browserName=prop.getProperty("browser");
	    String url=prop.getProperty("url");
	    if(browserName.equals("chrome")){
	    	 driver = new ChromeDriver();
	    	
	    }
	    else if(browserName.equals("IE")){
			 driver = new InternetExplorerDriver();
		}
	    else if(browserName.equals("Firefox")){
	    	driver = new FirefoxDriver();
			
		}
	    else{
	    	System.out.println("invalid browser");
	    }
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait_TimeOut, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
	    driver.get(url);
	    
	  
	}
}
