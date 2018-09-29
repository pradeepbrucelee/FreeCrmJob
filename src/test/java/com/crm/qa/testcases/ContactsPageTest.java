package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	   LoginPage loginpage;
	   HomePage homepage;
	   TestUtil testUtil;
	   ContactsPage contactpage;
	  String  sheetname="CONTACTTESTDATA";
	   
	   public ContactsPageTest()
	   {
		   super();
		   
	   }
	   @BeforeMethod
		public void setup() throws InterruptedException  
		{
			insitialization();
			testUtil =new TestUtil();
			loginpage=new LoginPage();
			contactpage=new ContactsPage();
			homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
			TestUtil.SwithToFrame();
			contactpage=homepage.clickOnContactLink();
			Thread.sleep(2000);
		}
	   @Test(priority=1)
	   public void verifyContactsPageLabelTest()
	   {
		boolean contactlabel = contactpage.verifyacontactalabel();
		Assert.assertTrue(contactlabel,"Contact missing Match");
	   }
	   @Test(priority=2)
	   public void SelectcontactNameTest()
	   {
		   String name = pro.getProperty("Contacttext");
		  contactpage.SelectContactsByName(name); 
	   }
	   
	   @DataProvider
	   public Object[][] getCRMTestData()
	   {
		  Object[][] data = TestUtil.getTestData(sheetname);
		  return data;
		   
		   
	   }
	   @Test(priority=3,dataProvider="getCRMTestData")
	   public void validatecreateNewContact(String titel,String fname,String Lname,String Comp)
	   {
		   homepage.ClickOnNewContact();
		 //  contactpage.CreateNewContact("Mr.", "pradeep", "Anand", "abaqus");
		   contactpage.CreateNewContact(titel, fname, Lname, Comp);
		   
	   }
//	   @AfterMethod
//	   public void tearDown()
//	   {
//		   driver.quit();
//	   }
}
