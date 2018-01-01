package cn.sdut.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cn.sdut.biz.impl.BankServiceImpl;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
public class selectRecord extends JDialog {

	private JFrame frame;
	private JTextField Fid;
	private JPasswordField Fpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectRecord window = new selectRecord();
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
	public selectRecord() {
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
		id.setBounds(129, 72, 61, 29);
		frame.getContentPane().add(id);
		
		JLabel pass = new JLabel("密码");
		pass.setBounds(129, 135, 61, 29);
		frame.getContentPane().add(pass);
		
		Fid = new JTextField();
		Fid.setBounds(170, 68, 145, 36);
		frame.getContentPane().add(Fid);
		Fid.setColumns(10);
		
		Fpass = new JPasswordField();
		Fpass.setBounds(170, 131, 145, 36);
		frame.getContentPane().add(Fpass);
		
		JButton selectbtn = new JButton("查询");
		selectbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankServiceImpl bs = new BankServiceImpl();
				String id = Fid.getText();
				@SuppressWarnings("deprecation")
				String p = Fpass.getText();
				 bs.selectAccount(id, p);
				 bs.selectRecord(id);
			}
		});
		selectbtn.setBounds(324, 195, 82, 42);
		frame.getContentPane().add(selectbtn);
	}
}
