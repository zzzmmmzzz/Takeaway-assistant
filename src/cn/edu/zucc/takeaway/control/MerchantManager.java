package cn.edu.zucc.takeaway.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.edu.zucc.takeaway.itf.IMerchantManager;
import cn.edu.zucc.takeaway.itf.IuserManager;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;

public class MerchantManager implements IMerchantManager{

	public List<Beanmerchant> searchuser(String text) throws BaseException{
		// TODO Auto-generated method stub
		List<Beanmerchant> result=new ArrayList<Beanmerchant>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select Merchant_id,Merchant_name,Merchant_star,Merchant_avgc,Merchant_total"
					+ " from merchant where Merchant_name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,text);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanmerchant mc = new Beanmerchant();
				mc.setMerchant_id(rs.getString(1));
				mc.setMerchant_name(rs.getString(2));
				mc.setMerchant_star(rs.getInt(3));
				mc.setMerchant_avgc(rs.getFloat(4));
				mc.setMerchant_total(rs.getFloat(5));
				result.add(mc);
			
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
     public  void createMerchant(Beanmerchant mc) throws BaseException{
		
		
		if( "".equals(mc.getMerchant_id()) || "".equals(mc.getMerchant_name())){
			throw new BusinessException("商家编号，姓名不能为空");
		}
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from merchant where Merchant_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,mc.getMerchant_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("商家已存在");
			rs.close();
			pst.close();
			sql="insert into merchant(Merchant_id,Merchant_name,Merchant_star,Merchant_avgc,Merchant_total) "
					+ "values(?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, mc.getMerchant_id());
			pst.setString(2, mc.getMerchant_name());
			pst.setInt(3, mc.getMerchant_star());
			pst.setFloat(4, mc.getMerchant_avgc());
			pst.setFloat(5, mc.getMerchant_total());
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
	public List<Beanmerchant> loadAll() throws BaseException {
		List<Beanmerchant> result=new ArrayList<Beanmerchant>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select Merchant_id,Merchant_name,Merchant_star,Merchant_avgc,Merchant_total"
					+ " from merchant";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			//pst.setString(1, Beanmerchant.currentLoginUser);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanmerchant mc = new Beanmerchant();
				mc.setMerchant_id(rs.getString(1));
				mc.setMerchant_name(rs.getString(2));
				mc.setMerchant_star(rs.getInt(3));
				mc.setMerchant_avgc(rs.getFloat(4));
				mc.setMerchant_total(rs.getFloat(5));
				result.add(mc);
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

	public void removeMerchant(Beanmerchant beanmerchant)throws BaseException {
		// TODO Auto-generated method stub
		if(beanmerchant.getMerchant_id()==null || "".equals(beanmerchant.getMerchant_id()) ){throw new BusinessException("商家为空");}
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from merchant where Merchant_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, beanmerchant.getMerchant_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("商家不存在");
			sql="delete from merchant where merchant_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, beanmerchant.getMerchant_id());
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
