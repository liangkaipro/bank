package cn.sdut.biz.impl;

import java.sql.SQLException;

import java.util.List;

import cn.sdut.biz.BankService;

import cn.sdut.dao.impl.AccountDaoImpl;
import cn.sdut.po.Account;
import cn.sdut.po.Record;

public class BankServiceImpl implements BankService {

	AccountDaoImpl dao=new AccountDaoImpl();
	
	@Override
	public boolean openAccout(Account account) {
		int result = dao.addAccount(account);
		if(result>0) {
			System.out.println("开户成功！");
			return true;
		}else {
			System.out.println("请检查输入，开户失败！");
		return false;
		}
		
	}

	@Override
	public boolean delAccout(String accountID,String password) {
		int result  = dao.delAccount(accountID, password);
		if(result>0) {
			System.out.println("销户成功！");
			return true;
		}else {
			System.out.println("销户失败请检查账号或密码！");
		return false;
		}
	}

	@Override
	public boolean saveMoney(String name,String id, float change,String style,String date) {
		int result = dao.updateAccount(name,id, change,style,date);
		if(result>0) {
			System.out.println("存款成功！");
			return true;
		}else {
			System.out.println("存款失败，请检查输入！");
		return false;
		}
	}

	@Override
	public boolean getMoney(String id,String password, float change,String style,String date) {
		int result = 0;
		result = dao.alertAccount(id,password,change,style,date);
		if (result > 0) {
			System.out.println("取款成功！");
			return true;
		} else {
			System.out.println("取款失败，请检查输入！");
			return false;
		}

	}

	@Override
	public boolean turnMoney(String inName,String inId,String outId,String password,float change,String style,String date) throws SQLException {
		int r1=0;
		int r2=0;
		
		try {
			dao.con.setAutoCommit(false);
			r1=dao.updateAccount(inName, inId,change,style,date);
			r2=dao.alertAccount(outId,password,change,style,date);
        if(r1*r2>0){
			dao.con.commit();
          }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (r1 * r2 > 0) {
			
			System.out.println("转账成功！");
			return true;
		} else {
			System.out.println("转账失败！");
			return false;
		}

	}

//	@Override
//	public List<Account> selectAll() {
//		List<Account> all = dao.selectAll();
//		return all;
//	}

//	@Override
//	public Account selectByName(String name) {
//		Account s = dao.selectByName(name);
//		return s;
//	}
//

	@Override
	public boolean updatePassword(String id, String password, String newPassword) {
		int result = dao.updatePassword(id, password, newPassword);
		if (result > 0) {
			System.out.println("修改密码成功！");
			return true;
		} else {
			System.out.println("修改密码失败！");
			return false;
		}

	}

	@Override
	public List<Account> selectAccount(String id,String password) {
		List<Account> s=dao.selectAccount(id, password);
		for (Account account : s) {
			System.out.println("用户："+account.getName()+"  账号："+account.getAccountID()+"  余额："+account.getMoney());
		
		}
		
		return s;
	}

	@Override
	public List<Record> selectRecord(String id) {
		List<Record> all = dao.selectRecord(id);
		System.out.println("操作类型"+"    "+"操作金额"+"   "+"操作时间");
		for (Record record : all) {
			System.out.println(record.getStyle()+"     "+record.getChange()+"     "+record.getDate());
		}
		System.out.println();
		return all;
	}

}
