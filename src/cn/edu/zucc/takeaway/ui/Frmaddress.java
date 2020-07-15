package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.model.Beanaddress;
import cn.edu.zucc.takeaway.model.Beancus;
import cn.edu.zucc.takeaway.util.BaseException;

public class Frmaddress extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("修改");
	private Button btnCancel = new Button("取消");
	private Beanaddress add=null;
	
	private JLabel labeladdress = new JLabel("用户地址：");
	private JTextField edtaddress = new JTextField(20);
	
	public Frmaddress(Frame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labeladdress);
		this.edtaddress.setText(add.getAddress());
		workPane.add(edtaddress);
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
				Beanaddress add=new Beanaddress();
				add=takeawayUtil.customerManager.getAddress((Beancus) Beancus.currentloginUser);
				Frmaddmodify address=new Frmaddmodify(this,"地址管理",true,add);
				this.setVisible(true);
			}catch(BaseException ex) {
				
			}
		}
	}
}
