package com.toys1.accesstoys.models.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.toys1.accesstoys.models.product.MatchByTitle;
import com.toys1.accesstoys.models.product.MatchStrategy;
import com.toys1.accesstoys.models.product.Product;

public class ShopPage extends BaseNavigation {

	public ShopPage(WebDriver driver) {
		super(driver);
	}

	//Find the Product NAME on the webpage and return a Product Price
	public Product findProduct(MatchStrategy strategy) throws Exception {
		//get a list of products from the Product class
        List<WebElement> products = driver.findElements(By.className("product"));
        for(WebElement productElement : products) {
        	Product product = new Product(productElement);
        	//Search the list of products for the Product Name
            if (strategy.matchProduct(product)) {
            	//If the Product Name is found in the list then find and return the Product Price
            	return product;
            }
        }
        //If the Product Name is not found then return an error message
        throw new Exception("No product found");
	}

//Add any single product to your cart
public void addItem(String itemAdd) throws Exception
{
	Product product = findProduct(new MatchByTitle(itemAdd));
	product.clickBuyButton();
	}

}
