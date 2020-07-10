package cn.edu.zucc.takeaway.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.takeaway.itf.IcustomerManager;
import cn.edu.zucc.takeaway.itf.IuserManager;
import cn.edu.zucc.takeaway.model.Beancus;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.model.Beanuser;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;

public class customerManager implements IcustomerManager{
	public List<Beancus> loadAllUsers(boolean withDeletedUser)throws BaseException{
		return null;
		
	}
	public Beancus reg(Beancus cus,String pwd,String pwd2) throws BaseException{
		if("".equals(cus.getCus_id())){
			throw new BusinessException("用户编号不能为空");
		}
		if(!pwd.equals(pwd2)) {
			throw new BusinessException("密码不一致");
		}
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from cus where cus_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,cus.getCus_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("登陆账号已经存在");
			rs.close();
			pst.close();
			sql="insert into cus(cus_id,cus_name,cus_password,cus_sex,cus_email,cus_city,cus_vip) "
					+ "values(?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, cus.getCus_id());
			pst.setString(2, cus.getCus_name());
			pst.setString(3, cus.getCus_password());
			pst.setInt(4, cus.getCus_sex());
			pst.setString(5, cus.getCus_email());
			pst.setString(6, cus.getCus_city());
			pst.setInt(7, cus.getCus_vip());
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

	public Beancus login(String userid, String pwd) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			if(userid==null) throw new BusinessException("账号不能为空");
			String sql="select cus_id,cus_name,cus_password from cus where cus_id=? and cus_password=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			pst.setString(2, pwd);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("登陆账号不存在或密码错误");
			//rs.close();
			//pst.close();
			/*sql="select user_id,user_pwd,register_time from tbl_user where user_pwd=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, pwd);
			rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("密码错误");*/
			Beancus c=new Beancus();
			c.setCus_id(rs.getString(1));
			c.setCus_name(rs.getString(2));
			c.setCus_password(rs.getString(3));
		
			//if(u.getRegister_time()==null) throw new BusinessException("该账号已经被删除");
			rs.close();
			pst.close();
			return c;
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
	public void changePwd(Beanuser user, String oldPwd, String newPwd,
			String newPwd2) throws BaseException {
		
	}
	@Override
	public Beancus reg(String clerkname, String pwd, String pwd2) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Beancus> searchReader(String text, int rtId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Beancus> loadAll() throws BaseException {
		List<Beancus> result=new ArrayList<Beancus>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select cus_id,cus_name,cus_sex,cus_password,cus_tel,cus_email,cus_city,cus_regtime,cus_vip"
					+ " from cus";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			//pst.setString(1, Beanmerchant.currentLoginUser);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beancus cus = new Beancus();
				cus.setCus_id(rs.getString(1));
			    cus.setCus_name(rs.getString(2));
			    cus.setCus_sex(rs.getInt(3));
			    cus.setCus_password(rs.getString(4));
			    cus.setCus_tel(rs.getString(5));
			    cus.setCus_email(rs.getString(6));
			    cus.setCus_city(rs.getString(7));
			    cus.setCus_regtime(rs.getDate(8));
			    cus.setCus_vip(rs.getInt(9));
				result.add(cus);
			}
			
		}catch (SQLException e) {
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
	
	public List<Beancus> searchuser(String text) {
		// TODO Auto-generated method stub
		List<Beancus> result=new ArrayList<Beancus>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select cus_id,cus_name,cus_sex,cus_password,cus_tel,cus_email,cus_city,cus_regtime,cus_vip"
					+ " from cus where cus_name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,text);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beancus cus = new Beancus();
				cus.setCus_id(rs.getString(1));
			    cus.setCus_name(rs.getString(2));
			    cus.setCus_sex(rs.getInt(3));
			    cus.setCus_password(rs.getString(4));
			    cus.setCus_tel(rs.getString(5));
			    cus.setCus_email(rs.getString(6));
			    cus.setCus_city(rs.getString(7));
			    cus.setCus_regtime(rs.getDate(8));
			    cus.setCus_vip(rs.getInt(9));
				result.add(cus);
			}
			
		}catch (SQLException e) {
		 e.printStackTrace();
		 //throw new DbException(e);
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
}
