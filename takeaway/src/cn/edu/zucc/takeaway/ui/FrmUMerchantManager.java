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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.control.MerchantManager;
import cn.edu.zucc.takeaway.control.customerManager;
import cn.edu.zucc.takeaway.control.userManager;
import cn.edu.zucc.takeaway.model.Beancus;
import cn.edu.zucc.takeaway.model.Beanmerchant;
import cn.edu.zucc.takeaway.util.BaseException;



public class FrmUMerchantManager extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("添加新商家");
	private Button btnModify = new Button("修改商家");
	private Button btnDelete = new Button("注销商家");

	
    private JComboBox cmbReadertype=null;
	
	private JTextField edtKeyword = new JTextField(10);
	private Button btnSearch = new Button("查询");
	
	private Object tblTitle[]={"商家编号","商家名","商家星级","人均消费","总销量"};
	private Object tblData[][];
	List<Beanmerchant> merchant=null;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable MerchantTable=new JTable(tablmod);
	private void reloadTable(){
		try {
			int n=this.cmbReadertype.getSelectedIndex();
			int rtId=0;
			merchant=(new MerchantManager()).loadAll();
			//merchant=(new MerchantManager()).searchReader(this.edtKeyword.getText(), rtId);
			tblData =new Object[merchant.size()][5];
			for(int i=0;i<merchant.size();i++){
				tblData[i][0]=merchant.get(i).getMerchant_id();
				tblData[i][1]=merchant.get(i).getMerchant_name();	
				tblData[i][2]=merchant.get(i).getMerchant_star();
				tblData[i][3]=merchant.get(i).getMerchant_avgc();
				tblData[i][4]=merchant.get(i).getMerchant_total();
				tablmod.setDataVector(tblData,tblTitle);
				this.MerchantTable.validate();
				this.MerchantTable.repaint();
			}		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public FrmUMerchantManager(Frame f, String s, boolean b) {
		super(f, s, b);
		
		List<Beanmerchant> mc =null;
		try {
			mc=(new MerchantManager()).loadAll();
			String[] strTypes=new String[mc.size()+1];
			strTypes[0]="";
			for(int i=0;i<mc.size();i++) {
				strTypes[i+1]=mc.get(i).getMerchant_id();
			}
			cmbReadertype=new JComboBox(strTypes);
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolBar.add(MerchantTable);
		toolBar.add(btnAdd);
		toolBar.add(this.btnDelete);
		toolBar.add(btnModify);
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
		

		this.btnAdd.addActionListener(this);
		this.btnDelete.addActionListener(this);
		this.btnModify.addActionListener(this);
		this.btnSearch.addActionListener(this);
		this.edtKeyword.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//System.exit(0);
			}
		});
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	      if(e.getSource()==this.btnAdd) {
	    	  
	      }
	      else if(e.getSource()==this.btnDelete) {
	    	  int i=this.MerchantTable.getSelectedRow();
				if(i<0) {
					JOptionPane.showMessageDialog(null,  "请选择商家","提示",JOptionPane.ERROR_MESSAGE);
					return;
				}
				Beanmerchant mc=this.merchant.get(i);
				if(JOptionPane.showConfirmDialog(this,"确定删除该商家吗？","确认",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					try {
						(new MerchantManager()).removeMerchant(mc.getMerchant_id(), userManager.currentUser.getClerk_id());
						this.reloadTable();
					} catch (BaseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),"错误",JOptionPane.ERROR_MESSAGE);
					}
					
				}
	      }
	      else if(e.getSource()==this.btnSearch) {
	    	  this.reloadTable();
	      }

		}
		
	
}
