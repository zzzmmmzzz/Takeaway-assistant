package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmUaddrider extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelriderid = new JLabel("骑手编号：");
	private JTextField edtriderid = new JTextField(20);
	private JLabel labelridername = new JLabel("骑手姓名：");
	private JTextField edtridername = new JTextField(20);
	private JLabel labelrideridentity = new JLabel("骑手身份：");
	private JTextField edtrideridentity = new JTextField(20);
	
	public FrmUaddrider(JDialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelriderid);
		workPane.add(edtriderid);
		workPane.add(labelridername);
		workPane.add(edtridername);
		workPane.add(labelrideridentity);
		workPane.add(edtrideridentity);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(300, 350);
		// 屏幕居中显示
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		this.btnOk.addActionListener(this);
		this.btnCancel.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel) {
			this.setVisible(false);
			return;
		}
		else if(e.getSource()==this.btnOk){
			
		}
	}
		
}
