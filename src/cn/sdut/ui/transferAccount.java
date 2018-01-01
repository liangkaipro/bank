package cn.sdut.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import cn.sdut.biz.impl.BankServiceImpl;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
public class transferAccount extends JDialog {

	private JFrame frame;
	private JTextField Foutid;
	private JTextField Finname;
	private JTextField Finid;
	private JTextField Fmoney;
	private JPasswordField Fpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transferAccount window = new transferAccount();
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
	public transferAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel outid = new JLabel("转账账号");
		outid.setBounds(109, 25, 73, 23);
		frame.getContentPane().add(outid);
		
		JLabel pass = new JLabel("密码");
		pass.setBounds(134, 65, 73, 23);
		frame.getContentPane().add(pass);
		
		JLabel inname = new JLabel("收账账户名");
		inname.setBounds(96, 111, 73, 23);
		frame.getContentPane().add(inname);
		
		JLabel inid = new JLabel("收账账号");
		inid.setBounds(109, 148, 73, 23);
		frame.getContentPane().add(inid);
		
		JLabel money = new JLabel("转账金额");
		money.setBounds(109, 189, 73, 23);
		frame.getContentPane().add(money);
		
		Foutid = new JTextField();
		Foutid.setBounds(173, 20, 140, 33);
		frame.getContentPane().add(Foutid);
		Foutid.setColumns(10);
		
		Finname = new JTextField();
		Finname.setColumns(10);
		Finname.setBounds(173, 106, 140, 33);
		frame.getContentPane().add(Finname);
		
		Finid = new JTextField();
		Finid.setColumns(10);
		Finid.setBounds(173, 143, 140, 33);
		frame.getContentPane().add(Finid);
		
		Fmoney = new JTextField();
		Fmoney.setColumns(10);
		Fmoney.setBounds(173, 184, 140, 33);
		frame.getContentPane().add(Fmoney);
		
		Fpass = new JPasswordField();
		Fpass.setBounds(173, 63, 140, 33);
		frame.getContentPane().add(Fpass);
		
		JButton transferbtn = new JButton("转账");
		transferbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankServiceImpl bs = new BankServiceImpl();
				String out = Foutid.getText();
				@SuppressWarnings("deprecation")
				String p = Fpass.getText();
				String inname = Finname.getText();
				String inid = Finid.getText();
				float m = Float.parseFloat(Fmoney.getText());
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
			
				String style = "转账";
				try {
			
					bs.turnMoney(inname, inid, out, p, m,style,sdf2.format(date));
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				
			}
		});
		transferbtn.setBounds(348, 211, 96, 48);
		frame.getContentPane().add(transferbtn);
	}

}
