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
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.control.MerchantManager;
import cn.edu.zucc.takeaway.control.customerManager;
import cn.edu.zucc.takeaway.model.Beancus;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.model.Beanrider;
import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.util.BusinessException;

public class FrmUcuslist extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	//private Button btnAdd = new Button("添加新商家");
	//private Button btnModify = new Button("修改商家");
	//private Button btnDelete = new Button("注销商家");

	
    private JComboBox cmbReadertype=null;
	
	private JTextField edtKeyword = new JTextField(10);
	private Button btnSearch = new Button("查询");
	
	private Object tblTitle[]={"用户编号","用户名","用户性别","密码","电话","邮箱","城市","注册时间","是否会员"};
	private Object tblData[][];
	List<Beancus> cus=null;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable MerchantTable=new JTable(tablmod);
	private void reloadTable(){
		try {
			int n=this.cmbReadertype.getSelectedIndex();
			int rtId=0;
			cus=(new customerManager()).loadAll();
			//merchant=(new MerchantManager()).searchReader(this.edtKeyword.getText(), rtId);
			tblData =new Object[cus.size()][9];
			for(int i=0;i<cus.size();i++){
				tblData[i][0]=cus.get(i).getCus_id();
				tblData[i][1]=cus.get(i).getCus_name();	
				tblData[i][2]=cus.get(i).getCus_sex();
				tblData[i][3]=cus.get(i).getCus_password();
				tblData[i][4]=cus.get(i).getCus_tel();
				tblData[i][5]=cus.get(i).getCus_email();
				tblData[i][6]=cus.get(i).getCus_city();
				tblData[i][7]=cus.get(i).getCus_regtime();
				tblData[i][8]=cus.get(i).getCus_vip();
				tablmod.setDataVector(tblData,tblTitle);
				this.MerchantTable.validate();
				this.MerchantTable.repaint();
			}		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void loadTable() throws BaseException{
		List<Beancus> cus=null;
		String s=this.edtKeyword.getText().trim();
		if(!"".equals(s)) {
			try {
				cus=takeawayUtil.customerManager.searchuser(this.edtKeyword.getText());
				if(cus==null) throw new BusinessException("查询无结束");
				tblData =new Object[1][9];
				tblData[0][0]=cus.get(0).getCus_id();
				tblData[0][1]=cus.get(0).getCus_name();	
				tblData[0][2]=cus.get(0).getCus_sex();
				tblData[0][3]=cus.get(0).getCus_password();
				tblData[0][4]=cus.get(0).getCus_tel();
				tblData[0][5]=cus.get(0).getCus_email();
				tblData[0][6]=cus.get(0).getCus_city();
				tblData[0][7]=cus.get(0).getCus_regtime();
				tblData[0][8]=cus.get(0).getCus_vip();
				tablmod.setDataVector(tblData,tblTitle);
				this.MerchantTable.validate();
				this.MerchantTable.repaint();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public FrmUcuslist(Frame f, String s, boolean b) {
		super(f, s, b);
		
		List<Beancus> cus =null;
		try {
			cus=(new customerManager()).loadAll();
			String[] strTypes=new String[cus.size()+1];
			strTypes[0]="";
			for(int i=0;i<cus.size();i++) {
				strTypes[i+1]=cus.get(i).getCus_id();
			}
			cmbReadertype=new JComboBox(strTypes);
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(MerchantTable);
		//toolBar.add(btnAdd);
		//toolBar.add(this.btnDelete);
		//toolBar.add(btnModify);
		toolBar.add(edtKeyword);
		toolBar.add(btnSearch);

		
		
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		//提取现有数据
		this.reloadTable();
		this.getContentPane().add(new JScrollPane(this.MerchantTable), BorderLayout.CENTER);
		
		// 屏幕居中显示
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		

		//this.btnAdd.addActionListener(this);
		//this.btnDelete.addActionListener(this);
		//this.btnModify.addActionListener(this);
		this.btnSearch.addActionListener(this);
		this.edtKeyword.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnSearch) {
			 try {
					this.loadTable();
				} catch (BaseException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
				}
		}
			
		
	}
}
