package com.toys1.accesstoys.models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BaseNavigation {
	protected WebDriver driver;
	
	public BaseNavigation(WebDriver driver) {
		this.driver = driver;
	}
	
	By contactlink = By.cssSelector("#nav-contact > a");
	By homeLink = By.cssSelector("#nav-home > a");
	By loginLink = By.linkText("Login");
	By userLink = By.cssSelector("#nav-user > a");
	By shopLink = By.cssSelector("#nav-shop > a");
	By cartLink = By.cssSelector("#nav-cart > a");
	
	public ContactPage clickContactLink()
	{
		//navigate to the ContactPage
		driver.findElement(contactlink).sendKeys(Keys.ENTER);
		return new ContactPage(driver);
	}
	public HomePage clickHomeLink()
	{
		//Navigate to the HomePage
		driver.findElement(homeLink).sendKeys(Keys.ENTER);
		return new HomePage(driver);
	}
	public LoginPage clickLoginLink()
	{
		//Navigate to the LoginPage
		driver.findElement(loginLink).sendKeys(Keys.ENTER);
		return new LoginPage(driver);
	}
	public HomePage clickUserLink()
	{
		//Navigate to the Welcome Page
		driver.findElement(userLink).sendKeys(Keys.ENTER);
		return new HomePage(driver);
	}
	public ShopPage clickShopLink()
	{
		//Navigate to the Shop Page
		driver.findElement(shopLink).sendKeys(Keys.ENTER);
		return new ShopPage(driver);
	}
	public CartPage clickCartLink()
	{
		//Navigate to the Shop Page
		driver.findElement(cartLink).sendKeys(Keys.ENTER);
		return new CartPage(driver);
	}
}
