package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;

public class ClinicalStaff extends JFrame implements ActionListener{
	private Start start;
	private JButton b1,b2;
	private JButton back;

	/**
	 * Create the frame.
	 * @param start 
	 */
	public ClinicalStaff(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		b1 = new JButton("Add new patient");
		b1.setBounds(225, 129, 135, 40);
		b1.addActionListener(this);
		getContentPane().add(b1);
		
		b2 = new JButton("Search patient");
		b2.setBounds(225, 180, 135, 40);
		b2.addActionListener(this);
		getContentPane().add(b2);
		
		back = new JButton("Back");
		back.setBounds(10, 327, 89, 23);
		back.addActionListener(this);
		getContentPane().add(back);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			start.cs.setVisible(false);
			start.ap.setVisible(true);
		}
		else if(e.getSource()==b2) {
			start.cs.setVisible(false);
			start.pscs.setVisible(true);
		}
		else {
			start.cs.setVisible(false);
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
					s.cs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
