package com.toys1.accesstoys.models.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.toys1.accesstoys.models.tables.CartTable;

public class CartPage extends BaseNavigation {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	By cartTable = By.className("cart-items");
	By cartCount = By.cssSelector("span.cart-count");	
	By emptyCartButton = By.linkText("Empty Cart");
	By yesButton = By.linkText("Yes");
	By cartTotal = By.cssSelector("strong.total");

	public String getTableCellValue(String findColumn, String findValue, String returnColumn) throws Exception{
		if (doesTableExist()){
			CartTable table = new CartTable(driver.findElement(cartTable));
			return table.getTableCellValue(findColumn, findValue, returnColumn);
		}
		throw new Exception("no table found");
	}
	
	public void setItemQuantity(String itemName, String quantity) throws Exception{
		CartTable table = new CartTable(driver.findElement(cartTable));
		table.setQuantity(itemName, quantity);
	}
	
	
	public int getItemQuantity(String itemName) throws Exception{
		if (doesTableExist()){
			CartTable table = new CartTable(driver.findElement(cartTable));
			return table.getQuantity(itemName);
		}
		return 0;
	}
	
	public boolean isItemInCart(String itemName) throws Exception{
		if (doesTableExist()){
			CartTable table = new CartTable(driver.findElement(cartTable));
			return table.isItemInTable(itemName);
		}
		return false;
	}
	private boolean doesTableExist(){
		List<WebElement> tables = driver.findElements(cartTable);
		if (tables.size() == 0) {
			return false;	
		}
		return true;		
	}

	//Set the values for valid input
	public String checkCart()
	{
		return driver.findElement(cartCount).getText();
	}
	//Click the “Empty Cart’ button
	public void emptyCart()
	{
		driver.findElement(emptyCartButton).click();
	}
	//Confirm empty Cart
	public void emptyCartYes()
	{
		driver.findElement(yesButton).click();
	}
	//Remove Item from Cart
	public void removeItem(String itemName) throws Exception{
		CartTable table = new CartTable(driver.findElement(cartTable));
		table.clickRemoveItem(itemName);
	}
	//Get the Total value of the Cart
	public String getTotal()
	{
		return driver.findElement(cartTotal).getText();
	}
	//Get SubTotal value for an item
	public String getSubTotal (String itemName) throws Exception
	{
		return getTableCellValue("Item", itemName, "Subtotal");
	}
}
