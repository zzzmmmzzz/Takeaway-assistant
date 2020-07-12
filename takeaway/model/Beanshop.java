package cn.edu.zucc.takeaway.model;

public class Beanshop {
   private String Merchant_name;
   private String goods_name;
   private float goods_price;
   private int goods_amount;
public String getMerchant_name() {
	return Merchant_name;
}
public void setMerchant_name(String merchant_name) {
	Merchant_name = merchant_name;
}
public String getGoods_name() {
	return goods_name;
}
public void setGoods_name(String goods_name) {
	this.goods_name = goods_name;
}
public float getGoods_price() {
	return goods_price;
}
public void setGoods_price(float goods_price) {
	this.goods_price = goods_price;
}
public int getGoods_amount() {
	return goods_amount;
}
public void setGoods_amount(int goods_amount) {
	this.goods_amount = goods_amount;
}
   
}
