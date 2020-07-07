package cn.edu.zucc.takeaway.itf;

import cn.edu.zucc.takeaway.model.Beanuser;
import cn.edu.zucc.takeaway.util.BaseException;

public interface IuserManager {

	public Beanuser reg(String clerkname,String pwd,String pwd2) throws BaseException;
	/**
	 * ��½
	 * 1������û������ڻ�����������׳�һ���쳣
	 * 2�������֤�ɹ����򷵻ص�ǰ�û���Ϣ
	 * @param userid
	 * @param pwd
	 * @return
	 * @throws BaseException
	 */
	public Beanuser login(String clerkid,String pwd)throws BaseException;
	/**
	 * �޸�����
	 * ���û�гɹ��޸ģ����׳��쳣
	 * @param user    ��ǰ�û�
	 * @param oldPwd  ԭ����
	 * @param newPwd  ������
	 * @param newPwd2 �ظ������������
	 */
	public void changePwd(Beanuser user, String oldPwd,String newPwd, String newPwd2)throws BaseException;

}
