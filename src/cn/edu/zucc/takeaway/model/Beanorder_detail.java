package cn.edu.zucc.takeaway.model;

public class Beanorder_detail {
  private String order_id;
  private String goods_id;
  private int cnt;
  private float goods_price;
  private float goods_reduce;

public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public String getGoods_id() {
	return goods_id;
}
public void setGoods_id(String goods_id) {
	this.goods_id = goods_id;
}
public int getCnt() {
	return cnt;
}
public void setCnt(int cnt) {
	this.cnt = cnt;
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
	if(col==0) return order_id;
	else if(col==1) return String.valueOf(cnt);
	else if(col==2) return String.valueOf(goods_price);
	else if(col==3) return String.valueOf(goods_reduce);
	
	else return "";
}
  
}
