package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.model.Beanuser;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmUMadd extends JDialog implements ActionListener{
	Beanmerchant mc=new Beanmerchant();
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("注册");
	private Button btnCancel = new Button("取消");
	private JComboBox jcb=null;
	
	private JLabel labelMerchantid = new JLabel("商家编号：");
	private JLabel labelMerchantName = new JLabel("商家名：");
	private JLabel labelMerchantStar = new JLabel("商家星级：");
	private JLabel labelMerchantAvg = new JLabel("人均消费：");
	private JLabel labelMerchantall = new JLabel("总销量：");
	
	private JTextField edtMerchantid = new JTextField(20);
	private JTextField edtMerchantName = new JTextField(20);
	private JTextField edtMerchantStar = new JTextField(20);
	private JTextField edtMerchantAvg = new JTextField(20);
	private JTextField edtMerchantall = new JTextField(20);
	
	public FrmUMadd(JDialog f, String s, boolean b) {  //添加商家
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelMerchantid);
		workPane.add(edtMerchantid);
		workPane.add(labelMerchantName);
		workPane.add(edtMerchantName);
		workPane.add(labelMerchantStar);
		workPane.add(edtMerchantStar);
		workPane.add(labelMerchantAvg);
		workPane.add(edtMerchantAvg);
		workPane.add(labelMerchantall);
		workPane.add(edtMerchantall);
		mc.setMerchant_id(edtMerchantid.getText());
		mc.setMerchant_name(edtMerchantName.getText());
		mc.setMerchant_star(Integer.parseInt(edtMerchantStar.getText()));
		mc.setMerchant_avgc(Float.parseFloat(edtMerchantAvg.getText()));
		mc.setMerchant_total(Float.parseFloat(edtMerchantall.getText()));
		
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(260, 500);
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
				//String merchant_id=this.edtMerchantid.getText();
			
				takeawayUtil.MerchantManager.createMerchant(mc);
				this.setVisible(true);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			}
			}
			
		}
			
		
	
}
