package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PatientRecord extends JFrame implements ActionListener{
	private Start start;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Create the frame.
	 * @param start 
	 */
	public PatientRecord(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		setSize(600,500);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Patient's record");
		lblNewLabel.setBounds(40, 21, 159, 35);
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(23, 80, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surname:");
		lblNewLabel_2.setBounds(191, 80, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setBounds(383, 80, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Critical patient");
		rdbtnNewRadioButton.setBounds(382, 31, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		textField = new JTextField();
		textField.setBounds(82, 77, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(260, 77, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(448, 77, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Allergies:");
		lblNewLabel_4.setBounds(23, 114, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(92, 111, 145, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 207, 264, 143);
		getContentPane().add(textArea);
		
		JLabel lblNewLabel_6 = new JLabel("Diagnosis:");
		lblNewLabel_6.setBounds(23, 154, 77, 14);
		getContentPane().add(lblNewLabel_6);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(297, 207, 266, 116);
		getContentPane().add(textArea_1);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setBounds(310, 181, 119, 14);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("List of drugs side effects");
		btnNewButton.setBounds(270, 110, 159, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Patient profile");
		btnNewButton_1.setBounds(448, 108, 115, 23);
		getContentPane().add(btnNewButton_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(102, 150, 139, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_7 = new JLabel("Next Predifined Appointment");
		lblNewLabel_7.setBounds(280, 154, 149, 14);
		getContentPane().add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(448, 151, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Diagnosis Notes");
		lblNewLabel_8.setBounds(23, 191, 99, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Present Treatment");
		lblNewLabel_9.setBounds(297, 191, 109, 14);
		getContentPane().add(lblNewLabel_9);
		
		JButton btnNewButton_2 = new JButton("History");
		btnNewButton_2.setBounds(317, 327, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Renew");
		btnNewButton_3.setBounds(456, 327, 89, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Add diagnosis");
		btnNewButton_4.setBounds(99, 395, 138, 35);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Add new treatment");
		btnNewButton_5.setBounds(346, 395, 145, 35);
		getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.setBounds(0, 427, 89, 23);
		getContentPane().add(btnNewButton_6);
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
					s.pr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
