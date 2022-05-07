package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Clinical extends JFrame implements ActionListener{
	private Start start;


	/**
	 * Create the frame.
	 * @param start 
	 */
	public Clinical(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Search a patient");
		btnNewButton.setBounds(225, 129, 120, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search record");
		btnNewButton_1.setBounds(225, 180, 120, 40);
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
					s.c.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
