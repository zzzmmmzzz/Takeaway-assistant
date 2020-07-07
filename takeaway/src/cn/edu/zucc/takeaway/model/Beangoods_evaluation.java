package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class Beangoods_evaluation {
   private String goods_id;
   private String cus_id;
   private String evaluation_content;
   private Date evaluation_date;
   private int evaluation_star;
   //private mediumtext evaluation_pic;

public Date getEvaluation_date() {
	return evaluation_date;
}
public String getGoods_id() {
	return goods_id;
}
public void setGoods_id(String goods_id) {
	this.goods_id = goods_id;
}
public String getCus_id() {
	return cus_id;
}
public void setCus_id(String cus_id) {
	this.cus_id = cus_id;
}
public String getEvaluation_content() {
	return evaluation_content;
}
public void setEvaluation_content(String evaluation_content) {
	this.evaluation_content = evaluation_content;
}
public void setEvaluation_date(Date evaluation_date) {
	this.evaluation_date = evaluation_date;
}
public int getEvaluation_star() {
	return evaluation_star;
}
public void setEvaluation_star(int evaluation_star) {
	this.evaluation_star = evaluation_star;
}
   
}
