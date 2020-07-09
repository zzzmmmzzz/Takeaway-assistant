package cn.edu.zucc.takeaway.itf;

import java.util.List;

import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.util.BaseException;

public interface IMerchantManager {
	public List<Beanmerchant> searchuser(String text);
	public List<Beanmerchant> loadAll() throws BaseException ;
	public void removeMerchant(String merchant_id, String clerk_id)throws BaseException;	 public  void createMerchant(Beanmerchant mc) throws BaseException;
	;
}
