package com.toys1.accesstoys.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.toys1.accesstoys.utility.Utility;

public class LoginPage extends BaseNavigation {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Create variables
	By usernameField = By.id("loginUserName");
	By passwordField = By.id("loginPassword");
	By loginButton = By.className("btn-primary");
	By logoutLink = By.cssSelector("#nav-logout > a");
	By logoutButton = By.cssSelector("div.modal-footer>a");
	By loginError = By.id("login-error");
	By welcomeMessage = By.cssSelector("div.row-fluid h1");
	By logoutMessage = By.cssSelector("div.modal-body.message");
	
	//Create page methods
	public void setUsername(String username)
	{
		driver.findElement(usernameField).sendKeys(username);
	}
	public void setPassword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickLogin()
	{
		driver.findElement(loginButton).sendKeys(Keys.ENTER);
	}
	public void clickLogoutLink()
	{
		driver.findElement(logoutLink).sendKeys(Keys.ENTER);
	}
	public void clickLogoutButton()
	{
		driver.findElement(logoutButton).sendKeys(Keys.ENTER);
	}
	
	//Verify error messages exist
	public String getLoginError()
	{
		return Utility.elementExists(driver, loginError,3, 3000)? driver.findElement(loginError).getText():"";
	}
	
	//Verify Welcome page
	public String getWelcomeMessage()
	{
		return Utility.elementExists(driver, welcomeMessage,3, 3000)? driver.findElement(welcomeMessage).getText():"";
	}
	
	//Verify logout page is displayed
	public String getLogoutMessage()
	{
		return Utility.elementExists(driver, logoutMessage,3, 3000)? driver.findElement(logoutMessage).getText():"";
	}
	
}
