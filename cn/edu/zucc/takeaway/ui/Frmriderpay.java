package cn.edu.zucc.takeaway.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
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
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.takeawayUtil;
import cn.edu.zucc.takeaway.control.goodsManager;
import cn.edu.zucc.takeaway.control.riderManager;
import cn.edu.zucc.takeaway.model.Beanrider_wage;
import cn.edu.zucc.takeaway.model.Beanshop;
import cn.edu.zucc.takeaway.util.BaseException;

public class Frmriderpay extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	//private Button btnSearch = new Button("结算");
	private Button btnCancel = new Button("取消");
	private JComboBox cmbReadertype=null;
	private Object tblTitle[]={"骑手编号","订单编号","金额"};
	private Object tblData[][];
	List<Beanrider_wage> wage=null;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable MerchantTable=new JTable(tablmod);
	
	private void reloadTable(){
		try {
		  wage=takeawayUtil.riderManager.listwage();
		  tblData =new Object[wage.size()][3];
			for(int i=0;i<wage.size();i++){
				//tblData[i][0]=shop.get(i).getMerchant_name();
				tblData[i][0]=wage.get(i).getRider_id();
				tblData[i][1]=wage.get(i).getOrder_id();
				tblData[i][2]=wage.get(i).getOrder_amount();
				//tblData[i][3]=shop.get(i).getGoods_reduce();
		}
			tablmod.setDataVector(tblData,tblTitle);
			this.MerchantTable.validate();
			this.MerchantTable.repaint();
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	public Frmriderpay(JFrame f, String s, boolean b) throws BaseException {
		super(f, s, b);
		
		List<Beanrider_wage> wage=null;
		wage=(new riderManager()).listwage();
		String[] strTypes=new String[wage.size()+1];
		strTypes[0]="";
		for(int i=0;i<wage.size();i++) {
			strTypes[i+1]=wage.get(i).getOrder_id();
		}
		cmbReadertype=new JComboBox(strTypes);
		
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		//toolBar.add(btnSearch);
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
		

	
		//this.btnSearch.addActionListener(this);
		this.btnCancel.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		/*if(e.getSource()==this.btnSearch) {
			Frmpay pay=new Frmpay(this,"结算",true);
			this.setVisible(true);
		}*/
			
		
	}
	
}
