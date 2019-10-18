package com.test.test.vo;

public class commerce {

	private int regular_price;
	private int discount_price;
	private int discount_rate;
	public commerce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRegular_price() {
		return regular_price;
	}
	public void setRegular_price(int regular_price) {
		this.regular_price = regular_price;
	}
	public int getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(int discount_price) {
		this.discount_price = discount_price;
	}
	public int getDiscount_rate() {
		return discount_rate;
	}
	public void setDiscount_rate(int discount_rate) {
		this.discount_rate = discount_rate;
	}
	@Override
	public String toString() {
		return "commerce [regular_price=" + regular_price + ", discount_price=" + discount_price + ", discount_rate="
				+ discount_rate + "]";
	}

	
	
	
}
