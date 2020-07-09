package cn.edu.zucc.takeaway.ui;

	import java.awt.BorderLayout;
	import java.awt.FlowLayout;
	import java.awt.Frame;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.awt.event.WindowAdapter;
	import java.awt.event.WindowEvent;
	import java.io.IOException;
	import java.util.List;

	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.takeawayUtil;
	import cn.edu.zucc.takeaway.control.userManager;
	import cn.edu.zucc.takeaway.model.*;

	import cn.edu.zucc.takeaway.util.BaseException;



	public class Frmmainuser extends JFrame implements ActionListener {
		private static final long serialVersionUID = 1L;
		private JMenuBar menubar=new JMenuBar(); 
		private JMenu menu_cus=new JMenu("用户管理");
		private JMenu menu_rider=new JMenu("骑手管理");
		private JMenu menu_Merchant=new JMenu("商家管理");
		private JMenu menu_user=new JMenu("管理员管理");
		
		private JMenuItem menuItem_cuslist=new JMenuItem("用户信息查询");
		
		private JMenuItem menuItem_riderlist=new JMenuItem("骑手信息查询");
		private JMenuItem menuItem_riderwage=new JMenuItem("骑手收入查询");
		private JMenuItem menuItem_rideradd=new JMenuItem("增加骑手");
		private JMenuItem menuItem_riderdelete=new JMenuItem("删除骑手");
		
		private JMenuItem menuItem_Merchantlist=new JMenuItem("商家信息查询");
		private JMenuItem menuItem_Merchantadd=new JMenuItem("增加商家");
		private JMenuItem menuItem_goodsManager=new JMenuItem("商品管理");
		
		private JMenuItem menuItem_userlist=new JMenuItem("管理员信息查询");
		private JMenuItem menuItem_userManager=new JMenuItem("密码修改");
	    
	    
		private FrmLogin dlgLogin=null;
		private JPanel statusBar = new JPanel();
		

		public Frmmainuser()throws IOException{
			
			this.setExtendedState(Frame.MAXIMIZED_BOTH);
			this.setTitle("外卖管理员助手");
			//this.add(comp)
		    //菜单
			menu_cus.add(menuItem_cuslist);
			menuItem_cuslist.addActionListener(this);
			menubar.add(menu_cus);
			
			
			menu_rider.add(menuItem_riderlist);
			menuItem_riderlist.addActionListener(this);
			menu_rider.add(menuItem_riderwage);
			menuItem_riderwage.addActionListener(this);
			menubar.add(menu_rider);
			
			menu_Merchant.add(menuItem_Merchantlist);
			menuItem_Merchantlist.addActionListener(this);
			menu_Merchant.add(menuItem_Merchantadd);
			menuItem_Merchantadd.addActionListener(this);
			menu_Merchant.add(menuItem_goodsManager);
			menuItem_goodsManager.addActionListener(this);
			menubar.add(menu_Merchant);
			
			menu_user.add(menuItem_userlist);
			menuItem_userlist.addActionListener(this);
			menu_user.add(menuItem_userManager);
			menuItem_userManager.addActionListener(this);
			menubar.add(menu_user);
			this.setJMenuBar(menubar);
			
		    //状态栏
		    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		    JLabel label=new JLabel("您好!");//修改成   您好！+登陆用户名
		    statusBar.add(label);
		    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
		    this.addWindowListener(new WindowAdapter(){   
		    	public void windowClosing(WindowEvent e){ 
		    		System.exit(0);
	             }
	        });
		    this.setVisible(true);
		

		
		}
		public void actionPerformed(ActionEvent e) {
			/*if (e.getSource() == this.btnLogin) {
				String userid=this.edtUserId.getText();
				String pwd=new String(this.edtPwd.getPassword());
				try {
					BeanUser.currentLoginUser= PersonPlanUtil.userManager.login(userid, pwd);
				} catch (BaseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
				this.setVisible(false);
				
			} else if (e.getSource() == this.btnCancel) {
				System.exit(0);
			} else if(e.getSource()==this.btnRegister){
				FrmRegister dlg=new FrmRegister(this,"注册",true);
				dlg.setVisible(true);
			}*/
			if(e.getSource()==this.menuItem_Merchantadd) {
					FrmUMadd UMadd=new FrmUMadd(this,"添加商户",true);
					UMadd.setVisible(true);
					
				
			}
			else if(e.getSource()==this.menuItem_Merchantlist) {
				FrmUMerchantManager fum= new FrmUMerchantManager(this,"商家管理",true);
				fum.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_goodsManager) {
				FrmUgoodManager gd=new FrmUgoodManager();
				gd.setVisible(true);
			}
			else if(e.getSource()==this.menuItem_cuslist) {
				FrmUcuslist list=new FrmUcuslist(this,"用户管理i",true);
				list.setVisible(true);
			}
		}

		

}

