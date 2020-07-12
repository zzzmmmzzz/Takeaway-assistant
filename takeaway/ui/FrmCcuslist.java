package cn.edu.zucc.takeaway.ui;

import java.awt.List;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.edu.zucc.takeaway.util.BaseException;
import cn.edu.zucc.takeaway.model.Beancus;



public class FrmCcuslist extends JDialog implements ActionListener {
	private JPanel toolBar = new JPanel();
	private Object tblTitle[]={"用户姓名","用户性别","账号密码","手机号","邮箱","会员状态"};
	private Object tblData[][];
	List<Beancus> cus=null;
	DefaultTableModel tablmod=new DefaultTableModel();
	private JTable dataTable=new JTable(tablmod);
	private void reloadTable(){
		
		try {
			
			tblData =new Object[books.size()][5];
		}catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
