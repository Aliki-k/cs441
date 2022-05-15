package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MedicalRecordStaff extends JFrame implements ActionListener{
	private Start start;
	private JButton b1,b2,back;

	public MedicalRecordStaff(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		b1 = new JButton("Mofify patient info");
		b1.setBounds(190, 129, 194, 40);
		b1.addActionListener(this);
		getContentPane().add(b1);
		
		b2 = new JButton("Record of transactions");
		b2.setBounds(190, 180, 194, 40);
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
			start.mrs.setVisible(false);
			start.psmrs.setVisible(true);
		}
		else if(e.getSource()==b2) {
			
		}
		else {
			start.mrs.setVisible(false);
			start.simrs.setVisible(true);
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start s=new Start();
					s.mrs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */


}
