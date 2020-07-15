package cn.edu.zucc.takeaway.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.edu.zucc.takeaway.itf.IgoodsManager;
import cn.edu.zucc.takeaway.model.Beangoods_categories;
import cn.edu.zucc.takeaway.model.Beangoods_details;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.model.Beanorder_detail;
import cn.edu.zucc.takeaway.model.Beanorders;
import cn.edu.zucc.takeaway.model.Beanshop;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;

public class goodsManager implements IgoodsManager{
	public List<Beangoods_details> loadAll(Beangoods_categories gc) {
		List<Beangoods_details> result=new ArrayList<Beangoods_details>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select goods_id,categories_id,goods_name,goods_price,goods_reduce"
					+ " from goods_details  where categories_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, gc.getCategories_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beangoods_details gd = new Beangoods_details();
				gd.setGoods_id(rs.getString(1));
			    gd.setCategories_id(rs.getString(2));
			    gd.setGoods_name(rs.getString(3));
			    gd.setGoods_price(rs.getFloat(4));
			    gd.setGoods_reduce(rs.getFloat(5));
				result.add(gd);
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
	
	public List<Beangoods_categories> loadAllcategories(Beanmerchant mc) throws BaseException {
		List<Beangoods_categories> result=new ArrayList<Beangoods_categories>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select categories_id,Merchant_id,categories_cname,goods_count"
					+ " from goods_categories where Merchant_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, mc.getMerchant_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beangoods_categories gc = new Beangoods_categories();
				gc.setCategories_id(rs.getString(1));
			    gc.setMerchant_id(rs.getString(2));
			    gc.setCategories_canme(rs.getString(3));
			    gc.setGoods_count(rs.getInt(4));
				result.add(gc);
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
	public void addcate(String name, String cateid, String catename, String cnt) throws Exception {
		if("".equals(name))throw new BusinessException("商品类别不为空");
		Beangoods_categories cate=new Beangoods_categories();
		Beangoods_details detail=new Beangoods_details();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select categories_cname from goods_categories where categories_cname=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, catename);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next())throw new BusinessException("类别已存在");
			else {
				pst.close();
				rs.close();
				//int categories_id=0;//计算
				//sql="select plan_order from tbl_plan where user_id=? order by plan_order desc";
				//sql="select max(plan_order) from tbl_plan where user_id=?";
				//pst=conn.prepareStatement(sql);
				//pst.setString(1, bu.currentLoginUser.getUser_id());
				//rs=pst.executeQuery();
				//if(rs.next())
				//	plan_order=rs.getInt(1)+1;
				//else
				//	plan_order=1;
				//pst.close();
				//rs.close();
				sql="insert into goods_categories (categories_id,Merchant_id,categories_cname,goods_count) "
						+ "values(?.?,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setString(1,cateid);
				pst.setString(2,name);
				pst.setString(3, catename);
				pst.setString(4, cnt);
				//pst.setTimestamp(4,new java.sql.Timestamp(System.currentTimeMillis()));
				//pst.setInt(5,0);
				//pst.setInt(6,0);
				//pst.setInt(7,0);
				pst.execute();
				pst.close();	
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
		//return null;
	}

	@Override
	public List<Beangoods_categories> loadAllcategories() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void creatgoods(String goodid, String cateid, String goodname, String price, String reduce) throws Exception {
		if("".equals(goodid))throw new BusinessException("商品编号不为空");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select goods_name from goods_details where goods_name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, goodname);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next())throw new BusinessException("商品已存在");
			else {
				pst.close();
				rs.close();
				sql="insert into goods_details (goods_id,categories_id,goods_name,goods_price,goods_reduce)"
						+ "values(?,?,?,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setString(1,goodid);
				pst.setString(2,cateid);
				pst.setString(3,goodname);
				pst.setString(4,price);
				pst.setString(5,reduce);
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
		
		
	}

	public List<Beanshop> addgoods(Beangoods_details de) {
		// TODO Auto-generated method stub
		List<Beanshop> result=new ArrayList<Beanshop>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into shop( goods_name,goods_amount,goods_price,goods_reduce )"
					+ "values (?,1,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, de.getGoods_name());
            pst.setFloat(2, de.getGoods_price());
            pst.setFloat(3, de.getGoods_reduce());
            pst.execute();
            
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
	
	public List<Beanshop> listshop(){
		List<Beanshop> result=new ArrayList<Beanshop>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select goods_name,goods_amount,goods_price,goods_reduce from shop ";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanshop shop = new Beanshop();
				//shop.setMerchant_name(rs.getString(1));
			    shop.setGoods_name(rs.getString(1));
			    shop.setGoods_price(rs.getFloat(3));
			    shop.setGoods_amount(rs.getInt(2));
			    shop.setGoods_reduce(rs.getFloat(4));
				result.add(shop);
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
	
	public List<Beanshop> pay(){
		List<Beanshop> result=new ArrayList<Beanshop>();   
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select sum(goods_price) from shop";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
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
	
	public void delshop(){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from shop";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.execute();
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

		
	}
	public List<Beanorders> loadAllord() throws BaseException{
		List<Beanorders> result=new ArrayList<Beanorders>();   
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select rider_id,cus_id,order_start_time,address_id from orders ";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanorders shop = new Beanorders();
				//shop.setMerchant_name(rs.getString(1));
			    shop.setRider_id(rs.getString(1));
			    shop.setCus_id(rs.getString(2));
			    shop.setOrder_start_time(rs.getDate(3));
			    shop.setAddress_id(rs.getInt(4));
				result.add(shop);
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
	public List<Beanorder_detail> loaddetail(Beanorders curPlan) throws BaseException{
		List<Beanorder_detail> result=new ArrayList<Beanorder_detail>();   
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select order_id,cnt,goods_price,goods_reduce from order_detail ";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanorder_detail shop = new Beanorder_detail();
				//shop.setMerchant_name(rs.getString(1));
			    shop.setOrder_id(rs.getString(1));
			    shop.setCnt(rs.getInt(2));
			    shop.setGoods_price(rs.getFloat(3));
			    shop.setGoods_reduce(rs.getFloat(4));
				result.add(shop);
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
