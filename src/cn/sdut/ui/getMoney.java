package cn.sdut.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JDialog;
import cn.sdut.biz.impl.BankServiceImpl;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class getMoney extends JDialog {

	private JFrame frame;
	private JTextField Fid;
	private JPasswordField Fpass;
	private JTextField Fmoney;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getMoney window = new getMoney();
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
	public getMoney() {
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
		JLabel id = new JLabel("账号");
		id.setBounds(130, 76, 61, 27);
		frame.getContentPane().add(id);
		
		JLabel pass = new JLabel("密码");
		pass.setBounds(130, 123, 61, 27);
		frame.getContentPane().add(pass);
		
		JLabel money = new JLabel("金额");
		money.setBounds(130, 169, 61, 27);
		frame.getContentPane().add(money);
		
		Fid = new JTextField();
		Fid.setBounds(178, 72, 138, 34);
		frame.getContentPane().add(Fid);
		Fid.setColumns(10);
		
		Fpass = new JPasswordField();
		Fpass.setBounds(178, 115, 138, 34);
		frame.getContentPane().add(Fpass);
		
		Fmoney = new JTextField();
		Fmoney.setBounds(178, 162, 138, 33);
		frame.getContentPane().add(Fmoney);
		Fmoney.setColumns(10);
		
		JButton getbtn = new JButton("取款");
		getbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankServiceImpl bs = new BankServiceImpl();
				String id = Fid.getText();
				@SuppressWarnings("deprecation")
				String p = Fpass.getText();
				float m = Float.parseFloat(Fmoney.getText());
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
			
				String style="取款";
				bs.getMoney(id, p, m,style,sdf2.format(date));
			}
		});
		getbtn.setBounds(297, 215, 81, 41);
		frame.getContentPane().add(getbtn);
	}
}
