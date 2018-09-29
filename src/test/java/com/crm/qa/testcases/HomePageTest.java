package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
   LoginPage loginpage;
   HomePage homepage;
   TestUtil testUtil;
   ContactsPage contactpage;
	public HomePageTest()
	{
		super();
	}
	//test case should be independent 
	//before each test case -launch the browser and login
	//@test-execute
	//after each test case quit the browser.
	@BeforeMethod
	public void setup() throws InterruptedException  
	{
		insitialization();
		testUtil =new TestUtil();
		loginpage=new LoginPage();
		contactpage=new ContactsPage();
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		Thread.sleep(2000);
				
	}
	@Test(priority=1)
	public void VerifyHomePageTitleTest()
	{
		String HomePageTitel = homepage.verifyHomePageTitle();
		Assert.assertEquals(HomePageTitel, "CRMPRO","Home page Title is Not Match");
	}
	@Test(priority=2)
	public void verifyHomepageUserNameTest()
	{
		testUtil.SwithToFrame();
		boolean homepageusrname = homepage.VerifyHomepageauserName();
		Assert.assertTrue(homepageusrname,"username not match");
	}
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		testUtil.SwithToFrame();
		contactpage= homepage.clickOnContactLink();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
