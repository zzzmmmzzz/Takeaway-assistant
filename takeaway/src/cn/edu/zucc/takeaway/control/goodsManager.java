package cn.edu.zucc.takeaway.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.takeaway.itf.IgoodsManager;
import cn.edu.zucc.takeaway.model.Beangoods_details;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;

public class goodsManager implements IgoodsManager{
	public List<Beangoods_details> loadAll() throws BaseException {
		List<Beangoods_details> result=new ArrayList<Beangoods_details>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select goods_id,categories_id,goods_name,goods_price,goods_reduce"
					+ " from merchant";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			//pst.setString(1, Beanmerchant.currentLoginUser);
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

}
