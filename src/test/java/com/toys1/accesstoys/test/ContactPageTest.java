package com.toys1.accesstoys.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import com.toys1.accesstoys.models.pages.ContactPage;
import com.toys1.accesstoys.models.pages.HomePage;


public class ContactPageTest extends BaseTestSuite{

	
	
	@Test
	public void mandatoryFieldsTest() {
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactLink();
		//click contact link
		
		
		//hit the Submit button
		contactPage.clickSubmit();
		
		//verify error messages
		Assert.assertEquals("forename error is displayed", "Forename is required", contactPage.getForenameError());
		Assert.assertEquals("Email error is displayed", "Email is required", contactPage.getEmailError());
		Assert.assertEquals("Message error is displayed", "Message is required", contactPage.getMessageError());
		
		
		//input valid data
		contactPage.setForename("DAVETHEBRAVE");
		contactPage.setSurname("MILLER");
		contactPage.setEmail("DAVE@EMAIL.COM");
		contactPage.setTelephone("1234567890");
		contactPage.setMessage("THIS IS A MESSAGE FROM DAVE");
		
		//verify error messages gone
		Assert.assertEquals("Forename error is NOT displayed", "", contactPage.getForenameError());
		Assert.assertEquals("Email error is NOT displayed", "", contactPage.getEmailError());
		Assert.assertEquals("Message error is NOT displayed", "", contactPage.getMessageError());
	}

	@Test
	public void invalidFieldsTest() //throws InterruptedException 
	{
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactLink();
		
		//Input invalid data ... only Email and Telephone will return errors
		contactPage.setForename("DAVETHEBRAVE");
		contactPage.setEmail("crapEmail");
		contactPage.setTelephone("abc");
		contactPage.setMessage("THIS IS A MESSAGE FROM DAVE");
		
		//verify correct error messages are displayed 
		Assert.assertEquals("Email error is displayed", "Please enter a valid email", contactPage.getEmailError());
		Assert.assertEquals("Telephone error is displayed", "Please enter a valid telephone number", contactPage.getTelephoneError());		
	
	}

	@Test
	public void submitSuccessTest() {
		HomePage homePage = new HomePage(driver);
		ContactPage contactPage = homePage.clickContactLink();
				
		//Input Valid Data
		contactPage.setForename("MEL");
		contactPage.setSurname("GIBSON");
		contactPage.setEmail("MG@EMAIL.COM");
		contactPage.setTelephone("0412555555");
		contactPage.setMessage("THIS IS A MESSAGE FROM MEL GIBSON");
	 
		//Select the Submit button
		contactPage.clickSubmit();
		
		//verify contact page success message
		Assert.assertEquals("Success message", "Thanks MEL, we appreciate your feedback.", contactPage.getSuccessMessage());

		String str1 = driver.findElement(By.className("alert-success")).getText();
		System.out.println(str1);
	}

}
