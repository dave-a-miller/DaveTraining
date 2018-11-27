package com.toys1.accesstoys.test;

import org.junit.Assert;
import org.junit.Test;

import com.toys1.accesstoys.models.pages.HomePage;
import com.toys1.accesstoys.models.pages.ShopPage;
import com.toys1.accesstoys.models.product.MatchByPrice;
import com.toys1.accesstoys.models.product.MatchByTitle;
import com.toys1.accesstoys.models.product.Product;


public class ShopPageTest extends BaseTestSuite {

                @Test
                public void validateProductPriceCorrect() throws Exception {
                 	//Set variables
                	String name = "Smiley Bear";
                	Double expectedPrice = 14.99;
                				
                	//Navigate to the Shop Page
                	HomePage homePage = new HomePage(driver);
                	ShopPage shopPage = homePage.clickShopLink();
                	Product product = shopPage.findProduct(new MatchByTitle(name));
                                
                	//Verify the price for the Stuffed Frog is $10.99
                	Assert.assertEquals("price is correct", expectedPrice, product.getProductPrice());                
                }
                
                @Test
                public void validateProductNameCorrect() throws Exception {
                	//Set variables
                	String name = "Teddy Bear";
                	Double price = 12.99;
                				
                	//Navigate to the Shop Page
                	HomePage homePage = new HomePage(driver);
                	ShopPage shopPage = homePage.clickShopLink();
                	Product product = shopPage.findProduct(new MatchByPrice(price));
                                
                	//Verify the price of $12.99 is associated to Teddy Bear 
                	Assert.assertEquals("product name is correct", name, product.getProductTitle());
                }

}
