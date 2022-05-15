package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class HealthServiceManagement extends JFrame implements ActionListener{
	private Start start;
	private JButton back;
	private JButton wr;
	private JButton lct;

	/**
	 * Create the frame.
	 * @param start 
	 */
	public HealthServiceManagement(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		lct = new JButton("List of patient conditions and treatment");
		lct.setBounds(180, 128, 230, 40);
		lct.addActionListener(this);
		getContentPane().add(lct);
		
		wr = new JButton("Weekly reports");
		wr.setBounds(180, 179, 230, 40);
		wr.addActionListener(this);
		getContentPane().add(wr);
		
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
		if(e.getSource()==lct) {
			start.hsm.setVisible(false);
		}
		else if(e.getSource()==wr) {
			start.hsm.setVisible(false);
		}
		else {
			start.hsm.setVisible(false);
			start.sihsm.setVisible(true);
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
					s.hsm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
