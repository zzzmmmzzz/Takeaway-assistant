package cn.edu.zucc.takeaway.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.takeaway.itf.IriderManager;
import cn.edu.zucc.takeaway.itf.IuserManager;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.model.Beanrider;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;
import cn.edu.zucc.takeaway.util.DBUtil;
import cn.edu.zucc.takeaway.util.DbException;

public class riderManager implements IriderManager{

	public List<Beanrider> loadAll()throws BaseException {
		List<Beanrider> result=new ArrayList<Beanrider>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select rider_id,rider_name,rider_workdate,rider_identity"
					+ " from rider";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			//pst.setString(1, Beanmerchant.currentLoginUser);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Beanrider rider = new Beanrider();
				rider.setRider_id(rs.getString(1));
				rider.setRider_name(rs.getString(2));
				rider.setRider_workdate(rs.getDate(3));
				rider.setRider_identity(rs.getString(4));
				result.add(rider);
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
	public void removerider(String rider_id)throws BaseException {
		// TODO Auto-generated method stub
		if("".equals(rider_id) ){throw new BusinessException("骑手为空");}
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from rider where rider_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, rider_id);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("骑手不存在");
			sql="delete from rider where rider_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, rider_id);
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
	
public  void createrider(Beanrider rider) throws BaseException{
		
		
		if( "".equals(rider.getRider_id()) || "".equals(rider.getRider_name())){
			throw new BusinessException("商家编号，姓名不能为空");
		}
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from rider where rider_name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,rider.getRider_name());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("骑手已存在");
			rs.close();
			pst.close();
			sql="insert into rider(rider_id,rider_name,rider_workdate,rider_identity) "
					+ "values(?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, rider.getRider_id());
			pst.setString(2, rider.getRider_name());
			pst.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
			pst.setString(4, rider.getRider_identity());
			
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

public List<Beanrider> searchrider(String text) {
	// TODO Auto-generated method stub
	List<Beanrider> result=new ArrayList<Beanrider>();
	Connection conn=null;
	try {
		conn=DBUtil.getConnection();
		String sql="select rider_id,rider_name,rider_workdate,rider_identity" + 
				" from rider where rider_name=?";
		java.sql.PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1,text);
		java.sql.ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			Beanrider rider = new Beanrider();
			rider.setRider_id(rs.getString(1));
			rider.setRider_name(rs.getString(2));
			rider.setRider_workdate(rs.getDate(3));
			rider.setRider_identity(rs.getString(4));
			result.add(rider);
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
