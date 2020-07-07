package cn.edu.zucc.takeaway.model;

public class Beanuser {
  public static Beanuser currentLoginUser=null;
private String clerk_id;
  private String clerk_name;
  private String clerk_password;

public static Beanuser getCurrentLoginUser() {
	return currentLoginUser;
}
public static void setCurrentLoginUser(Beanuser currentLoginUser) {
	Beanuser.currentLoginUser = currentLoginUser;
}
public String getClerk_id() {
	return clerk_id;
}
public void setClerk_id(String clerk_id) {
	this.clerk_id = clerk_id;
}
public String getClerk_name() {
	return clerk_name;
}
public void setClerk_name(String clerk_name) {
	this.clerk_name = clerk_name;
}
public String getClerk_password() {
	return clerk_password;
}
public void setClerk_password(String clerk_password) {
	this.clerk_password = clerk_password;
}
  
}
