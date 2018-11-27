package com.toys1.accesstoys.test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTestSuite {
	//setup web driver
	protected static WebDriver driver;
	public static int IMPLICIT_WAIT = 3000;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//setup webdriver
		System.setProperty("webdriver.chrome.driver", "resources//chromedriver.exe");
		driver = new ChromeDriver();
		
		//setup webpage for testing
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//quit
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {
		//Delete all cookies
		driver.manage().deleteAllCookies();
		//navigate to the home page
		driver.navigate().to("http://autowebsite-396.devnet.dg.internal/accesstoys/toys1/#/");
	}

}
