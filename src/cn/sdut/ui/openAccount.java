package cn.sdut.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Dialog;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import cn.sdut.biz.impl.BankServiceImpl;
import cn.sdut.po.Account;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;

public class openAccount extends JDialog {

	private JFrame frame;
	private JTextField Fname;
	private JTextField textField_1;
	private JTextField Fmoney;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					openAccount window = new openAccount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public openAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 372, 263);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setVisible(true);
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 450, 0);
		frame.getContentPane().add(label);
		
		JLabel name = new JLabel("用户名");
		name.setBounds(88, 69, 46, 26);
		frame.getContentPane().add(name);
		
		JLabel money = new JLabel("金额");
		money.setBounds(88, 127, 53, 26);
		frame.getContentPane().add(money);
		
		Fname = new JTextField();
		Fname.setBounds(167, 69, 144, 31);
		frame.getContentPane().add(Fname);
		Fname.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(181, 69, 130, 26);
		frame.getContentPane().add(textField_1);
		
		Fmoney = new JTextField();
		Fmoney.setColumns(10);
		Fmoney.setBounds(167, 122, 144, 31);
		frame.getContentPane().add(Fmoney);
		
		JButton openbtn = new JButton("确定");
		openbtn.addActionListener(new ActionListener() {
			BankServiceImpl bs = new BankServiceImpl();
			public void actionPerformed(ActionEvent e) {
				String n=Fname.getText();
				float m=Float.parseFloat(Fmoney.getText());
				System.out.println(n);

				String accountID = "";
				Random random = new Random();
				for (int i = 0; i < 6; i++) {
					accountID += random.nextInt(10);
				}
				
				
				String password ="111111";
				
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				Account account=new Account();
				account.setName(n);
				account.setMoney(m);
				account.setPassword(password);
				account.setAccountID(accountID);
				account.setDate(sdf2.format(date));
				bs.openAccout(account);
				String msg = "您的开户账号为："+accountID+" "+"您的初始密码为(请及时修改密码)："+password;
				JOptionPane.showInputDialog(msg, accountID);
				System.out.println("您的开户账号为："+accountID+" "+"您的初始密码为(请及时修改密码)："+password);
				
				
//				//JOptionPane.showMessageDialog(null, "配送成功,欢迎下次光临","订单配送状态",WIDTH);
			}
		});
		openbtn.setBounds(121, 187, 101, 37);
		frame.getContentPane().add(openbtn);
	}

	
}
