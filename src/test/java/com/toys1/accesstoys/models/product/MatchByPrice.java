package com.toys1.accesstoys.models.product;

public class MatchByPrice implements MatchStrategy {
	
	private Double productPrice;
	
	public MatchByPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public Boolean matchProduct(Product product) {
		return (product.getProductPrice().equals(this.productPrice));
	}

}
