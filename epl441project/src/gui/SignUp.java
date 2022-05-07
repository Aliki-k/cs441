package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame implements ActionListener{
	private Start start;
	JButton b1,b2,b3,b4;

	

	/**
	 * Create the frame.
	 * @param start 
	 */
	public SignUp(Start start) {
		this.start=start;
		setLayout(null);
		setSize(600,400);
		
		b1=new JButton("Sign up as Clinical staff");
		b1.setBounds(150,80,300,40);
		b2=new JButton("Sign up as Receptionist");
		b2.setBounds(150,130,300,40);
		b3=new JButton("Sign up as Medical record staff");
		b3.setBounds(150,180,300,40);
		b4=new JButton("Sign up as Health service management");
		b4.setBounds(150,230,300,40);
		add(b1);add(b2);add(b3);add(b4);
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
					s.su.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
