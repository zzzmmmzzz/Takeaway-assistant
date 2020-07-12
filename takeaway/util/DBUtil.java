package cn.edu.zucc.takeaway.util;

import java.sql.Connection;

public class DBUtil {
 private static final String jdbcUrl="jdbc:mysql://localhost:3306/takeaway?useUnicode=true&characterEncoding=UTF-8&&serverTimezone=UTC";
 private static final String dbUser="root";
 private static final String dbPwd="admin";
 static{
  try {
   Class.forName("com.mysql.cj.jdbc.Driver");
  } catch (ClassNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 public static Connection getConnection() throws java.sql.SQLException{
  return java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
 }
}