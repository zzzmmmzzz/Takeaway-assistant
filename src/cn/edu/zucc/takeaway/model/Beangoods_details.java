package cn.edu.zucc.takeaway.model;

public class Beangoods_details {
  private String goods_id;
  private String categories_id;
  private String goods_name;
  private float goods_price;
  private float goods_reduce;

  public static final String[] tableTitles={"商品编号","所属类别编号","商品名","价格","优惠价格"};
public String getGoods_id() {
	return goods_id;
}
public void setGoods_id(String goods_id) {
	this.goods_id = goods_id;
}
public String getCategories_id() {
	return categories_id;
}
public void setCategories_id(String categories_id) {
	this.categories_id = categories_id;
}
public String getGoods_name() {
	return goods_name;
}
public void setGoods_name(String goods_name) {
	this.goods_name = goods_name;
}
public float getGoods_price() {
	return goods_price;
}
public void setGoods_price(float goods_price) {
	this.goods_price = goods_price;
}
public float getGoods_reduce() {
	return goods_reduce;
}
public void setGoods_reduce(float goods_reduce) {
	this.goods_reduce = goods_reduce;
}
public String getCell(int col) {
	// TODO Auto-generated method stub
	if(col==0) return String.valueOf(getGoods_id());
	else if(col==1) return String.valueOf(getCategories_id());
	else if(col==2) return String.valueOf(getGoods_name());
	else if(col==3) return String.valueOf(getGoods_price());
	else if(col==4) return String.valueOf(getGoods_reduce());
	else return "";
}
  
}
