package cn.sdut.ui;

import java.awt.EventQueue;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import cn.sdut.biz.impl.BankServiceImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class saveMoney extends JDialog{

	private JFrame frame;
	private JTextField Fname;
	private JTextField Fid;
	private JTextField Fmoney;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					saveMoney window = new saveMoney();
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
	public saveMoney() {
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
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 278);
		frame.getContentPane().add(label);
		
		JLabel name = new JLabel("账户名");
		name.setBounds(72, 65, 57, 26);
		frame.getContentPane().add(name);
		
		JLabel id = new JLabel("账号");
		id.setBounds(72, 114, 57, 26);
		frame.getContentPane().add(id);
		
		JLabel money = new JLabel("金额");
		money.setBounds(72, 168, 57, 26);
		frame.getContentPane().add(money);
		
		Fname = new JTextField();
		Fname.setBounds(141, 61, 130, 35);
		frame.getContentPane().add(Fname);
		Fname.setColumns(10);
		
		Fid = new JTextField();
		Fid.setColumns(10);
		Fid.setBounds(141, 114, 130, 35);
		frame.getContentPane().add(Fid);
		
		Fmoney = new JTextField();
		Fmoney.setColumns(10);
		Fmoney.setBounds(141, 168, 130, 35);
		frame.getContentPane().add(Fmoney);
		
		JButton savebtn = new JButton("确定");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankServiceImpl bs = new BankServiceImpl();
				String n = Fname.getText();
				String id = Fid.getText();
				float m = Float.parseFloat(Fmoney.getText());
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String style = "存款";
		        bs.saveMoney(n, id, m,style,sdf2.format(date));
				
			}
		});
		savebtn.setBounds(287, 219, 103, 35);
		frame.getContentPane().add(savebtn);
	}

}
