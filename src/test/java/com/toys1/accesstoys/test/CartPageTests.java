package com.toys1.accesstoys.test;

import org.junit.Assert;
import org.junit.Test;

import com.toys1.accesstoys.models.pages.CartPage;
import com.toys1.accesstoys.models.pages.HomePage;
import com.toys1.accesstoys.models.pages.ShopPage;
//import com.toys1.accesstoys.utility.Screenshot;

public class CartPageTests extends BaseTestSuite {
		//Screenshot screenie = new Screenshot();
		
		@Test
		public void verifyCartCountTest() throws Exception {

			HomePage homePage = new HomePage(driver);
			CartPage cartPage = new CartPage(driver);
			
			String item1 = "Teddy Bear";
		
			//Verify the Cart Count == 0
			Assert.assertEquals("Check cart is empty", "0", cartPage.checkCart());
			
			//Click the Shop menu
			ShopPage shopPage = homePage.clickShopLink();
			
			//Add any single product to your cart
			shopPage.addItem(item1);
			
			//Verify that the cart count (top right hand corner) is 1
			Assert.assertEquals("Check cart has 1 item", "5", cartPage.checkCart());
			//Take a screenshot
			//screenie.screenShot("verifyCartCountTest_1 Item Added");
			
			//Click the Cart menu
			shopPage.clickCartLink();
			
			//Click the “Empty Cart’ button
			cartPage.emptyCart();
			
			//Confirm
			cartPage.emptyCartYes();
			
			//Verify the Cart Count == 0
			Assert.assertEquals("Check cart is empty", "0", cartPage.checkCart());	
			//Take a screenshot
			//screenie.screenShot("verifyCartCountTest_2 Cart Empty");
		}
		
		@Test
		public void modifyCartContentsTest() throws Exception{
			HomePage homePage = new HomePage(driver);
			CartPage cartPage = new CartPage(driver);
			
			
			//Set up Test Data
			String item1 = "Teddy Bear";
			String item2 = "Fluffy Bunny";
			String item3 = "Smiley Face";
			String quantity = "3";
			String expectedSubTotal = "$29.97";
			String expectedTotal = "Total: 39.96";
			
			//Verify the Cart Count == 0
			Assert.assertEquals("Check cart is empty", "0", cartPage.checkCart());
			
			//Click the Shop menu
			ShopPage shopPage = homePage.clickShopLink();

			//Add a Teddy Bear, a Smiley Face and a Fluffy Bunny to the cart
			shopPage.addItem(item1);
			shopPage.addItem(item2);
			shopPage.addItem(item3);
			
			//Click the Cart menu
			shopPage.clickCartLink();
			
			//Increase the quantity of Smiley Face to 3
			cartPage.setItemQuantity(item3,quantity);
			
			//Verify the Sub Total of Smiley Face
			Assert.assertEquals("Subtotal is correct", expectedSubTotal, cartPage.getSubTotal(item3));
			//Take a screenshot
			//screenie.screenShot("modifyCartContentsTest_1 Subtotal");
			
			//Remove Teddy Bear from the cart
			cartPage.removeItem(item1);
			
			//Confirm removal
			cartPage.emptyCartYes();
			
			//Validate the cart count is 4
			Assert.assertEquals("Check cart count is 4", "4", cartPage.checkCart());		
			
			//Validate the total
			Assert.assertEquals("Check Total", expectedTotal, cartPage.getTotal());
			//Take a screenshot
			//screenie.screenShot("modifyCartContentsTest_2 Total");
			
			//Click the “Empty Cart’ button
			cartPage.emptyCart();
			
			//Confirm
			cartPage.emptyCartYes();
			
			//Verify the Cart Count == 0
			Assert.assertEquals("Check cart is empty", "0", cartPage.checkCart());
		}

}
