package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class Beancus_coupons {
  private String cus_id;
  private String coupons_id;
  private float cou_count;
  private Date coupons_finish_date;

public String getCus_id() {
	return cus_id;
}
public void setCus_id(String cus_id) {
	this.cus_id = cus_id;
}
public String getCoupons_id() {
	return coupons_id;
}
public void setCoupons_id(String coupons_id) {
	this.coupons_id = coupons_id;
}
public float getCou_count() {
	return cou_count;
}
public void setCou_count(float cou_count) {
	this.cou_count = cou_count;
}
public Date getCoupons_finish_date() {
	return coupons_finish_date;
}
public void setCoupons_finish_date(Date coupons_finish_date) {
	this.coupons_finish_date = coupons_finish_date;
}
  
  
}
