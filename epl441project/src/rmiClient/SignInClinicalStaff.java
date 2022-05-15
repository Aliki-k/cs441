package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import rmiInterface.RmiInterface;

import javax.swing.JPasswordField;

public class SignInClinicalStaff extends JFrame implements ActionListener{
	private Start start;
	private JPasswordField passwordField;
	private JButton b;
	private JTextField username;
	private JButton back;
	/**
	 * Create the frame.
	 * @param start 
	 */
	public SignInClinicalStaff(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		setSize(600,400);
		setLocationRelativeTo(null);
		JLabel l=new JLabel("Sign in");
		l.setBounds(250,20,100,100);
		l.setFont(new Font("Times New Rowman",Font.BOLD,30));
		username=new JTextField();
		username.setBounds(200, 139, 200, 20);

		b=new JButton("Sign in as Clinical staff");
		b.setBounds(200, 221, 200, 50);
		b.addActionListener(this);
		getContentPane().add(username);getContentPane().add(l);getContentPane().add(b);
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(200, 114, 72, 14);
		getContentPane().add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(200, 170, 61, 14);
		getContentPane().add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(200, 186, 200, 20);
		getContentPane().add(passwordField);

		back = new JButton("Back");
		back.setBounds(10, 327, 89, 23);
		back.addActionListener(this);
		getContentPane().add(back);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b) {
			try {

				Registry registry = LocateRegistry.getRegistry();
				RmiInterface stub = (RmiInterface) registry.lookup("Server");
				int a[]=stub.signIn(username.getText(), passwordField.getText(), 1);
				if(a[0]==1) {
					start.sics.setVisible(false);
					start.cs.setVisible(true);
					
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Wrong credentials","Alert",JOptionPane.WARNING_MESSAGE); 
				}

			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} 

		}
		else if(e.getSource()==back) {
			start.sics.setVisible(false);
			start.si.setVisible(true);

		}

	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start s=new Start();
					s.sics.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}