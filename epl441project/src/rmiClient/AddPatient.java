package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rmiInterface.RmiInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddPatient extends JFrame implements ActionListener{
	private Start start;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton save,clear,back;




	/**
	 * Create the frame.
	 */
	public AddPatient(Start start) {
		this.start=start;
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Patient Information");
		lblNewLabel.setBounds(152, 25, 314, 41);
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,30));
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(36, 117, 46, 14);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(92, 114, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(274, 114, 100, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Surname:");
		lblNewLabel_2.setBounds(208, 117, 57, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setBounds(394, 117, 25, 14);
		getContentPane().add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(424, 114, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Telephone:");
		lblNewLabel_4.setBounds(36, 175, 76, 14);
		getContentPane().add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setBounds(107, 172, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Address:");
		lblNewLabel_5.setBounds(231, 175, 57, 14);
		getContentPane().add(lblNewLabel_5);

		textField_4 = new JTextField();
		textField_4.setBounds(298, 172, 237, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		save = new JButton("Save");
		save.setBounds(435, 320, 100, 30);
		save.addActionListener(this);
		getContentPane().add(save);

		clear = new JButton("Clear");
		clear.setBounds(330, 320, 100, 30);
		clear.addActionListener(this);
		getContentPane().add(clear);

		back = new JButton("Back");
		back.setBounds(10, 327, 89, 23);
		back.addActionListener(this);
		getContentPane().add(back);

		JLabel lblNewLabel_6 = new JLabel("Allergies:");
		lblNewLabel_6.setBounds(247, 234, 63, 14);
		getContentPane().add(lblNewLabel_6);
		textField_5 = new JTextField();
		textField_5.setBounds(329, 231, 181, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Birthday:");
		lblNewLabel_7.setBounds(36, 234, 63, 14);
		getContentPane().add(lblNewLabel_7);
		textField_6 = new JTextField();
		textField_6.setBounds(107, 231, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==save) {
			Registry registry;
			try {
				registry = LocateRegistry.getRegistry();
				RmiInterface stub = (RmiInterface) registry.lookup("Server");
				boolean b=stub.addPatient(textField.getText(),textField_1.getText(),Integer.parseInt(textField_2.getText()),Integer.parseInt(textField_3.getText()),textField_6.getText(),textField_4.getText(),textField_5.getText());
				if(!b) {
					JOptionPane.showMessageDialog(null,"You added the patient","",JOptionPane.DEFAULT_OPTION);
					start.ap.setVisible(false);
					start.pr.setVisible(true);
					start.pr.name.setText(textField.getText());
					start.pr.surname.setText(textField_1.getText());
					start.pr.id.setText(textField_2.getText());
					start.pr.allergies.setText(textField_5.getText());
				}
				else {
					JOptionPane.showMessageDialog(null,"ID exists","Alert",JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==clear) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
		}
		else {
			start.ap.setVisible(false);
			start.sics.setVisible(true);
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
					s.ap.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
