package cn.edu.zucc.takeaway.model;

public class Beanmerchant {
  public static String currentLoginUser;
private String Merchant_id;
  private String Merchant_name;
  private int Merchant_star;
  private float Merchant_avgc;
  private float Merchant_total;

public static String getCurrentLoginUser() {
	return currentLoginUser;
}
public static void setCurrentLoginUser(String currentLoginUser) {
	Beanmerchant.currentLoginUser = currentLoginUser;
}
public String getMerchant_id() {
	return Merchant_id;
}
public void setMerchant_id(String merchant_id) {
	Merchant_id = merchant_id;
}
public String getMerchant_name() {
	return Merchant_name;
}
public void setMerchant_name(String merchant_name) {
	Merchant_name = merchant_name;
}
public int getMerchant_star() {
	return Merchant_star;
}
public void setMerchant_star(int merchant_star) {
	Merchant_star = merchant_star;
}
public float getMerchant_avgc() {
	return Merchant_avgc;
}
public void setMerchant_avgc(float merchant_avgc) {
	Merchant_avgc = merchant_avgc;
}
public float getMerchant_total() {
	return Merchant_total;
}
public void setMerchant_total(float merchant_total) {
	Merchant_total = merchant_total;
}
  
}
