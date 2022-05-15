package rmiClient;

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
	private JButton b1,b2,b3,b4,back;




	/**
	 * Create the frame.
	 * @param start 
	 */
	public SignUp(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		setSize(600,400);
		setLocationRelativeTo(null);
		b1=new JButton("Sign up as Clinical staff");
		b1.setBounds(150,80,300,40);
		b1.addActionListener(this);
		b2=new JButton("Sign up as Receptionist");
		b2.setBounds(150,130,300,40);
		b2.addActionListener(this);
		b3=new JButton("Sign up as Medical record staff");
		b3.setBounds(150,180,300,40);
		b3.addActionListener(this);
		b4=new JButton("Sign up as Health service management");
		b4.setBounds(150,230,300,40);
		b4.addActionListener(this);
		getContentPane().add(b1);getContentPane().add(b2);getContentPane().add(b3);getContentPane().add(b4);
		back = new JButton("Back");
		back.setBounds(10, 327, 89, 23);
		back.addActionListener(this);
		getContentPane().add(back);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			start.su.setVisible(false);
			start.sucs.setVisible(true);
		}
		else if(e.getSource()==b2) {
			start.su.setVisible(false);
			start.sur.setVisible(true);
		}
		else if(e.getSource()==b3) {
			start.su.setVisible(false);
			start.sumrs.setVisible(true);
		}
		else if(e.getSource()==b4) {
			start.su.setVisible(false);
			start.suhsm.setVisible(true);
		}
		else if(e.getSource()==back) {
			start.su.setVisible(false);
			start.f.setVisible(true);
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
					s.su.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
