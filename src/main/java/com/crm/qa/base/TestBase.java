/*
 * Pradeep FREE CRM PROJECT POM
 * */

package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties pro;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	/* *****************create constructor for the base class because 
	 we are load the properties to all the the class related to project***** */
	
	
public TestBase()
	{	
		
		
		try {
			pro = new Properties();
			FileInputStream ip = new FileInputStream("D:\\pradeep 2018\\Profsional\\workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			pro.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	//*******insitialization of browser *//
	public static void insitialization() throws InterruptedException 
	{
	
		String browsername=pro.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\pradeep 2018\\library\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browsername.equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\pradeep 2018\\library\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		String url = pro.getProperty("url");
		driver.get(url);
		Thread.sleep(2000);
		
	}
	

}
