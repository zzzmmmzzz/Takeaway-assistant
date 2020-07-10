package cn.edu.zucc.takeaway.ui;

import java.awt.Button;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class Frmorders extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private Button btnAdd = new Button("添加商品");
	//private Button btnModify = new Button("修改商家");
	private Button btnDelete = new Button("删除商品");
	private JComboBox cmbReadertype=null;
	
	private Object tblTitle[]={"商家编号","商家名","商家星级","人均消费","总销量"};
	private Object tblData[][];
	
	
	
	
}
