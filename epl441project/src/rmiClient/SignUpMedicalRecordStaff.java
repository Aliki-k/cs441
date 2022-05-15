package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import rmiInterface.RmiInterface;

import javax.swing.JPasswordField;

public class SignUpMedicalRecordStaff extends JFrame implements ActionListener{
	private Start start;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton b,back;
	private JTextField t1,t2,t3,t4,t5,t6,t7;


	/**
	 * Create the frame.
	 * @param start 
	 */
	public SignUpMedicalRecordStaff(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		setSize(600,600);
		setLocationRelativeTo(null);
		JLabel l=new JLabel("Sign up");
		l.setBounds(240,0,150,50);
		l.setFont(new Font("Times New Rowman",Font.BOLD,30));
		t1=new JTextField();
		t1.setBounds(193, 75, 200, 20);
		t2=new JTextField();
		t2.setBounds(193, 115, 200, 20);
		t3=new JTextField();
		t3.setBounds(193, 155, 200, 20);
		t4=new JTextField();
		t4.setBounds(193, 195, 200, 20);
		t5=new JTextField();
		t5.setBounds(193, 235, 200, 20);
		t6=new JTextField();
		t6.setBounds(193, 275, 200, 20);
		t7=new JTextField();
		t7.setBounds(193, 315, 200, 20);

		b=new JButton("Sign up as Health service management");
		b.setBounds(163, 442, 259, 40);
		b.addActionListener(this);
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
		
		back = new JButton("Back");
		back.setBounds(10, 538, 89, 23);
		back.addActionListener(this);
		getContentPane().add(back);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b) {
			String name=t1.getText();
			String surname=t2.getText();
			String email=t3.getText();
			String telephone=t4.getText();
			String id=t5.getText();
			String address=t6.getText();
			String username=t7.getText();
			String pass1=passwordField.getText();
			String pass2=passwordField_1.getText();

			if(name.length()==0||surname.length()==0||email.length()==0||telephone.length()==0||id.length()==0||address.length()==0||username.length()==0||pass1.length()==0||pass2.length()==0) 
				JOptionPane.showMessageDialog(null,"Fill all the fields","Alert",JOptionPane.WARNING_MESSAGE); 
				
			else if(!pass1.equals(pass2))
				JOptionPane.showMessageDialog(null,"Password missmatch","Alert",JOptionPane.WARNING_MESSAGE);
			else {
				try {
					System.out.println("Client");
					Registry registry = LocateRegistry.getRegistry();
					RmiInterface stub = (RmiInterface) registry.lookup("Server");
				
					boolean b=stub.signUp(Integer.parseInt(id), name, surname, Integer.parseInt(telephone), email, username, pass1, address, 3);
					if(b)
						JOptionPane.showMessageDialog(null,"ID or username exists","Alert",JOptionPane.WARNING_MESSAGE);
					else {
						JOptionPane.showMessageDialog(null,"You are registered","",JOptionPane.DEFAULT_OPTION);
						start.suhsm.setVisible(false);
						start.sihsm.setVisible(true);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					e1.printStackTrace();
				}
			}

		}
		else if (e.getSource()==back){
			start.suhsm.setVisible(false);
			start.su.setVisible(true);
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
					s.sumrs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
