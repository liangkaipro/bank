package cn.sdut.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JDialog;
import cn.sdut.aui.Main;
import java.awt.Dialog;

public class MainUI{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
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
	public MainUI() {
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
		JButton openbtn = new JButton("开户");
		openbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		   new openAccount().setVisible(true);
			
			}
		});
		openbtn.setBounds(54, 40, 69, 36);
		frame.getContentPane().add(openbtn);
		
		JButton button = new JButton("取款");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new getMoney().setVisible(true);
			}
		});
		button.setBounds(54, 97, 69, 36);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new selectRecord().setVisible(true);
			}
		});
		button_1.setBounds(54, 145, 69, 36);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("销户");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new delAccount().setVisible(true);
			}
		});
		button_2.setBounds(54, 192, 69, 36);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("存款");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new saveMoney().setVisible(true);
			}
		});
		button_3.setBounds(299, 40, 69, 36);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("转账");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new transferAccount().setVisible(true);
			}
		});
		button_4.setBounds(299, 88, 69, 36);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("修改密码");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new updatePassword().setVisible(true);
			}
		});
		button_5.setBounds(299, 145, 69, 36);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("退出");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_6.setBounds(299, 192, 69, 36);
		frame.getContentPane().add(button_6);
		
		JLabel lblNewLabel = new JLabel("       银行管理系统");
		lblNewLabel.setBounds(135, 6, 163, 36);
		frame.getContentPane().add(lblNewLabel);
	}


}
