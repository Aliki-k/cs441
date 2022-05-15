package rmiClient;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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
	JButton btnNewButton1,btnNewButton2,btnNewButton3,btnNewButton4;
	CardLayout cl;
	JPanel cPanel;
	/**
	 * Create the frame.
	 * @param start 
	 */
	public HealthServiceManagementReports(Start start) {
		this.start=start;
		getContentPane().setLayout(null);

		btnNewButton1 = new JButton("Number of patients attended each day of the week");

		btnNewButton1.setBounds(125, 11, 337, 23);
		getContentPane().add(btnNewButton1);

		btnNewButton2 = new JButton("Total number of patients attended this week");
		btnNewButton2.setBounds(125, 45, 337, 23);
		getContentPane().add(btnNewButton2);

		btnNewButton3 = new JButton("Number of patients sufferring from each medical condition");
		btnNewButton3.setBounds(125, 79, 337, 23);
		getContentPane().add(btnNewButton3);

		btnNewButton4 = new JButton("Total amounts of each drug prescribed as medication");
		btnNewButton4.setBounds(125, 113, 337, 23);
		getContentPane().add(btnNewButton4);

		cPanel = new JPanel();  
		cPanel.setBounds(0, 150, 600, 250);
		cl=new CardLayout();
		cPanel.setLayout(cl);

		DateTimeFormatter format =
				DateTimeFormatter.ofPattern("dd/MM/yyy");

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime minus1 = now.minusDays(1);
		LocalDateTime minus2 = now.minusDays(2);
		LocalDateTime minus3 = now.minusDays(3);
		LocalDateTime minus4 = now.minusDays(4);
		LocalDateTime minus5 = now.minusDays(5);
		LocalDateTime minus6 = now.minusDays(6);
		LocalDateTime minus7 = now.minusDays(7);


		System.out.println(now);

		String data1[][]=new String[1][7];  
		String column1[]={minus7.format(format),minus6.format(format),minus5.format(format),minus4.format(format),minus3.format(format),minus2.format(format),minus1.format(format)};         
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

		btnNewButton1.addActionListener(this);
		btnNewButton2.addActionListener(this);
		btnNewButton3.addActionListener(this);
		btnNewButton4.addActionListener(this);


		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNewButton1) {
			cl.show(cPanel, "1");
		}
		else if(e.getSource()==btnNewButton2) {
			cl.show(cPanel, "2");
		}
		else if(e.getSource()==btnNewButton3) {
			cl.show(cPanel, "3");
		}
		else if(e.getSource()==btnNewButton4) {
			cl.show(cPanel, "4");
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
					s.hsmr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
