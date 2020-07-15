package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.model.Beanaddress;
import cn.edu.zucc.takeaway.model.Beancus;
import cn.edu.zucc.takeaway.model.Beangoods_details;
import cn.edu.zucc.takeaway.model.Beanshop;
import cn.edu.zucc.takeaway.util.BaseException;

public class Frmpay extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("结算");
	private Button btnCancel = new Button("取消");
	
	private JLabel labelpay = new JLabel("总额：");
	private JTextField edtpay = new JTextField(20);
	private JLabel labelreduce = new JLabel("优惠金额：");
	private JTextField edtreduce = new JTextField(20);
	private JLabel labelprice = new JLabel("实际支付：");
	private JTextField edtprice = new JTextField(20);
	
	float sum=0,discount=0,pay=0;
	public Frmpay(JDialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelpay);
		List<Beanshop> shop = takeawayUtil.goodsManager.listshop();
		for(int i=0;i<shop.size();i++) {
			sum=sum+shop.get(i).getGoods_price();
			if(shop.get(i).getGoods_amount()==1) {
				discount=discount+shop.get(i).getGoods_reduce();
			}
		}
		edtpay.setText(String.valueOf(sum));
		edtreduce.setText(String.valueOf(discount));
		edtprice.setText(String.valueOf(sum-discount));
		
		workPane.add(edtpay);
		workPane.add(labelreduce);
		workPane.add(edtreduce);
		workPane.add(labelprice);
		workPane.add(edtprice);
		
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(260, 300);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		
		this.btnCancel.addActionListener(this);
		this.btnOk.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			try {
//				if(e.getSource()==this.menuItem_Addgoodcategories) {
//					Frmshopping add=new Frmshopping(this, "购物车", true);
//					 add.setVisible(true);
//				}
//				else if(e.getSource()==this.btnAdd) {
//					int i=this.dataTableStep.getSelectedRow();
//					if(i<0) {
//						JOptionPane.showMessageDialog(null,  "请选择商家","提示",JOptionPane.ERROR_MESSAGE);
//						return;
//					}
//					try {
//						Beangoods_details p=goods.get(i);
//						takeawayUtil.goodsManager.addgoods(p);
//					}catch (Exception e1) {
//						JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
//					}
//				}
				takeawayUtil.goodsManager.delshop();
				this.setVisible(false);
			}catch(Exception ex) {
				
			}
		}
}
}
