package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: pradeep p')]")
	@CacheLookup
	WebElement homepageUserNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLinks;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLinks;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactLink;
	
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyHomepageauserName()
	{
		boolean homepageusename = homepageUserNameLabel.isDisplayed();
		return homepageusename;
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();		
	}
	
	public ContactsPage clickOnContactLink()
	{
		contactLinks.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickonDealsLink()
	{
		dealsLinks.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTaskLink()
	{
		taskslink.click();
		return new TasksPage();
	}
	public void ClickOnNewContact()
	{
		Actions act=new Actions(driver);
		act.moveToElement(contactLinks).build().perform();
		 newcontactLink.click();
	}
	
	

}
