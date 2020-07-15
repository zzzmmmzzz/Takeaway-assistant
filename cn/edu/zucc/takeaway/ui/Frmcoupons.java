package cn.edu.zucc.takeaway.ui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Frmcoupons extends JDialog implements ActionListener{
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("添加新优惠");
	private Button btnDelete = new Button("删除优惠");
	
	private JComboBox cmbReadertype=null;
	
	private Object tblTitle[]={"优惠券金额","优惠券数量","开始日期 ","结束日期"};
	
	private Object tblData[][];
	//List<Beancoupons> coupons=null;
	
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable MerchantTable=new JTable(tablmod);
	
	private void reloadTable(){
		
	}
	public Frmcoupons(Frame f, String s, boolean b) {
		super(f, s, b);
		//cmbReadertype=new JComboBox(strTypes);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
