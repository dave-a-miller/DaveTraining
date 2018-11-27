package com.toys1.accesstoys.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toys1.accesstoys.test.BaseTestSuite;

public class Utility {
	public static boolean elementExists(WebDriver driver, By locator, long secTimeout, long msTimeout)
	{
		try 
		{
			driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);	
			//disable time out
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			// check for element
			(new WebDriverWait(driver,secTimeout,msTimeout)).until(ExpectedConditions.elementToBeClickable(locator));
			//re-enable wait time
			driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
			return true;
		}
		catch (Exception e) 
		{
			driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.MILLISECONDS);
			return false;
		}
	}
}
