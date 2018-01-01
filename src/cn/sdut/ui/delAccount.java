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
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class delAccount extends JDialog{

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
					delAccount window = new delAccount();
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
	public delAccount() {
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
		id.setBounds(90, 79, 61, 27);
		frame.getContentPane().add(id);
		
		JLabel pass = new JLabel("密码");
		pass.setBounds(90, 133, 61, 27);
		frame.getContentPane().add(pass);
		
		Fid = new JTextField();
		Fid.setBounds(166, 79, 143, 36);
		frame.getContentPane().add(Fid);
		Fid.setColumns(10);
		
		Fpass = new JPasswordField();
		Fpass.setBounds(165, 126, 143, 36);
		frame.getContentPane().add(Fpass);
		
		JButton delbtn = new JButton("销户");
		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankServiceImpl bs = new BankServiceImpl();
				String id = Fid.getText();
				@SuppressWarnings("deprecation")
				String p = Fpass.getText();
		        bs.delAccout(id, p);
			}
		});
		delbtn.setBounds(315, 199, 87, 36);
		frame.getContentPane().add(delbtn);
	}

}
