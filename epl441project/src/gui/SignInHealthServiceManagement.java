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

public class SignInHealthServiceManagement extends JFrame implements ActionListener{
	private Start start;
	private JPasswordField passwordField;


	/**
	 * Create the frame.
	 * @param start 
	 */
	public SignInHealthServiceManagement(Start start) {
		getContentPane().setLayout(null);
		setSize(600,400);
		setLocationRelativeTo(null);
		JLabel l=new JLabel("Sign in");
		l.setBounds(250,20,100,100);
		l.setFont(new Font("Times New Rowman",Font.BOLD,30));
		JTextField name=new JTextField();
		name.setBounds(200, 139, 200, 20);
		
		JButton b=new JButton("Sign in as Health service management");
		b.setBounds(172, 226, 261, 50);
		getContentPane().add(name);getContentPane().add(l);getContentPane().add(b);
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(200, 114, 72, 14);
		getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(200, 170, 61, 14);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 186, 200, 20);
		getContentPane().add(passwordField);
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
					s.sihsm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}