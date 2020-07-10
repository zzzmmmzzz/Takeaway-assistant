package cn.edu.zucc.takeaway.model;

public class Beanreduce {
   private String reduce_id;
   private String Merchant_id;
   private float reduce_amount;
   private float coupons_amount;
   private boolean reduce_more;

public String getReduce_id() {
	return reduce_id;
}
public void setReduce_id(String reduce_id) {
	this.reduce_id = reduce_id;
}
public String getMerchant_id() {
	return Merchant_id;
}
public void setMerchant_id(String merchant_id) {
	Merchant_id = merchant_id;
}
public float getReduce_amount() {
	return reduce_amount;
}
public void setReduce_amount(float reduce_amount) {
	this.reduce_amount = reduce_amount;
}
public float getCoupons_amount() {
	return coupons_amount;
}
public void setCoupons_amount(float coupons_amount) {
	this.coupons_amount = coupons_amount;
}
public boolean isReduce_more() {
	return reduce_more;
}
public void setReduce_more(boolean reduce_more) {
	this.reduce_more = reduce_more;
}
   
}
