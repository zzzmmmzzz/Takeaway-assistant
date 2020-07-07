package cn.edu.zucc.takeaway;

import cn.edu.zucc.takeaway.control.customerManager;
import cn.edu.zucc.takeaway.control.MerchantManager;
import cn.edu.zucc.takeaway.control.riderManager;
import cn.edu.zucc.takeaway.control.userManager;
import cn.edu.zucc.takeaway.itf.*;


public class takeawayUtil {
	public static IcustomerManager customerManager=(IcustomerManager) new customerManager();//需要换成自行设计的实现类
	public static IMerchantManager MerchantManager=(IMerchantManager) new MerchantManager();//需要换成自行设计的实现类
	public static IriderManager riderManager=(IriderManager) new riderManager();
	public static IuserManager userManager=(IuserManager) new userManager();//需要换成自行设计的实现类
	
}
