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

public class Frmaddgoods extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("确定");
	private Button btnCancel = new Button("取消");
	private JLabel labelgoodid = new JLabel("商品编号：");
	private JTextField edtgoodid = new JTextField(20);
	private JLabel labelcateid = new JLabel("商品类别编号：");
	private JTextField edtcateid = new JTextField(20);
	private JLabel labelgoodname = new JLabel("商品名称：");
	private JTextField edtgoodname = new JTextField(20);
	private JLabel labelgoodprice = new JLabel("商品定价：");
	private JTextField edtgoodprice = new JTextField(20);
	private JLabel labelgoodreduce = new JLabel("商品优惠：");
	private JTextField edtgoodreduce = new JTextField(20);
	
	public Frmaddgoods(JFrame f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelgoodid);
		workPane.add(edtgoodid);
		workPane.add(labelcateid);
		workPane.add(edtcateid);
		workPane.add(labelgoodname);
		workPane.add(edtgoodname);
		workPane.add(labelgoodprice);
		workPane.add(edtgoodprice);
		workPane.add(labelgoodreduce);
		workPane.add(edtgoodreduce);
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
			String goodid=this.edtgoodid.getText();
			String cateid=this.edtcateid.getText();
			String goodname=this.edtgoodname.getText();
			String price=this.edtgoodprice.getText();
			String reduce=this.edtgoodreduce.getText();
			try {
				takeawayUtil.goodsManager.creatgoods(goodid,cateid,goodname,price,reduce);
				this.setVisible(false);
			}catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "错误",JOptionPane.ERROR_MESSAGE);
				return;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
}
}
