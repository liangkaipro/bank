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
public class updatePassword extends JDialog{

	private JFrame frame;
	private JTextField Fid;
	private JPasswordField Fold;
	private JPasswordField Fnew;
	private JPasswordField Fre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatePassword window = new updatePassword();
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
	public updatePassword() {
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
		id.setBounds(136, 52, 61, 27);
		frame.getContentPane().add(id);
		
		JLabel oldpass = new JLabel("旧密码");
		oldpass.setBounds(123, 91, 61, 27);
		frame.getContentPane().add(oldpass);
		
		JLabel newpass = new JLabel("新密码");
		newpass.setBounds(123, 144, 61, 27);
		frame.getContentPane().add(newpass);
		
		JLabel repass = new JLabel("重复新密码");
		repass.setBounds(92, 187, 81, 27);
		frame.getContentPane().add(repass);
		
		Fid = new JTextField();
		Fid.setBounds(185, 48, 141, 35);
		frame.getContentPane().add(Fid);
		Fid.setColumns(10);
		
		Fold = new JPasswordField();
		Fold.setBounds(185, 91, 141, 35);
		frame.getContentPane().add(Fold);
		
		Fnew = new JPasswordField();
		Fnew.setBounds(185, 140, 141, 35);
		frame.getContentPane().add(Fnew);
		
		Fre = new JPasswordField();
		Fre.setBounds(185, 183, 141, 35);
		frame.getContentPane().add(Fre);
		
		JButton updatebtn = new JButton("修改");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankServiceImpl bs = new BankServiceImpl();
				String id = Fid.getText();
				@SuppressWarnings("deprecation")
				String old = Fold.getText();
				@SuppressWarnings("deprecation")
				String n = Fnew.getText();
				@SuppressWarnings("deprecation")
				String r = Fre.getText();
			
				if(r.equals(n))
				{
					bs.updatePassword(id, old,n);
				}
				else
				{
					System.out.println("请检查输入！");
					
				}
			}
		});
		updatebtn.setBounds(340, 217, 92, 43);
		frame.getContentPane().add(updatebtn);
	}
}
