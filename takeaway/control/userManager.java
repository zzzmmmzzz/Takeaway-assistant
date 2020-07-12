package cn.edu.zucc.takeaway.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.edu.zucc.takeaway.itf.IuserManager;
import cn.edu.zucc.takeaway.model.Beanaddress;
import cn.edu.zucc.takeaway.model.Beancus;
import cn.edu.zucc.takeaway.model.Beanuser;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;


public class userManager implements IuserManager {

	public static Beanuser currentUser=null;
	public List<Beanuser> loadAllUsers(boolean withDeletedUser)throws BaseException{
		List<Beanuser> result=new ArrayList<Beanuser>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select clerk_id,clerk_name,clerk_password from user";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Beanuser u=new Beanuser();
				u.setClerk_id(rs.getString(1));
				u.setClerk_name(rs.getString(2));
                u.setClerk_password(rs.getString(3));
				result.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}

	public Beanuser reg(String userid, String pwd,String pwd2) throws BaseException {
		// TODO Auto-generated method stub
		if("".equals(userid) || userid.length()>20){
			throw new BusinessException("�˺�Ϊ�ջ򳬳�����");
		}
		if("".equals(pwd) ||pwd.length()>50){
			throw new BusinessException("����Ϊ�ջ򳬳�����");
		}
		if(!pwd.equals(pwd2)) {
			throw new BusinessException("���벻һ��");
		}
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			
			String sql="select * from user where clerk_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("��½�˺��Ѿ�����");
			rs.close();
			pst.close();
			sql="insert into tbl_user(clerk_id,clerk_name,clerk_password) values(?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2,pwd);
		    pst.setString(3, pwd2);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}

	
	@Override
	public Beanuser login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			if(userid==null) throw new BusinessException("�˺Ų���Ϊ��");
			String sql="select clerk_id,clerk_name,clerk_password from user where clerk_id=? and clerk_password=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			pst.setString(2, pwd);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("��½�˺Ų����ڻ��������");
			//rs.close();
			//pst.close();
			/*sql="select user_id,user_pwd,register_time from tbl_user where user_pwd=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, pwd);
			rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("�������");*/
			Beanuser u=new Beanuser();
			u.setClerk_id(rs.getString(1));
			u.setClerk_name(rs.getString(2));
			u.setClerk_password(rs.getString(3));
			//if(u.getRegister_time()==null) throw new BusinessException("���˺��Ѿ���ɾ��");
			rs.close();
			pst.close();
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}


	@Override
	public void changePwd(Beanuser user, String oldPwd, String newPwd,
			String newPwd2) throws BaseException {
		// TODO Auto-generated method stub
		if(oldPwd==null) throw new BusinessException("ԭʼ���벻��Ϊ��");
		if(newPwd==null || "".equals(newPwd) || newPwd.length()>20) throw new BusinessException("����Ϊ1-20���ַ�");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select clerk_password from user where clerk_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,user.getClerk_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("��½�˺Ų�����");
			if(!oldPwd.equals(rs.getString(1))) throw new BusinessException("ԭʼ�������");
			rs.close();
			pst.close();
			sql="update user set clerk_password=? where clerk_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, newPwd);
			pst.setString(2, user.getClerk_id());
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	
	}
	
	
}