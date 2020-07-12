package cn.edu.zucc.takeaway.model;

public class Beanordercoupons {
  private String Merchant_id;
  private String cus_id;
  private int need;
  private int already;

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
public int getNeed() {
	return need;
}
public void setNeed(int need) {
	this.need = need;
}
public int getAlready() {
	return already;
}
public void setAlready(int already) {
	this.already = already;
}
  
}
