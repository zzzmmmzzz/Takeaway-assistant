package cn.edu.zucc.takeaway.ui;

import java.awt.Button;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.control.MerchantManager;
import cn.edu.zucc.takeaway.model.Beangoods_details;
import cn.edu.zucc.takeaway.model.Beanmerchant;

public class Frmshopping {
	private JPanel toolBar = new JPanel();
	
	//private JTextField edtKeyword = new JTextField(10);
	private Button btnSearch = new Button("����");
	private Button btnCancel = new Button("ȡ��");
	
	private JComboBox cmbReadertype=null;
	
	private Object tblTitle[]={"�̼���","��Ʒ��","��Ʒ�۸�","����"};
	private Object tblData[][];
	List<Beangoods_details> details=null;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable MerchantTable=new JTable(tablmod);
	private void reloadTable(){
		try {
			int n=this.cmbReadertype.getSelectedIndex();
			int rtId=0;
			Merchant=(new MerchantManager()).loadAll();
		}
	}
	
}
