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



public class Frmmaincus extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar=new JMenuBar(); 
	private JMenu menu_cus=new JMenu("我的账号");
	private JMenu menu_order=new JMenu("订单管理");
	//private JMenu menu_Merchant=new JMenu("商家管理");
	//private JMenu menu_user=new JMenu("管理员管理");
	
	private JMenuItem menuItem_cuslist=new JMenuItem("用户信息查询");
	private JMenuItem menuItem_address=new JMenuItem("配送地址查询");
	private JMenuItem menuItem_coupons=new JMenuItem("优惠券查询");
		
	private JMenuItem menuItem_Merchantlist=new JMenuItem("订单管理");

	
	
    
    
	private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	

	public Frmmaincus()throws IOException{
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("外卖助手");

		//this.add(comp)
	    //菜单
		menu_cus.add(menuItem_cuslist);
		menuItem_cuslist.addActionListener(this);
		menu_cus.add(menuItem_address);
		menuItem_address.addActionListener(this);
		menu_cus.add(menuItem_coupons);
		menuItem_coupons.addActionListener(this);
		menubar.add(menu_cus);
		
		menu_order.add(menuItem_Merchantlist);
		menuItem_Merchantlist.addActionListener(this);
		menubar.add(menu_order);
		
		this.setJMenuBar(menubar);
		
	    //状态栏
	    statusBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel label=new JLabel("您好!");//修改成   您好！+登陆用户名
	    statusBar.add(label);
	    this.getContentPane().add(statusBar,BorderLayout.SOUTH);
	    this.addWindowListener(new WindowAdapter(){   
	    	public void windowClosing(WindowEvent e){ 
	    		//System.exit(0);
             }
        });
	    this.setVisible(true);
	

	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.menuItem_address) {
			Frmaddress add= new Frmaddress(this,"地址管理",true);
			add.setVisible(true);
		}
		if(e.getSource()==this.menuItem_Merchantlist) {
			Frmorders ord=new Frmorders();
			ord.setVisible(true);
		}
		if(e.getSource()==this.menuItem_cuslist) {
			FrmCcuslist list=new FrmCcuslist(this,"我的账号",true);
			list.setVisible(true);
		}
	}
 


}

