package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.model.Beancus;
import cn.edu.zucc.takeaway.model.Beanuser;
import cn.edu.zucc.takeaway.util.BaseException;


public class FrmLogin extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private JPanel toolImg = new JPanel();
	private JPanel workPane = new JPanel();
	private JButton btnLogin = new JButton("�û���½");
	//private JButton btnCancel = new JButton("�˳�");
	private JButton btnRegister = new JButton("�û�ע��");
	private JButton btnuser = new JButton("����Ա��¼");
	BufferedImage imge=ImageIO.read(new File("./imgs/timg.jpg"));
    private JLabel img= new JLabel(new ImageIcon(imge));
	
	private JLabel labelUser = new JLabel("�û�����");
	private JLabel labelPwd = new JLabel("���룺");
	private JTextField edtUserId = new JTextField(20);
	private JPasswordField edtPwd = new JPasswordField(20);

	public FrmLogin(Frame f, String s, boolean b) throws IOException{
		super(f, s, b);
		toolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
		toolImg.add(img);
		this.getContentPane().add(toolImg, BorderLayout.NORTH);
		toolBar.setLayout(new FlowLayout(FlowLayout.CENTER));
		toolBar.add(this.btnRegister);
		toolBar.add(btnLogin);
		toolBar.add(btnuser);
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		//workPane.add(labelUser);
	//	workPane.add(edtUserId);
	//	workPane.add(labelPwd);
	//	workPane.add(edtPwd);
	//	this.getContentPane().add(workPane, BorderLayout.SOUTH);
		this.setSize(660, 655);
		/*BufferedImage img=null;
		try {
			img=ImageIO.read(new File("./imgs/timg.jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		getContentPane().setLayout(null);
		//����ͼƬ
		JLabel label=new JLabel(new ImageIcon(img));
		getContentPane().setLayout(null);*/
		//����ͼƬ
		//label.setBounds(0, 0, img.getWidth(), img.getHeight());
		
		
		// ��Ļ������ʾ
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();

		btnLogin.addActionListener(this);
		btnuser.addActionListener(this);
		btnRegister.addActionListener(this);
		//btnCancel.addActionListener(this);
		this.btnRegister.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnLogin) {
			Frmcus dlg=new Frmcus(this,"�û���¼",true);
			dlg.setVisible(true);
			if(Beancus.currentloginUser!=null) {
				this.setVisible(false);
				try {
					new Frmmaincus();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		} else if (e.getSource() == this.btnuser) {
			FrmUser dlg=new FrmUser(this,"����Ա��¼",true);
			dlg.setVisible(true);
			if(Beanuser.currentLoginUser!=null) {
				this.setVisible(false);
				try {
					new Frmmainuser();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(),"����",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
		}  else if (e.getSource()==this.btnRegister){
			FrmRegister dlg=new FrmRegister(this,"ע��",true);
			dlg.setVisible(true);
		}
		
	}

}


