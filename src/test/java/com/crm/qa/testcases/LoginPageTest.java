package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException 
	{
		insitialization();
		loginpage=new LoginPage();
		Thread.sleep(2000);
		
				
	}
	@Test(priority=1)
	public void TitelTest()
	{
		String Titel = loginpage.validateLoginPageTitle();
		Assert.assertEquals(Titel, "#1 Free CRM software in the cloud for sales and service","LOGIN PAGE IS NOT TEST FAILED ");
	}
	@Test(priority=2)
	public void CrmLogoImageTest()
	{
		boolean flag = loginpage.validateCRMImge();
		Assert.assertTrue(flag,"Image Test Case Failed");
	}
	
	@Test(priority=3)
	public void LoginTest()
	{
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
