package cn.sdut.dao.impl;

import java.sql.SQLException;



import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.sdut.dao.AccountDao;
import cn.sdut.dao.BaseDao;
import cn.sdut.po.Account;
import cn.sdut.po.Record;

public class AccountDaoImpl extends BaseDao implements AccountDao {
//开户
	@Override
	public int addAccount(Account account) {
		int result=0;
		int result1=0;
		String sql="insert into account values(null,?,?,?,?,?)";
		String sql1="insert into record values(null,'开户',?,?,?)";
		try {
			result = runner.update(con,sql,account.getName(),account.getMoney(),account.getAccountID(),account.getPassword(),account.getDate());
			result1= runner.update(con,sql1,account.getMoney(),account.getDate(),account.getAccountID());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
//销户
	@Override
	public int delAccount(String accountID,String password) {
		int result=0;
		int result1 = 0;
		String sql="delete from account where accountID=?&&password=?";
		String sql1= "delete from record where account_id=?";
		try {
			result = runner.update(con, sql, accountID,password);
			result1= runner.update(con,sql1,accountID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 将账户名称为name的金额变化change
	 */
	//存款或者转账
	@Override
	public int updateAccount(String name,String id,float change,String style,String date) {
		String sql="update account set money=money+? where name=?&&accountID=?";
		String sql1="insert into record values(null,?,?,?,?)";
	    int result=0;
	    int result1=0;
		try {
			result=runner.update(con,sql,change,name,id);
			result1=runner.update(con,sql1,style,change,date,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

//	@Override
//	public List<Account> selectAll() {
//		String sql="select * from account";
//		List<Account> acList=null;
//		try {
//			 acList = runner.query(con,sql,new BeanListHandler<Account>(Account.class));
//		} catch (SQLException e) { 
//			e.printStackTrace();
//		}
//		return acList;
//	}

	@Override
	public List<Account> selectAccount(String id,String password) {
	    List<Account> acc=null;
	   
		String sql="select * from account where accountID=?&&password=?";
		try {
			 acc = runner.query(con,sql,new BeanListHandler<Account>(Account.class),id,password);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public int updatePassword(String id,String password,String newPassword) {
		int result = 0;
		String sql="update account set password=? where accountID=?&&password=?";
		try {
			result = runner.update(con,sql,newPassword,id,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return result;
	}

	@Override
	public int alertAccount(String id, String password, float change,String style,String date) {
		String sql = "update account set money=money-? where accountID=?&&password=?";
        String sql2 = "select * from account where accountID=?&&password=?";
        String sql3= "insert into record values(null,?,?,?,?)";
        Account acc=null;
		int result = 0;
		float money = 0;
		int result1=0;
		
		
		try {
			
			acc=runner.query(con,sql2,new BeanHandler<Account>(Account.class),id,password);
			money = acc.getMoney();
			System.out.println(money);
			if(change<=money)
			{
				result = runner.update(con, sql, change, id,password);
				result1 = runner.update(con,sql3,style,change*(-1),date,id);
			}
			else
			{
				System.out.println("您的余额不足！");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<Record> selectRecord(String id) {
		String sql = "select * from record where account_id=?";
		List<Record> re = null;
		try {
			re=runner.query(con,sql,new BeanListHandler<Record>(Record.class),id);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return re;
	}



}
