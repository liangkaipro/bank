package cn.sdut.aui;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import cn.sdut.biz.BankService;
import cn.sdut.biz.impl.BankServiceImpl;
import cn.sdut.po.Account;
import cn.sdut.po.Record;

public class Main {
	
	BankServiceImpl bs = new BankServiceImpl();
	public void show(){
		System.out.println("***欢迎使用银行信息管理系统****");
		System.out.println("1.开户");
		System.out.println("2.转账");
		System.out.println("3.查询");
		System.out.println("4.销户");
		System.out.println("5.存款");
		System.out.println("6.取款");
		System.out.println("7.修改密码");
	}
	public void select() throws SQLException{
		System.out.println("请输入您的操作：");
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		switch (n) {
		case 1:
			createAccount();
			break;
		case 2:
			transferAccount();
			break;
		case 3:
			searchAll();
			break;
		case 4:
			delAccount();
			break;
		case 5:
			saveMoney();
			break;
		case 6:
			getMoney();
			break;
		case 7:
			updatePassword();
			break;
		}

	}
	//开户
	public void createAccount() throws SQLException{
		String accountID = "";
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			accountID += random.nextInt(10);
		}
		Scanner console = new Scanner(System.in);
		String name;
		String password ="111111";
		float money;
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println("请输入您的开户姓名：");
		name = console.nextLine();
		System.out.println("请输入您的开户金额：");
		money = console.nextFloat();
		Account account=new Account();
		account.setName(name);
		account.setMoney(money);
		account.setPassword(password);
		account.setAccountID(accountID);
		account.setDate(sdf2.format(date));
		bs.openAccout(account);
		System.out.println("您的开户账号为："+accountID+" "+"您的初始密码为(请及时修改密码)："+password);
		show();
		select();
	}
	//转账
	public void transferAccount() throws SQLException {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Scanner console = new Scanner(System.in);
		System.out.println("请输入转出账户id：");
		String outId = console.next();
		System.out.println("请输入账户密码：");
		String password = console.next();
		System.out.println("请输入转出金额：");
		float money = console.nextFloat();
		System.out.println("请输入转入账户名称：");
		String inName = console.next();
		System.out.println("请输入转入账户id：");
		String inId = console.next();
		String style = "转账";
		bs.turnMoney(inName, inId, outId, password, money,style,sdf2.format(date));
		show();
		select();
	}

	//查询
	public void searchAll() throws SQLException{
		Scanner console = new Scanner(System.in);
		System.out.println("请输入查询账号：");
		String id= console.next();
		System.out.println("请输入账户密码：");
		String password = console.next();
		 bs.selectAccount(id, password);
		 bs.selectRecord(id);
		
	
		show();
		select();
		
	}

	// 销户
	public void delAccount() throws SQLException {
		Scanner console = new Scanner(System.in);
         System.out.println("请输入银行卡账号：");
         String ID = console.next();
        System.out.println("请输入密码：");
        String password = console.next();
        bs.delAccout(ID, password);
        show();
        select();
       
	}
	//存钱
	public void saveMoney() throws SQLException{
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Scanner console = new Scanner(System.in);
		System.out.println("请输入存款账户名：");
		String name = console.next();
		System.out.println("请输入存款帐号：");
		String id = console.next();
		System.out.println("请输入存款金额：");
        float money = console.nextFloat();
        String style = "存款";
        bs.saveMoney(name, id, money,style,sdf2.format(date));
        show();
        select();
        
		
		
	}
	//重置密码
	public void updatePassword() throws SQLException{
		Scanner console = new Scanner(System.in);
		System.out.println("请输入账户ID：");
		String id = console.next();
		System.out.println("请输入账户密码：");
		String password = console.next();
		System.out.println("请输入新密码(6位)：");
		String newPassword = console.next();
		System.out.println("请确认新密码：");
		String rePassword = console.next();
		if(rePassword.equals(newPassword))
		{
			bs.updatePassword(id, password, newPassword);
			show();
			select();
		}
		else
		{
			System.out.println("请检查输入！");
			show();
			select();
		}
	}
//取款
	public void getMoney() throws SQLException{
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Scanner console = new Scanner(System.in);
		System.out.println("请输入取款账户id：");
		String id = console.next();
		System.out.println("请输入密码：");
		String password = console.next();
		System.out.println("请输入取款金额：");
		float money = console.nextFloat();
		String style="取款";
		bs.getMoney(id, password, money,style,sdf2.format(date));
		show();
		select();
	}

	public static void main(String[] args) throws SQLException {
		
		Main a = new Main();
		a.show();
		a.select();

	}
}
