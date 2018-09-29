package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="client_lookup")
	WebElement Companyname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement SaveBtn;
	
	public boolean verifyacontactalabel()
	{
		return contactsLabel.isDisplayed();
	}
	
	public void SelectContactsByName(String Name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+Name+"')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}
	
	public void CreateNewContact(String title,String FName,String LName,String CompName)
	{
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		FirstName.sendKeys(FName);
		LastName.sendKeys(LName);
		Companyname.sendKeys(CompName);
		SaveBtn.click();
	}
	

}
