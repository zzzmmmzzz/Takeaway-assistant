package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.model.Beanorder_detail;
import cn.edu.zucc.takeaway.model.Beanorders;
import cn.edu.zucc.takeaway.util.BaseException;





public class Frmord extends JDialog implements ActionListener{
	private JMenuBar menubar=new JMenuBar();
private JPanel statusBar = new JPanel();
	
	private Object tblPlanTitle[]= {"骑手编号","顾客编号","下单时间","地址编号"};
	private Object tblPlanData[][];
	DefaultTableModel tabPlanModel=new DefaultTableModel();
	private JTable dataTablePlan=new JTable(tabPlanModel);
	
	
	private Object tblStepTitle[]= {"商品编号","数量","总价格","优惠价格"};
	private Object tblStepData[][];
	DefaultTableModel tabStepModel=new DefaultTableModel();
	private JTable dataTableStep=new JTable(tabStepModel);
	
	private Beanorders curPlan=null;
	List<Beanorders> allPlan=null;
	List<Beanorder_detail> planSteps=null;
	private void reloadPlanTable(){//这是测试数据，需要用实际数替换
		try {
			allPlan=takeawayUtil.goodsManager.loadAllord();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblPlanData =  new Object[allPlan.size()][4];
		for(int i=0;i<allPlan.size();i++){
			for(int j=0;j<4;j++)
				tblPlanData[i][j]=allPlan.get(i).getCell(j);
		}
		tabPlanModel.setDataVector(tblPlanData,tblPlanTitle);
		this.dataTablePlan.validate();
		this.dataTablePlan.repaint();
	}
	private void reloadPlanStepTabel(int planIdx){
		if(planIdx<0) return;
		curPlan=allPlan.get(planIdx);
		try {
		planSteps=takeawayUtil.goodsManager.loaddetail(curPlan);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblStepData =new Object[planSteps.size()][4];
		for(int i=0;i<planSteps.size();i++){
			for(int j=0;j<tblStepTitle.length;j++)
				tblStepData[i][j]=planSteps.get(i).getCell(j);
		}
		
		tabStepModel.setDataVector(tblStepData,tblStepTitle);
		this.dataTableStep.validate();
		this.dataTableStep.repaint();
	}
	public Frmord(JDialog f,String s,boolean b) {
		super(f,s,b);
		this.setSize(800, 500);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		this.getContentPane().add(new JScrollPane(this.dataTablePlan), BorderLayout.WEST);
		this.reloadPlanTable();
		this.dataTablePlan.addMouseListener(new MouseAdapter (){

			@Override
			public void mouseClicked(MouseEvent e) {
				int i=Frmord.this.dataTablePlan.getSelectedRow();
				if(i<0) {
					return;
				}
				Frmord.this.reloadPlanStepTabel(i);
			}
	    	
	    });
		this.getContentPane().add(new JScrollPane(this.dataTableStep), BorderLayout.EAST);
		//this.getContentPane().add(new JScrollPane(this.dataTablegoodscategories), BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
