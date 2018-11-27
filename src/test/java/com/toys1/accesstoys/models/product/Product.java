package com.toys1.accesstoys.models.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
	
	private WebElement productElement;
	
	public Product(WebElement productElement) {
		this.productElement = productElement;
	}
	
	By productTitle = By.className("product-title");
	By productPrice = By.className("product-price");
	By buyButton = By.linkText("Buy");
	
	//get title
	public String getProductTitle() {
		return this.productElement.findElement(productTitle).getText();
	}
	
	//get price
	public Double getProductPrice() {
		return Double.parseDouble(this.productElement.findElement(productPrice).getText().replace("$", ""));
	}
	
	//click buy button
	public void clickBuyButton() {
		this.productElement.findElement(buyButton).click();
	}

}
