package cn.sdut.biz;

import java.sql.SQLException;
import java.util.List;


import cn.sdut.po.Account;
import cn.sdut.po.Record;

public interface BankService {
	//开户
	public boolean openAccout(Account account);
	//销户
	public boolean delAccout(String accountID,String password);
	//存钱
	public boolean saveMoney(String name,String id,float change,String style,String date);
	//取钱
	public boolean getMoney(String id,String password, float change,String style,String date);
	//转账
	public boolean turnMoney(String inName,String inId,String outId, String password,float change,String style,String date) throws SQLException;
	public boolean updatePassword(String id,String password,String newPassword);
	//查询账户
	public List<Account> selectAccount(String id,String password);
	//查询操作记录
	public List<Record> selectRecord(String id);
	//查询所有账户
	//public List<Account> selectAll();
	//查询姓名为**的账户
	//public Account selectByName(String name);


	
}
