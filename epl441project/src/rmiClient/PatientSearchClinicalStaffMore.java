package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PatientSearchClinicalStaffMore extends JFrame implements ActionListener{
	private Start start;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;


	/**
	 * Create the frame.
	 * @param start 
	 */
	public PatientSearchClinicalStaffMore(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient's record");
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,20));
		lblNewLabel.setBounds(10, 11, 175, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(10, 70, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surname:");
		lblNewLabel_2.setBounds(203, 70, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setBounds(398, 70, 26, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Number");
		lblNewLabel_4.setBounds(10, 134, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Emergency name:");
		lblNewLabel_5.setBounds(10, 181, 109, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Emergency number:");
		lblNewLabel_6.setBounds(10, 219, 109, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Allergies");
		lblNewLabel_7.setBounds(10, 277, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Notes");
		lblNewLabel_8.setBounds(10, 397, 46, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Address");
		lblNewLabel_9.setBounds(203, 134, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Critical patient");
		rdbtnNewRadioButton.setBounds(10, 91, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		textField = new JTextField();
		textField.setBounds(48, 67, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(259, 67, 104, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(420, 67, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(62, 131, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(108, 178, 154, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(259, 131, 222, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(118, 216, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(82, 277, 194, 94);
		getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(82, 397, 194, 113);
		getContentPane().add(textArea_1);
		
		JButton btnNewButton = new JButton("Patient record");
		btnNewButton.setBounds(411, 257, 145, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Download Patient records");
		btnNewButton_1.setBounds(381, 298, 175, 30);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(21, 527, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save changes");
		btnNewButton_3.setBounds(420, 450, 120, 30);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cancel");
		btnNewButton_4.setBounds(420, 494, 117, 30);
		getContentPane().add(btnNewButton_4);
		setSize(600,600);
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
					Start s=new Start();
					s.pscsm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
