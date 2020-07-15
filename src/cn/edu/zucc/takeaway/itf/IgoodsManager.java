package cn.edu.zucc.takeaway.itf;

import java.util.List;

import cn.edu.zucc.takeaway.model.Beangoods_categories;
import cn.edu.zucc.takeaway.model.Beangoods_details;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.model.Beanorder_detail;
import cn.edu.zucc.takeaway.model.Beanorders;
import cn.edu.zucc.takeaway.model.Beanshop;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;

public interface IgoodsManager {
	//public List<Beangoods_details> loadAll() throws BaseException;
	public List<Beangoods_categories> loadAllcategories() throws BaseException ;
	public void addcate(String name, String cateid, String catename, String cnt) throws Exception;
	public List<Beangoods_categories> loadAllcategories(Beanmerchant mc) throws BaseException;
	public List<Beangoods_details> loadAll(Beangoods_categories gc);
	public void creatgoods(String goodid, String cateid, String goodname, String price, String reduce) throws Exception;
	public List<Beanshop> addgoods(Beangoods_details de);
	public List<Beanshop> listshop();
	public List<Beanshop> pay();
	public void delshop();
	public List<Beanorders> loadAllord() throws BaseException;
	public List<Beanorder_detail> loaddetail(Beanorders curPlan) throws BaseException;
}
