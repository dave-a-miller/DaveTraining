package com.toys1.accesstoys.test;

import org.junit.Assert;
import org.junit.Test;

import com.toys1.accesstoys.models.pages.HomePage;
import com.toys1.accesstoys.models.pages.LoginPage;


public class LoginPageTest extends BaseTestSuite{
	
	
	@Test
	public void invalidLoginTest() {
		//Set up the login page
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickLoginLink();

		//Enter an invalid username
		loginPage.setUsername("XXX");
		
		//Enter an invalid Password
		loginPage.setPassword("XXX");
		
		//Select the Login button
		loginPage.clickLogin();
		
		//Verify the error message
		Assert.assertEquals("Login error is displayed", "Your login details are incorrect", loginPage.getLoginError());
	}
	
	@Test
	public void validLoginTest() {
		//Set up the login page
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.clickLoginLink();

		//Enter an invalid username
		loginPage.setUsername("user1");
		
		//Enter an invalid Password
		loginPage.setPassword("letmein");
		
		//Click the login button
		loginPage.clickLogin();
		
		//Select the USER LINK
		loginPage.clickUserLink();
		
		//Verify the Welcome screen is displayed
		Assert.assertEquals("Welcome message is displayed", "Welcome user1", loginPage.getWelcomeMessage());
		
		//Click the logout button
		loginPage.clickLogoutLink();
		
		//Verify Logout page is displayed
		Assert.assertEquals("Logout message is displayed", "Are you sure that you want to logout?", loginPage.getLogoutMessage());
		
		//Click logout button
		loginPage.clickLogoutButton();

	}

}
