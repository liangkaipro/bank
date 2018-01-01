package cn.sdut.dao;

import java.sql.SQLException;
import java.util.List;


import cn.sdut.po.Account;
import cn.sdut.po.Record;

public interface AccountDao {
	public int addAccount(Account account);
	public int delAccount(String accountID,String password);
	public int updateAccount(String name,String id,float change,String style,String date);
	public List<Account> selectAccount(String id,String password);
	public int updatePassword(String id,String password,String newPassword);
	public int alertAccount(String id,String password,float change,String style,String date) throws SQLException;
	public List<Record> selectRecord(String id);

}
