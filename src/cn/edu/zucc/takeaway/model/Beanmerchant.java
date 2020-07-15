package cn.edu.zucc.takeaway.model;

public class Beanmerchant {
  public static String currentLoginUser;
private String Merchant_id;
  private String Merchant_name;
  private int Merchant_star;
  private float Merchant_avgc;
  private float Merchant_total;
  public static final String[] tableTitles={"商家编号","商家名","商家星级","人均消费","总销量"};
  
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
public String getCell(int col) {
	// TODO Auto-generated method stub
	if(col==0) return String.valueOf(getMerchant_id());
	else if(col==1) return String.valueOf(getMerchant_name());
	else if(col==2) return String.valueOf(getMerchant_star());
	else if(col==3) return String.valueOf(getMerchant_avgc());
	else if(col==4) return String.valueOf(getMerchant_total());
	else return "";

}
  
}
