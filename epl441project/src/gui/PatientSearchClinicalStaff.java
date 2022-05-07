package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PatientSearchClinicalStaff extends JFrame implements ActionListener{
	private Start start;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;

	/**
	 * Create the frame.
	 * @param start 
	 */
	public PatientSearchClinicalStaff(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search by");
		lblNewLabel.setBounds(33, 22, 122, 34);
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(33, 91, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surname:");
		lblNewLabel_2.setBounds(180, 91, 63, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setBounds(375, 91, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setBounds(180, 297, 100, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(292, 297, 100, 40);
		getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(78, 88, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(253, 88, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(396, 88, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		setSize(600,400);
		setLocationRelativeTo(null);
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
					Start s =new Start();
					s.pscs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

