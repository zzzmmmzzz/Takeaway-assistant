package cn.edu.zucc.takeaway.ui;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



public class FrmUgoodManager extends JDialog implements ActionListener {
	private JMenuBar menubar=new JMenuBar();
	
	private JMenu menu_goodManager=new JMenu("商品管理");
	
	private JMenuItem  menuItem_Addgoods=new JMenuItem("添加商品");
	private JMenuItem  menuItem_deletegoods=new JMenuItem("删除商品");
	
	//private FrmLogin dlgLogin=null;
	private JPanel statusBar = new JPanel();
	
}
