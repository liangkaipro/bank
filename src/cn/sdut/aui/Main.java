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
		System.out.println("***��ӭʹ��������Ϣ����ϵͳ****");
		System.out.println("1.����");
		System.out.println("2.ת��");
		System.out.println("3.��ѯ");
		System.out.println("4.����");
		System.out.println("5.���");
		System.out.println("6.ȡ��");
		System.out.println("7.�޸�����");
	}
	public void select() throws SQLException{
		System.out.println("���������Ĳ�����");
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
	//����
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
		System.out.println("���������Ŀ���������");
		name = console.nextLine();
		System.out.println("���������Ŀ�����");
		money = console.nextFloat();
		Account account=new Account();
		account.setName(name);
		account.setMoney(money);
		account.setPassword(password);
		account.setAccountID(accountID);
		account.setDate(sdf2.format(date));
		bs.openAccout(account);
		System.out.println("���Ŀ����˺�Ϊ��"+accountID+" "+"���ĳ�ʼ����Ϊ(�뼰ʱ�޸�����)��"+password);
		show();
		select();
	}
	//ת��
	public void transferAccount() throws SQLException {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Scanner console = new Scanner(System.in);
		System.out.println("������ת���˻�id��");
		String outId = console.next();
		System.out.println("�������˻����룺");
		String password = console.next();
		System.out.println("������ת����");
		float money = console.nextFloat();
		System.out.println("������ת���˻����ƣ�");
		String inName = console.next();
		System.out.println("������ת���˻�id��");
		String inId = console.next();
		String style = "ת��";
		bs.turnMoney(inName, inId, outId, password, money,style,sdf2.format(date));
		show();
		select();
	}

	//��ѯ
	public void searchAll() throws SQLException{
		Scanner console = new Scanner(System.in);
		System.out.println("�������ѯ�˺ţ�");
		String id= console.next();
		System.out.println("�������˻����룺");
		String password = console.next();
		 bs.selectAccount(id, password);
		 bs.selectRecord(id);
		
	
		show();
		select();
		
	}

	// ����
	public void delAccount() throws SQLException {
		Scanner console = new Scanner(System.in);
         System.out.println("���������п��˺ţ�");
         String ID = console.next();
        System.out.println("���������룺");
        String password = console.next();
        bs.delAccout(ID, password);
        show();
        select();
       
	}
	//��Ǯ
	public void saveMoney() throws SQLException{
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Scanner console = new Scanner(System.in);
		System.out.println("���������˻�����");
		String name = console.next();
		System.out.println("���������ʺţ�");
		String id = console.next();
		System.out.println("���������");
        float money = console.nextFloat();
        String style = "���";
        bs.saveMoney(name, id, money,style,sdf2.format(date));
        show();
        select();
        
		
		
	}
	//��������
	public void updatePassword() throws SQLException{
		Scanner console = new Scanner(System.in);
		System.out.println("�������˻�ID��");
		String id = console.next();
		System.out.println("�������˻����룺");
		String password = console.next();
		System.out.println("������������(6λ)��");
		String newPassword = console.next();
		System.out.println("��ȷ�������룺");
		String rePassword = console.next();
		if(rePassword.equals(newPassword))
		{
			bs.updatePassword(id, password, newPassword);
			show();
			select();
		}
		else
		{
			System.out.println("�������룡");
			show();
			select();
		}
	}
//ȡ��
	public void getMoney() throws SQLException{
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Scanner console = new Scanner(System.in);
		System.out.println("������ȡ���˻�id��");
		String id = console.next();
		System.out.println("���������룺");
		String password = console.next();
		System.out.println("������ȡ���");
		float money = console.nextFloat();
		String style="ȡ��";
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
