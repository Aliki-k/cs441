package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class IndividualAppointments extends JFrame implements ActionListener{
	private Start start;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param start 
	 */
	public IndividualAppointments(Start start) {
		this.start=start;
		getContentPane().setLayout(null);		
		
        final DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("Ckati");  
        l1.addElement("C++");  
        l1.addElement("Java");  
        l1.addElement("PHP");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText("kati neo");
		lblNewLabel.setBounds(264, 19, 80, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Past Appointments");
		btnNewButton.setBounds(39, 67, 147, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Upcomming Appointments");
		btnNewButton_1.setBounds(196, 67, 221, 30);
		getContentPane().add(btnNewButton_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(292, 240, 292, 120);
		getContentPane().add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(264, 44, 80, 14);
		getContentPane().add(lblNewLabel_1);
		JPanel panel=new JPanel();
		
		panel.setBounds(0, 108, 584, 252);
		setSize(600,400);
		setLocationRelativeTo(null);
		JTextArea a[]=new JTextArea[5];
		int x=200;
		for(int i=0;i<5;i++) {
			a[i]=new JTextArea();
			a[i].setEditable(false);
			a[i].setBounds(0, x,500 , 100);			
			panel.add(a[i]);
			x=x+105;
			
		}
		
        JScrollPane scrollBar = new JScrollPane(panel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollBar.setBounds(0, 108, 584, 252);
		getContentPane().add(scrollBar);
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
					s.ia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
