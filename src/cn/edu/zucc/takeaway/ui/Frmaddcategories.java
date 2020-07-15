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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.util.BaseException;

public class Frmaddcategories extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelName = new JLabel("商家编号：");
	private JTextField edtName = new JTextField(20);
	private JLabel labelcateid = new JLabel("类别编号：");
	private JTextField edtcateid = new JTextField(20);
	private JLabel labelcatename = new JLabel("类别名称：");
	private JTextField edtcatename = new JTextField(20);
	private JLabel labelgoodcnt = new JLabel("商品数量：");
	private JTextField edtgoodcnt = new JTextField(20);
	
	public Frmaddcategories(JFrame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelName);
		workPane.add(edtName);
		workPane.add(labelcateid);
		workPane.add(edtcateid);
		workPane.add(labelcatename);
		workPane.add(edtcatename);
		workPane.add(labelgoodcnt);
		workPane.add(edtgoodcnt);
		this.getContentPane().add(workPane, BorderLayout.CENTER);
		this.setSize(320, 220);
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
			String name=this.edtName.getText();
			String cateid =this.edtcateid.getText();
			String catename=this.edtcatename.getText();
			String cnt=this.edtgoodcnt.getText();
			try {
				takeawayUtil.goodsManager.addcate(name,cateid,catename,cnt);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
}
