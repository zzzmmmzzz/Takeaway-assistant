package cn.edu.zucc.takeaway.model;

import java.util.Date;

public class Beancus {
   public static Object currentloginUser;
private String cus_id;
   private String cus_name;
   private int cus_sex;
   private String cus_password;
   private String cus_tel;
   private String cus_email;
   private String cus_city;
   private Date cus_regtime;
   private int cus_vip;
   private Date cus_vip_time;

public static Object getCurrentloginUser() {
	return currentloginUser;
}
public static void setCurrentloginUser(Object currentloginUser) {
	Beancus.currentloginUser = currentloginUser;
}
public String getCus_id() {
	return cus_id;
}
public void setCus_id(String cus_id) {
	this.cus_id = cus_id;
}
public String getCus_name() {
	return cus_name;
}
public void setCus_name(String cus_name) {
	this.cus_name = cus_name;
}
public int getCus_sex() {
	return cus_sex;
}
public void setCus_sex(int cus_sex) {
	this.cus_sex = cus_sex;
}
public String getCus_password() {
	return cus_password;
}
public void setCus_password(String cus_password) {
	this.cus_password = cus_password;
}
public String getCus_tel() {
	return cus_tel;
}
public void setCus_tel(String cus_tel) {
	this.cus_tel = cus_tel;
}
public String getCus_email() {
	return cus_email;
}
public void setCus_email(String cus_email) {
	this.cus_email = cus_email;
}
public String getCus_city() {
	return cus_city;
}
public void setCus_city(String cus_city) {
	this.cus_city = cus_city;
}
public Date getCus_regtime() {
	return cus_regtime;
}
public void setCus_regtime(Date cus_regtime) {
	this.cus_regtime = cus_regtime;
}

public int getCus_vip() {
	return cus_vip;
}
public void setCus_vip(int cus_vip) {
	this.cus_vip = cus_vip;
}
public Date getCus_vip_time() {
	return cus_vip_time;
}
public void setCus_vip_time(Date cus_vip_time) {
	this.cus_vip_time = cus_vip_time;
}
   
   
}
