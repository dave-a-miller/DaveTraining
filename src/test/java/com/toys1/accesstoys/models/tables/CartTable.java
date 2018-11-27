package com.toys1.accesstoys.models.tables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartTable {
	
	private WebElement element;
	public CartTable(WebElement element) {
		this.element = element;
	}
	
	private int getColumnIndex(String columnTitle) throws Exception{
		List<WebElement> tableHeaders = element.findElements(By.cssSelector("thead th"));
		for(int i=0;i<tableHeaders.size();i++){
			if (tableHeaders.get(i).getText().equals(columnTitle)){
				return i;
			}
		}
		throw new Exception("No column titled " + columnTitle + "found");
	}
	
	public String getTableCellValue(String findColumn, String findValue, String returnColumn) throws Exception{
		int findColumnIndex = getColumnIndex(findColumn);
		int returnColumnIndex = getColumnIndex(returnColumn);
		List<WebElement> tableRows = element.findElements(By.cssSelector("tbody tr"));
		for(WebElement row : tableRows){
			List<WebElement> tableCells = row.findElements(By.tagName("td"));
			
			if (tableCells.get(findColumnIndex).getText().equals(findValue)){
				return tableCells.get(returnColumnIndex).getText();
			}
		}
		throw new Exception("No cell data found");
	}
	
	//this is all repetition so need to work out how to handle this perhaps an interface?
	
	public void clickRemoveItem(String itemName) throws Exception{
		int itemIndex = getColumnIndex("Item");
		int removeItemIndex = getColumnIndex("Actions");
		List<WebElement> tableRows = element.findElements(By.cssSelector("tbody tr"));
		for(WebElement row : tableRows){
			List<WebElement> tableCells = row.findElements(By.tagName("td"));
			if (tableCells.get(itemIndex).getText().equals(itemName)){
				tableCells.get(removeItemIndex).findElement(By.className("remove-item")).click();	
				return;
			}
		}
		throw new Exception("No item found to delete");
	}
	
	public void setQuantity(String itemName, String quantity) throws Exception{
		int itemIndex = getColumnIndex("Item");
		int quantityIndex = getColumnIndex("Quantity");
		List<WebElement> tableRows = element.findElements(By.cssSelector("tbody tr"));
		for(WebElement row : tableRows){
			List<WebElement> tableCells = row.findElements(By.tagName("td"));
			if (tableCells.get(itemIndex).getText().equals(itemName)){
				WebElement quantityInput = tableCells.get(quantityIndex).findElement(By.name("quantity"));
				quantityInput.clear();
				quantityInput.sendKeys(quantity);
			}
		}
	}
	
	public int getQuantity(String itemName) throws Exception{
		int itemIndex = getColumnIndex("Item");
		int quantityIndex = getColumnIndex("Quantity");
		List<WebElement> tableRows = element.findElements(By.cssSelector("tbody tr"));
		for(WebElement row : tableRows){
			List<WebElement> tableCells = row.findElements(By.tagName("td"));
			if (tableCells.get(itemIndex).getText().equals(itemName)){
				return Integer.parseInt(tableCells.get(quantityIndex).findElement(By.name("quantity")).getAttribute("value"));
			}
		}
		//I know you're not supposed to return when not found, but in this case its relevant as the quantity is 0
		return 0;
	}
	
	public boolean isItemInTable(String itemName) throws Exception{
		int itemIndex = getColumnIndex("Item");
		List<WebElement> tableRows = element.findElements(By.cssSelector("tbody tr"));
		for(WebElement row : tableRows){
			List<WebElement> tableCells = row.findElements(By.tagName("td"));
			if (tableCells.get(itemIndex).getText().equals(itemName)){
				return true;
			}
		}
		return false;
	}

}
