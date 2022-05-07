package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class SignUpHealthServiceManagement extends JFrame implements ActionListener{
	private Start start;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;


	/**
	 * Create the frame.
	 * @param start 
	 */
	public SignUpHealthServiceManagement(Start start) {
		getContentPane().setLayout(null);
		setSize(600,600);
		setLocationRelativeTo(null);
		JLabel l=new JLabel("Sign up");
		l.setBounds(240,0,150,50);
		l.setFont(new Font("Times New Rowman",Font.BOLD,30));
		JTextField t1=new JTextField();
		t1.setBounds(193, 75, 200, 20);
		JTextField t2=new JTextField();
		t2.setBounds(193, 115, 200, 20);
		JTextField t3=new JTextField();
		t3.setBounds(193, 155, 200, 20);
		JTextField t4=new JTextField();
		t4.setBounds(193, 195, 200, 20);
		JTextField t5=new JTextField();
		t5.setBounds(193, 235, 200, 20);
		JTextField t6=new JTextField();
		t6.setBounds(193, 275, 200, 20);
		JTextField t7=new JTextField();
		t7.setBounds(193, 315, 200, 20);

		JButton b=new JButton("Sign up as Health service management");
		b.setBounds(163, 442, 259, 40);
		getContentPane().add(b);getContentPane().add(l);getContentPane().add(t1);getContentPane().add(t2);getContentPane().add(t3);getContentPane().add(t4);getContentPane().add(t5);getContentPane().add(t6);getContentPane().add(t7);
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(193, 59, 46, 14);
		getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setBounds(193, 101, 67, 14);
		getContentPane().add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(193, 154, 46, 14);
		getContentPane().add(lblNewLabel_2);
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 355, 200, 20);
		getContentPane().add(passwordField);
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(193, 395, 200, 20);
		getContentPane().add(passwordField_1);
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(193, 140, 46, 14);
		getContentPane().add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Telephone");
		lblNewLabel_4.setBounds(193, 179, 67, 14);
		getContentPane().add(lblNewLabel_4);
		JLabel lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setBounds(193, 220, 46, 14);
		getContentPane().add(lblNewLabel_5);
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setBounds(193, 261, 67, 14);
		getContentPane().add(lblNewLabel_6);
		JLabel lblNewLabel_7 = new JLabel("Username");
		lblNewLabel_7.setBounds(193, 300, 67, 14);
		getContentPane().add(lblNewLabel_7);
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setBounds(193, 340, 67, 14);
		getContentPane().add(lblNewLabel_8);
		JLabel lblNewLabel_9 = new JLabel("Confirm password");
		lblNewLabel_9.setBounds(193, 380, 120, 14);
		getContentPane().add(lblNewLabel_9);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start s=new Start();
					s.suhsm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
