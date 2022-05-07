package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.BoxLayout;

public class Appointments extends JFrame implements ActionListener{
	private Start start;
	private JTable table;

	/**
	 * Create the frame.
	 * @param start 
	 */
	public Appointments(Start start) {
		setSize(700,400);
		setLocationRelativeTo(null);
		//getContentPane().setLayout(null);
		String[][] data= new String[5][7];
		for(int i=0;i<5;i++) {
			for(int j=0;j<7;j++) {
				int temp=i*7+j;
				if(temp<=31)
					data[i][j]=""+temp;
				else
					data[i][j]="";
			}
		}
		
		String column[]={"SUNDAY","MONDAY","THUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 173, 0, 0);
		getContentPane().add(label);
		
		JButton btnNewButton = new JButton("Add appointment");
		btnNewButton.setBounds(277, 327, 136, 23);
		getContentPane().add(btnNewButton);
		table = new JTable(data,column);
		table.setBounds(49, 37, 480, 313);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(10, 0, 674, 294);
		getContentPane().add(jsp);
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
					s.a.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
