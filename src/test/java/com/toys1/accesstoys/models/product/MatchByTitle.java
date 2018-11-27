package com.toys1.accesstoys.models.product;

public class MatchByTitle implements MatchStrategy {
	
	private String productTitle;
	
	public MatchByTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	@Override
	public Boolean matchProduct(Product product) {
		return (product.getProductTitle().equals(this.productTitle));
	}

}
