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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.control.customerManager;
import cn.edu.zucc.takeaway.control.riderManager;
import cn.edu.zucc.takeaway.model.Beancus;
import cn.edu.zucc.takeaway.model.Beanrider;
import cn.edu.zucc.takeaway.util.BaseException;

public class FrmUriderlist extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	
	private JComboBox cmbReadertype=null;
	
	private JTextField edtKeyword = new JTextField(10);
	private Button btnSearch = new Button("查询");
	
	private Object tblTitle[]={"骑手编号","骑手姓名","入职日期","身份"};
	private Object tblData[][];
	
	List<Beanrider> rider=null;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable MerchantTable=new JTable(tablmod);
	private void reloadTable(){
		try {
			int n=this.cmbReadertype.getSelectedIndex();
			int rtId=0;
			rider=(new riderManager()).loadAll();
			//merchant=(new MerchantManager()).searchReader(this.edtKeyword.getText(), rtId);
			tblData =new Object[rider.size()][4];
			for(int i=0;i<rider.size();i++){
				tblData[i][0]=rider.get(i).getRider_id();
				tblData[i][1]=rider.get(i).getRider_name();
				tblData[i][2]=rider.get(i).getRider_workdate();
				tblData[i][3]=rider.get(i).getRider_identity();
				
				tablmod.setDataVector(tblData,tblTitle);
				this.MerchantTable.validate();
				this.MerchantTable.repaint();
			}		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public FrmUriderlist(Frame f, String s, boolean b) {
		super(f, s, b);
		
		List<Beanrider> rider =null;
		try {
			rider=(new riderManager()).loadAll();
			String[] strTypes=new String[rider.size()+1];
			strTypes[0]="";
			for(int i=0;i<rider.size();i++) {
				strTypes[i+1]=rider.get(i).getRider_id();
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
			String text=this.edtKeyword.getText();
			takeawayUtil.riderManager.searchrider(text);
			this.setVisible(true);
		}
			
		
	}
}
