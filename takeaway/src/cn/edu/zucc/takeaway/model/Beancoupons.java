package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class Beancoupons {
   private String coupons_id;
   private String Merchant_id;
   private float coupons_amount;
   private int coupons_count;
   private Date coupons_start_date;
   private Date coupons_finish_date;

public String getCoupons_id() {
	return coupons_id;
}
public void setCoupons_id(String coupons_id) {
	this.coupons_id = coupons_id;
}
public String getMerchant_id() {
	return Merchant_id;
}
public void setMerchant_id(String merchant_id) {
	Merchant_id = merchant_id;
}
public float getCoupons_amount() {
	return coupons_amount;
}
public void setCoupons_amount(float coupons_amount) {
	this.coupons_amount = coupons_amount;
}
public int getCoupons_count() {
	return coupons_count;
}
public void setCoupons_count(int coupons_count) {
	this.coupons_count = coupons_count;
}
public Date getCoupons_start_date() {
	return coupons_start_date;
}
public void setCoupons_start_date(Date coupons_start_date) {
	this.coupons_start_date = coupons_start_date;
}
public Date getCoupons_finish_date() {
	return coupons_finish_date;
}
public void setCoupons_finish_date(Date coupons_finish_date) {
	this.coupons_finish_date = coupons_finish_date;
}
   
}
