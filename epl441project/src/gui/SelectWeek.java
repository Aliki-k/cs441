package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SelectWeek extends JFrame implements ActionListener{
	private Start start;
	private JTextField textField;

	/**
	 * Create the frame.
	 * @param start 
	 */
	public SelectWeek(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(44, 95, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Select start date");
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,20));
		lblNewLabel.setBounds(44, 25, 172, 42);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(191, 266, 100, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(304, 266, 100, 40);
		getContentPane().add(btnNewButton_1);
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
					Start s=new Start();
					s.sw.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
