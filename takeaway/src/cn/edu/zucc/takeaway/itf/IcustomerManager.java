package cn.edu.zucc.takeaway.itf;

import java.util.List;

import cn.edu.zucc.takeaway.model.Beancus;
import cn.edu.zucc.takeaway.model.Beanuser;
import cn.edu.zucc.takeaway.util.BaseException;

public interface IcustomerManager {

	public Beancus login(String clerkid,String pwd)throws BaseException;
	
	public Beancus reg(String clerkname,String pwd,String pwd2) throws BaseException;
	
	public void changePwd(Beanuser user, String oldPwd,String newPwd, String newPwd2)throws BaseException;
	public List<Beancus> loadAll() throws BaseException;
	public List<Beancus> searchuser(String text);
}
