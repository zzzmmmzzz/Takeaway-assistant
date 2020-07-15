package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.model.Beanuser;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmRegister extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel workPane = new JPanel();
	private Button btnOk = new Button("ע��");
	private Button btnCancel = new Button("ȡ��");
	
	private JLabel labelUser = new JLabel("�û���ţ�");
	private JLabel labelName = new JLabel("�û�������");
	private JLabel labelPwd = new JLabel("���룺");
	private JLabel labelPwd2 = new JLabel("ȷ�����룺");
	private JLabel labelsex = new JLabel("�Ա�");
	private JLabel labelPhone = new JLabel("�ֻ�����");
	private JLabel labelEmail = new JLabel("����");
	private JLabel labelCity = new JLabel("���ڳ���");
	private JLabel labelVip = new JLabel("�Ƿ�����Ա");
	private JRadioButton man = new JRadioButton("��");
	private JRadioButton woman = new JRadioButton("Ů");
	private JRadioButton yes = new JRadioButton("��");
	private JRadioButton no = new JRadioButton("��");
	private JLabel kong = new JLabel("                            ");
	private JTextField edtUserId = new JTextField(20);
	private JTextField edtName = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);
	private JPasswordField edtPwd2 = new JPasswordField(20);
	private JTextField edtPhone = new JTextField(20);
	private JTextField edtEmail = new JTextField(20);
	private JTextField edtCity = new JTextField(20);
	public FrmRegister(Dialog f, String s, boolean b) {
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolBar.add(this.btnOk);
		toolBar.add(btnCancel);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		workPane.add(labelUser);
		workPane.add(edtUserId);
		workPane.add(labelName);
		workPane.add(edtName);
		workPane.add(labelPwd);
		workPane.add(edtPwd);
		workPane.add(labelPwd2);
		workPane.add(edtPwd2);
		workPane.add(labelsex);
		ButtonGroup group = new ButtonGroup();
		group.add(man);
		group.add(woman);
		workPane.add(this.man);
		workPane.add(this.woman);
		workPane.add(kong);
		workPane.add(labelPhone);
		workPane.add(edtPhone);
		workPane.add(labelEmail);
		workPane.add(edtEmail);
		workPane.add(labelCity);
		workPane.add(edtCity);
		workPane.add(labelVip);
		ButtonGroup group1 = new ButtonGroup();
		group.add(yes);
		group.add(no);
		workPane.add(this.yes);
		workPane.add(this.no);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnCancel)
			this.setVisible(false);
		else if(e.getSource()==this.btnOk){
			/*String userid=this.edtUserId.getText();
			String pwd1=new String(this.edtPwd.getPassword());
			String pwd2=new String(this.edtPwd2.getPassword());
			try {
				Beanuser user=takeawayUtil.userManager.reg(userid,pwd1,pwd2);
				this.setVisible(false);
			} catch (BaseException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
				return;
			}*/
			
		}
			
		
	}


}
