package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rmiInterface.RmiInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class AddAppointment extends JFrame implements ActionListener{
	private Start start;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton back;
	private JButton save;
	private JButton clear;

	

	/**
	 * Create the frame.
	 * @param start 
	 */
	public AddAppointment(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New appointment");
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,20));
		lblNewLabel.setBounds(210, 11, 195, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date:");
		lblNewLabel_1.setBounds(10, 56, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Time:");
		lblNewLabel_2.setBounds(10, 94, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setBounds(10, 131, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Surname:");
		lblNewLabel_4.setBounds(10, 167, 61, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("Doctor:");
		lblNewLabel_6.setBounds(10, 203, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(81, 53, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(81, 91, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 164, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(81, 128, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(78, 200, 134, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		save = new JButton("Save");
		save.setBounds(360, 316, 89, 30);
		save.addActionListener(this);
		getContentPane().add(save);
		
		clear = new JButton("Cancel");
		clear.setBounds(466, 316, 89, 30);
		clear.addActionListener(this);
		getContentPane().add(clear);
		
		back = new JButton("Back");
		back.addActionListener(this);
		back.setBounds(10, 327, 89, 23);
		getContentPane().add(back);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==save) {
			try {
				if(textField.getText().length()==0||textField_1.getText().length()==0||textField_2.getText().length()==0||textField_3.getText().length()==0||textField_4.getText().length()==0) 
					JOptionPane.showMessageDialog(null,"Fill all the fields","Alert",JOptionPane.WARNING_MESSAGE); 
				else {
				Registry registry = LocateRegistry.getRegistry();
				RmiInterface stub = (RmiInterface) registry.lookup("Server");
				stub.addAppointment(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(),start.sir.clinicID);
				JOptionPane.showMessageDialog(null,"Appointment added","Alert",JOptionPane.DEFAULT_OPTION); 
				start.aa.setVisible(false);
				start.r.setVisible(true);
				}

			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} 
		}
		else if(e.getSource()==clear) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
		}
		else {
			start.aa.setVisible(false);
			start.r.setVisible(true);
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
					s.aa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
