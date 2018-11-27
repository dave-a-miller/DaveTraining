package com.toys1.accesstoys.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.toys1.accesstoys.utility.Utility;

public class ContactPage extends BaseNavigation {

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	//Set up variables for the contact page
	By forenameField = By.id("forename");
	By surnameField = By.id("surname");
	By emailField = By.id("email");
	By telephoneField = By.id("telephone");
	By messageField = By.id("message");
	By forenameError = By.id("forename-err");
	By emailError = By.id("email-err");
	By telephoneError = By.id("telephone-err");
	By messageError = By.id("message-err");
	By submitButton = By.linkText("Submit");
	By messageSuccess = By.className("alert-success");
	
	//click the submit button
	public void clickSubmit()
	{
		driver.findElement(submitButton).sendKeys(Keys.ENTER);
	}
	
	//Verify error messages exist
	public String getForenameError()
	{
		return Utility.elementExists(driver, forenameError, 0,100)? driver.findElement(By.id("forename-err")).getText():"";
	}
	public String getEmailError()
	{
		return Utility.elementExists(driver, emailError, 0,100)? driver.findElement(By.id("email-err")).getText():"";
	}
	public String getTelephoneError()
	{
		return Utility.elementExists(driver, telephoneError,0, 100)? driver.findElement(By.id("telephone-err")).getText():"";
	}
	public String getMessageError()
	{
		return Utility.elementExists(driver, messageError,0, 100)? driver.findElement(By.id("message-err")).getText():"";
	}
	
	//Set the values for valid input
	public void setForename(String forename)
	{
		driver.findElement(forenameField).sendKeys(forename);
	}
	public void setSurname(String surname)
	{
		driver.findElement(surnameField).sendKeys(surname);
	}
	public void setEmail(String email)
	{
		driver.findElement(emailField).sendKeys(email);
	}
	public void setTelephone(String telephone)
	{
		driver.findElement(telephoneField).sendKeys(telephone);
	}
	public void setMessage(String message)
	{
		driver.findElement(messageField).sendKeys(message);
	}
	
	// Verify success message
	public String getSuccessMessage()
	{
		return Utility.elementExists(driver, messageSuccess,60,0)? driver.findElement(By.className("alert-success")).getText():"";
	}
	
}



