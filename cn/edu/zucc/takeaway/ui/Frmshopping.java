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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.control.MerchantManager;
import cn.edu.zucc.takeaway.control.customerManager;
import cn.edu.zucc.takeaway.control.goodsManager;
import cn.edu.zucc.takeaway.model.Beancus;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.model.Beanshop;
import cn.edu.zucc.takeaway.util.BaseException;

public class Frmshopping extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	
	//private JTextField edtKeyword = new JTextField(10);
	private Button btnSearch = new Button("结算");
	private Button btnCancel = new Button("取消");
	
	private JComboBox cmbReadertype=null;
	
	private Object tblTitle[]={"商品名","数量","价格","优惠金额"};
	private Object tblData[][];
	List<Beanshop> shop=null;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable MerchantTable=new JTable(tablmod);
	private void reloadTable(){
		//System.out.println("a");
		try {
			int n=this.cmbReadertype.getSelectedIndex();
			int rtId=0;
			shop=takeawayUtil.goodsManager.listshop();
			//merchant=(new MerchantManager()).searchReader(this.edtKeyword.getText(), rtId);
			tblData =new Object[shop.size()][4];
			for(int i=0;i<shop.size();i++){
				//tblData[i][0]=shop.get(i).getMerchant_name();
				tblData[i][0]=shop.get(i).getGoods_name();
				tblData[i][1]=shop.get(i).getGoods_amount();
				tblData[i][2]=shop.get(i).getGoods_price();
				tblData[i][3]=shop.get(i).getGoods_reduce();
				
			}	
			tablmod.setDataVector(tblData,tblTitle);
			this.MerchantTable.validate();
			this.MerchantTable.repaint();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Frmshopping(JDialog f, String s, boolean b) {
		super(f, s, b);
		
		List<Beanshop> shop=null;
		shop=(new goodsManager()).listshop();
		String[] strTypes=new String[shop.size()+1];
		strTypes[0]="";
		for(int i=0;i<shop.size();i++) {
			strTypes[i+1]=shop.get(i).getGoods_name();
		}
		cmbReadertype=new JComboBox(strTypes);
		
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(btnSearch);
		toolBar.add(btnCancel);

		
		
		this.getContentPane().add(toolBar, BorderLayout.SOUTH);
		//提取现有数据
		
		this.getContentPane().add(new JScrollPane(this.MerchantTable), BorderLayout.NORTH);
		this.reloadTable();
		// 屏幕居中显示
		this.setSize(800, 600);
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setLocation((int) (width - this.getWidth()) / 2,
				(int) (height - this.getHeight()) / 2);

		this.validate();
		

	
		this.btnSearch.addActionListener(this);
		this.btnCancel.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnSearch) {
			Frmpay dlg=new Frmpay(this,"结算",true);
			dlg.setVisible(true);
			this.reloadTable();
		}
			
		
	}
	
}
