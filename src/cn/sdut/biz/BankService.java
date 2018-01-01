package cn.sdut.biz;

import java.sql.SQLException;
import java.util.List;


import cn.sdut.po.Account;
import cn.sdut.po.Record;

public interface BankService {
	//����
	public boolean openAccout(Account account);
	//����
	public boolean delAccout(String accountID,String password);
	//��Ǯ
	public boolean saveMoney(String name,String id,float change,String style,String date);
	//ȡǮ
	public boolean getMoney(String id,String password, float change,String style,String date);
	//ת��
	public boolean turnMoney(String inName,String inId,String outId, String password,float change,String style,String date) throws SQLException;
	public boolean updatePassword(String id,String password,String newPassword);
	//��ѯ�˻�
	public List<Account> selectAccount(String id,String password);
	//��ѯ������¼
	public List<Record> selectRecord(String id);
	//��ѯ�����˻�
	//public List<Account> selectAll();
	//��ѯ����Ϊ**���˻�
	//public Account selectByName(String name);


	
}
