package cn.edu.zucc.takeaway.itf;

import java.util.List;

import cn.edu.zucc.takeaway.model.Beangoods_details;
import cn.edu.zucc.takeaway.util.BaseException;

public interface IgoodsManager {
	public List<Beangoods_details> loadAll() throws BaseException;
}
