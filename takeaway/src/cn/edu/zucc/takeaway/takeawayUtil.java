package cn.edu.zucc.takeaway;

import cn.edu.zucc.takeaway.control.customerManager;
import cn.edu.zucc.takeaway.control.MerchantManager;
import cn.edu.zucc.takeaway.control.riderManager;
import cn.edu.zucc.takeaway.control.userManager;
import cn.edu.zucc.takeaway.itf.*;


public class takeawayUtil {
	public static IcustomerManager customerManager=(IcustomerManager) new customerManager();//��Ҫ����������Ƶ�ʵ����
	public static IMerchantManager MerchantManager=(IMerchantManager) new MerchantManager();//��Ҫ����������Ƶ�ʵ����
	public static IriderManager riderManager=(IriderManager) new riderManager();
	public static IuserManager userManager=(IuserManager) new userManager();//��Ҫ����������Ƶ�ʵ����
	
}
