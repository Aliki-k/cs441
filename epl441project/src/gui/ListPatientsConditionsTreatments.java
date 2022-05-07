package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class ListPatientsConditionsTreatments extends JFrame implements ActionListener{
	private Start start;


	/**
	 * Create the frame.
	 */
	public ListPatientsConditionsTreatments(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
	
		String data[][]={ {"101\nfewre\nefg","Amit","670000"},    
				{"102","Jai","780000"},    
				{"101","Sachin","700000"}};    
		String column[]={"NAME","MEDICAL CONDITION","TREATMENT"};         
		JTable jt=new JTable(data,column);    
		jt.setBounds(30,40,200,300); 
		JScrollPane sp=new JScrollPane(jt);
		sp.setBounds(0, 0, 600, 400);
		
		getContentPane().add(sp);
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
					s.lp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
