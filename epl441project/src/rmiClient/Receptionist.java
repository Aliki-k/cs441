package rmiClient;

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

public class Receptionist extends JFrame implements ActionListener{
	private Start start;
	private JButton b1,b2,b3,back;

	/**
	 * Create the frame.
	 * @param start 
	 */
	public Receptionist(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Reception");
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,20));
		lblNewLabel.setBounds(248, 40, 129, 26);
		getContentPane().add(lblNewLabel);

		b1 = new JButton("View appointments");
		b1.setBounds(184, 98, 214, 40);
		b1.addActionListener(this);
		getContentPane().add(b1);

		b2 = new JButton("Add new appoinrtment");
		b2.setBounds(184, 160, 214, 40);
		b2.addActionListener(this);
		getContentPane().add(b2);

		b3 = new JButton("Create repeated prescriptions");
		b3.setBounds(184, 222, 214, 40);
		b3.addActionListener(this);
		getContentPane().add(b3);
		b1.addActionListener(this);
		setSize(600,400);
		setLocationRelativeTo(null);
		back = new JButton("Back");
		back.setBounds(10, 327, 89, 23);
		back.addActionListener(this);
		getContentPane().add(back);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			start.r.setVisible(false);
			start.a.setVisible(true);
		}
		else if(e.getSource()==b2) {
			start.r.setVisible(false);
			start.aa.setVisible(true);
		}
		else if(e.getSource()==b3) {
			start.r.setVisible(false);
			start.rp.setVisible(true);
		}
		else {
			start.r.setVisible(false);
			start.sir.setVisible(true);
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
					s.r.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
