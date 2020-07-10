package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class Beanrider_wage {
  private String rider_id;
  private String order_id;
  private Date order_time;
  private int cus_evaluation;
  private float order_amount;

public String getRider_id() {
	return rider_id;
}
public void setRider_id(String rider_id) {
	this.rider_id = rider_id;
}
public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public Date getOrder_time() {
	return order_time;
}
public void setOrder_time(Date order_time) {
	this.order_time = order_time;
}
public int getCus_evaluation() {
	return cus_evaluation;
}
public void setCus_evaluation(int cus_evaluation) {
	this.cus_evaluation = cus_evaluation;
}
public float getOrder_amount() {
	return order_amount;
}
public void setOrder_amount(float order_amount) {
	this.order_amount = order_amount;
}
  
}
