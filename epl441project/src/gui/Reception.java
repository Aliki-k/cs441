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

public class Reception extends JFrame implements ActionListener{
	private Start start;
	

	/**
	 * Create the frame.
	 * @param start 
	 */
	public Reception(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reception");
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,20));
		lblNewLabel.setBounds(248, 40, 129, 26);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Appointments");
		btnNewButton.setBounds(210, 98, 177, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search patient");
		btnNewButton_1.setBounds(210, 160, 177, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Create repeated prescriptions");
		btnNewButton_2.setBounds(210, 222, 177, 40);
		getContentPane().add(btnNewButton_2);
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
					s.r.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
