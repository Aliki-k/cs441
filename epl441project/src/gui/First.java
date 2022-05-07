package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class First extends JFrame implements ActionListener{
	private JButton btnNewButton1,btnNewButton2;
	private Start start;
	public First(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		btnNewButton1 = new JButton("Sign in");

		btnNewButton1.setBounds(242, 131, 100,40);
		btnNewButton1.addActionListener(this);
		getContentPane().add(btnNewButton1);
		
		
		btnNewButton2 = new JButton("Sign up");
		btnNewButton2.setBounds(242, 190, 100,40);
		btnNewButton2.addActionListener(this);
		getContentPane().add(btnNewButton2);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton1) {
			start.f.setVisible(false);
			start.si.setVisible(true);

		}
		else if(e.getSource()==btnNewButton2) {
			start.f.setVisible(false);
			start.su.setVisible(true);
		}

		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start start=new Start();
					start.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
