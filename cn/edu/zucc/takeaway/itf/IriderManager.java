package cn.edu.zucc.takeaway.itf;

import java.util.List;

import cn.edu.zucc.takeaway.model.Beanrider;
import cn.edu.zucc.takeaway.model.Beanrider_wage;
import cn.edu.zucc.takeaway.util.BaseException;

public interface IriderManager {
	public List<Beanrider> searchrider(String text);
	public  void createrider(Beanrider rider) throws BaseException;
	public void removerider(String rider_id)throws BaseException;
	public List<Beanrider> loadAll()throws BaseException ;
	public List<Beanrider_wage> listwage()throws BaseException ;
}
