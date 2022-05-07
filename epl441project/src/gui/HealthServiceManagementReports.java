package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HealthServiceManagementReports extends JFrame implements ActionListener{
	private Start start;

	/**
	 * Create the frame.
	 * @param start 
	 */
	public HealthServiceManagementReports(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		JButton btnNewButton1 = new JButton("Number of patients attended each day of the week");

		btnNewButton1.setBounds(115, 11, 337, 23);
		getContentPane().add(btnNewButton1);
		
		JButton btnNewButton2 = new JButton("Total number of patients attended this week");
		btnNewButton2.setBounds(115, 45, 337, 23);
		getContentPane().add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("Number of patients sufferring from each medical condition");
		btnNewButton3.setBounds(115, 79, 337, 23);
		getContentPane().add(btnNewButton3);
		
		JButton btnNewButton4 = new JButton("Total amounts of each drug prescribed as medication");
		btnNewButton4.setBounds(115, 113, 337, 23);
		getContentPane().add(btnNewButton4);
		
		JPanel cPanel = new JPanel();  
		cPanel.setBounds(0, 150, 600, 250);
		CardLayout cl=new CardLayout();
		cPanel.setLayout(cl);
		

		
		String data1[][]=new String[1][7];  
		String column1[]={"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","SATURDAY"};         
		JTable jt1=new JTable(data1,column1);    
		String data2[][]=new String[1][1];  
		String column2[]={"TOTAL PATIENTS"};         
		JTable jt2=new JTable(data2,column2);   
		String data3[][]=new String[1][3];  
		String column3[]={"OCD","BIPOLAR DISORDER","SCHIZOPHRENIA"};
		JTable jt3=new JTable(data3,column3);
		String data4[][]=new String[1][3];  
		String column4[]={"MEDICINE1","MEDICINE2","MEDICINE3"};
		JTable jt4=new JTable(data4,column4);
		
		JScrollPane jsp1 = new JScrollPane(jt1);
		JScrollPane jsp2 = new JScrollPane(jt2);
		JScrollPane jsp3 = new JScrollPane(jt3);
		JScrollPane jsp4 = new JScrollPane(jt4);
		
		cPanel.add(jsp1, "1");
		cPanel.add(jsp2, "2");    
		cPanel.add(jsp3, "3");
		cPanel.add(jsp4, "4");  
		getContentPane().add(cPanel);
		
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(cPanel, "1");
			}
		});
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(cPanel, "2");
			}
		});
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(cPanel, "3");
			}
		});
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(cPanel, "4");
			}
		});
		
		
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
					s.hsmr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
