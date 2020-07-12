package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
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
import cn.edu.zucc.takeaway.model.Beangoods_categories;
import cn.edu.zucc.takeaway.model.Beangoods_details;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.util.BaseException;

public class Frmorders extends JDialog implements ActionListener {
private JMenuBar menubar=new JMenuBar();
	
	private JMenu menu_goodManager=new JMenu("订单管理");
	private JMenu menu_goodcategoriesManager=new JMenu("下单");
	
	private JMenuItem  menuItem_Addgoodcategories=new JMenuItem("添加商品类别");
	private JMenuItem  menuItem_deletegoodcategories=new JMenuItem("删除商品类别");
	private JMenuItem  menuItem_Addgoods=new JMenuItem("添加商品");
	private JMenuItem  menuItem_deletegoods=new JMenuItem("删除商品");
	
	//private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	
	private Object tblMerchantTitle[]=Beanmerchant.tableTitles;
	private Object tblMerchantData[][];
	DefaultTableModel tabPlanModel=new DefaultTableModel();
	private JTable dataTablePlan=new JTable(tabPlanModel);
	
	private Object tblgoodscategoriesTitle[]=Beangoods_categories.tableTitles;
	private Object tblgoodscategoriesData[][];
	DefaultTableModel tabgoodscategoriesModel=new DefaultTableModel();
	private JTable dataTablegoodscategories=new JTable(tabgoodscategoriesModel);
	
	private Object tblgoodsTitle[]=Beangoods_details.tableTitles;
	private Object tblgoodsData[][];
	DefaultTableModel tabStepModel=new DefaultTableModel();
	private JTable dataTableStep=new JTable(tabStepModel);
	
	
	
	private Beanmerchant mc=null;
	List<Beanmerchant> allmerchant=null;
	List<Beangoods_categories> categories=null;
	private Beangoods_categories gc =null;
	List<Beangoods_details> goods=null;
	
	
	private void reloadPlanTable(){//这是测试数据，需要用实际数替换
		try {
			allmerchant=takeawayUtil.MerchantManager.loadAll();
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblMerchantData =  new Object[allmerchant.size()][Beanmerchant.tableTitles.length];
		for(int i=0;i<allmerchant.size();i++){
			for(int j=0;j<Beanmerchant.tableTitles.length;j++)
				tblMerchantData[i][j]=allmerchant.get(i).getCell(j);
		}
		tabPlanModel.setDataVector(tblMerchantData,tblMerchantTitle);
		this.dataTablePlan.validate();
		this.dataTablePlan.repaint();	
}
	private void reloadgoods_categories(int p) {
		if(p<0) return;
		mc=allmerchant.get(p);
		try {
			categories=takeawayUtil.goodsManager.loadAllcategories(mc);
		}catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblgoodscategoriesData =  new Object[categories.size()][Beangoods_categories.tableTitles.length];
		for(int i=0;i<categories.size();i++){
			for(int j=0;j<Beangoods_categories.tableTitles.length;j++)
				tblgoodscategoriesData[i][j]=categories.get(i).getCell(j);
		}
		tabgoodscategoriesModel.setDataVector(tblgoodscategoriesData,tblgoodscategoriesTitle);
		this.dataTablegoodscategories.validate();
		this.dataTablegoodscategories.repaint();	
	}
	private void reloadPlanStepTabel(int planIdx){
		if(planIdx<0) return;
		gc=categories.get(planIdx);
		goods=takeawayUtil.goodsManager.loadAll(gc);
		tblgoodsData =new Object[goods.size()][Beangoods_details.tableTitles.length];
		for(int i=0;i<goods.size();i++){
			for(int j=0;j<Beangoods_details.tableTitles.length;j++)
				tblgoodsData[i][j]=goods.get(i).getCell(j);
		}
		
		tabStepModel.setDataVector(tblgoodsData,tblgoodsTitle);
		this.dataTableStep.validate();
		this.dataTableStep.repaint();
		
	}
	
	public Frmorders(){

		
		this.setTitle("商品管理");
		
		menu_goodManager.add(menuItem_Addgoods);
		menuItem_Addgoods.addActionListener(this);
		menu_goodManager.add(menuItem_deletegoods);
		menuItem_deletegoods.addActionListener(this);
		menubar.add(menu_goodManager);
		
		menu_goodcategoriesManager.add(menuItem_Addgoodcategories);
		menuItem_Addgoodcategories.addActionListener(this);
		menu_goodcategoriesManager.add(menuItem_deletegoodcategories);
		menuItem_deletegoodcategories.addActionListener(this);
		menubar.add(menu_goodcategoriesManager);
		
		this.setJMenuBar(menubar);
		
		this.getContentPane().add(new JScrollPane(this.dataTablePlan), BorderLayout.WEST);
		this.dataTablePlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmorders.this.dataTablePlan.getSelectedRow();
				if(i<0) {
					return;
				}
				Frmorders.this.reloadgoods_categories(i);
			}
	    	
	    });
		this.getContentPane().add(new JScrollPane(this.dataTablegoodscategories), BorderLayout.CENTER);
		this.dataTablegoodscategories.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmorders.this.dataTablegoodscategories.getSelectedRow();
				if(i<0) {
					return;
				}
				Frmorders.this.reloadPlanStepTabel(i);
			}
	    	
	    });
	    this.getContentPane().add(new JScrollPane(this.dataTableStep), BorderLayout.EAST);
	    
	   this.reloadPlanTable();
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
	    
	    this.setSize(1500, 800);
		
	}


	
	public void actionPerformed(ActionEvent e) {
		/*if(e.getSource()==this.menuItem_Addgoodcategories) {
			Frmaddcategories add=new Frmaddcategories(this, "添加类别", true);
			 add.setVisible(true);
		}
		if(e.getSource()==this.menuItem_Addgoods) {
			Frmaddgoods add=new Frmaddgoods(this,"添加商品",true);
			add.setVisible(true);
		}*/
	}
	
	
}
