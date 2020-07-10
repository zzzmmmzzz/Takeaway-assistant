package cn.edu.zucc.takeaway.model;

public class Beangoods_categories {
  private String categories_id;
  private String Merchant_id;
  private String categories_canme;
  private int goods_count;
  public static final String[] tableTitles={"商品分类","商家编号 ","分类名称","商品数量"};
public String getCategories_id() {
	return categories_id;
}
public void setCategories_id(String categories_id) {
	this.categories_id = categories_id;
}
public String getMerchant_id() {
	return Merchant_id;
}
public void setMerchant_id(String merchant_id) {
	Merchant_id = merchant_id;
}
public String getCategories_canme() {
	return categories_canme;
}
public void setCategories_canme(String categories_canme) {
	this.categories_canme = categories_canme;
}
public int getGoods_count() {
	return goods_count;
}
public void setGoods_count(int goods_count) {
	this.goods_count = goods_count;
}
public String getCell(int col) {
	// TODO Auto-generated method stub
	if(col==0) return String.valueOf(getCategories_id());
	else if(col==1) return String.valueOf(getMerchant_id());
	else if(col==2) return String.valueOf(getCategories_canme());
	else if(col==3) return String.valueOf(getGoods_count());
	
	else return "";
} 
}
