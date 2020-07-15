package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class Beanorders {
  private String order_id;
  private String Merchant_id;
  private String cus_id;
  private String rider_id;
  private float original_amount;
  private float finally_amount;
  private int reduce_id;
  private int coupons_id;
  private Date order_start_time;
  private Date order_finish_time;
  private int address_id;
  private int order_state;

public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public String getMerchant_id() {
	return Merchant_id;
}
public void setMerchant_id(String merchant_id) {
	Merchant_id = merchant_id;
}
public String getCus_id() {
	return cus_id;
}
public void setCus_id(String cus_id) {
	this.cus_id = cus_id;
}
public String getRider_id() {
	return rider_id;
}
public void setRider_id(String rider_id) {
	this.rider_id = rider_id;
}
public float getOriginal_amount() {
	return original_amount;
}
public void setOriginal_amount(float original_amount) {
	this.original_amount = original_amount;
}
public float getFinally_amount() {
	return finally_amount;
}
public void setFinally_amount(float finally_amount) {
	this.finally_amount = finally_amount;
}
public int getReduce_id() {
	return reduce_id;
}
public void setReduce_id(int reduce_id) {
	this.reduce_id = reduce_id;
}
public int getCoupons_id() {
	return coupons_id;
}
public void setCoupons_id(int coupons_id) {
	this.coupons_id = coupons_id;
}
public Date getOrder_start_time() {
	return order_start_time;
}
public void setOrder_start_time(Date order_start_time) {
	this.order_start_time = order_start_time;
}
public Date getOrder_finish_time() {
	return order_finish_time;
}
public void setOrder_finish_time(Date order_finish_time) {
	this.order_finish_time = order_finish_time;
}
public int getAddress_id() {
	return address_id;
}
public void setAddress_id(int address_id) {
	this.address_id = address_id;
}
public int getOrder_state() {
	return order_state;
}
public void setOrder_state(int order_state) {
	this.order_state = order_state;
}
public String getCell(int col) {
	// TODO Auto-generated method stub
	if(col==0) return rider_id;
	else if(col==1) return cus_id;
	else if(col==2) return String.valueOf(order_start_time);
	else if(col==3) return String.valueOf(address_id);
	
	else return "";
} 
}
