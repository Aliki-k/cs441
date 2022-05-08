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
	private JButton b1,b2;

	/**
	 * Create the frame.
	 * @param start 
	 */
	public Clinical(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		b1 = new JButton("Search a patient");
		b1.setBounds(225, 129, 135, 40);
		getContentPane().add(b1);
		
		b2 = new JButton("Search record");
		b2.setBounds(225, 180, 135, 40);
		getContentPane().add(b2);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			start.c.setVisible(false);
			start.pscs.setVisible(true);
		}
		else if(e.getSource()==b2) {
			start.c.setVisible(false);
			//start.
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
					s.c.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
