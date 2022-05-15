package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import rmiInterface.RmiInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class RepeatedPrescriptions extends JFrame implements ActionListener{
	private Start start;
	private JTextField textField;
	private JButton search;
	private JTextField s;
	private JButton rep;
	private boolean b=false;
	private JButton back;
	/**
	 * Create the frame.
	 * @param start 
	 */
	public RepeatedPrescriptions(Start start) {
		this.start=start;
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Add patient's ID to see his prescription");
		lblNewLabel.setBounds(186, 36, 224, 14);
		getContentPane().add(lblNewLabel);


		s = new JTextField();
		s.setBounds(196, 61, 86, 23);
		getContentPane().add(s);


		search = new JButton("Search");
		search.setBounds(292, 61, 89, 23);
		search.addActionListener(this);
		getContentPane().add(search);
		
		back = new JButton("Back");
		back.setBounds(10, 327, 89, 23);
		back.addActionListener(this);
		getContentPane().add(back);

		rep = new JButton("Repeat prescription");
		rep.setBounds(216, 314, 185, 36);
		rep.addActionListener(this);
		

		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==search) {
			if(s.getText().length()!=0) {
				Registry registry;
				b=false;
				try {
					registry = LocateRegistry.getRegistry();
					RmiInterface stub = (RmiInterface) registry.lookup("Server");
					String temp1[]=stub.searchMedication(Integer.parseInt(s.getText()));	
					if(temp1[0]!=null) 
						b=true;
					if(b) {
						String temp2[][]= new String[1][3];
						temp2[0][0]=temp1[0];
						temp2[0][1]=temp1[1]+" "+temp1[2];
						temp2[0][2]=temp1[3];
						String column[]= {"Patient ID","Patient name","Medication"};
						JTable medication = new JTable(temp2,column);
						JScrollPane pane = new JScrollPane(medication);
						pane.setBounds(0, 180, 584, 100);
						getContentPane().add(pane);
						getContentPane().add(rep);
						repaint();
						revalidate();
					}
					else {
						JOptionPane.showMessageDialog(null,"ID does not exist","Alert",JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} 

			}
		}
		else if(e.getSource()==rep&& b) {
			JOptionPane.showMessageDialog(null,"Prescription repeated","",JOptionPane.DEFAULT_OPTION);
		}
		else {
			start.rp.setVisible(false);
			start.r.setVisible(true);
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
					s.rp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
