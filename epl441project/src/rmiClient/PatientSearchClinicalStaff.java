package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rmiInterface.RmiInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PatientSearchClinicalStaff extends JFrame implements ActionListener{
	private Start start;
	private JTextField id;
	private JButton search,back;
	/**
	 * Create the frame.
	 * @param start 
	 */
	public PatientSearchClinicalStaff(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search by");
		lblNewLabel.setBounds(33, 22, 122, 34);
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setBounds(33, 91, 27, 14);
		getContentPane().add(lblNewLabel_3);
		
		search = new JButton("Search");
		search.setBounds(245, 296, 100, 40);
		search.addActionListener(this);
		getContentPane().add(search);
		
		id = new JTextField();
		id.setBounds(70, 88, 86, 20);
		getContentPane().add(id);
		
		back = new JButton("Back");
		back.setBounds(10, 327, 89, 23);
		back.addActionListener(this);
		getContentPane().add(back);
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search) {
			Registry registry;
			try {
				Object o[];
				registry = LocateRegistry.getRegistry();
				RmiInterface stub = (RmiInterface) registry.lookup("Server");
				String s[]=stub.patientSearch1(Integer.parseInt(id.getText()));
				if(s[0]!=null) {
					
					o=stub.patientSearch2(Integer.parseInt(id.getText()));
					start.pr.name.setText((String) o[0]);
					start.pr.surname.setText((String) o[1]);
					start.pr.id.setText((String)o[2].toString());
					start.pr.allergies.setText((String) o[3]);
					start.pr.diagnosisNotes.setText((String) o[4]);
					start.pr.critical.setSelected((boolean) o[5]);
					start.pr.diagnosis.setSelectedIndex((int) o[6]);
					start.pr.medication.setSelectedIndex((int)o[7]);
					start.pr.selfHarmInfo.setText((String) o[8]);
					start.pscs.setVisible(false);
					start.pr.setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null,"Patient id doesn't exist","Alert",JOptionPane.WARNING_MESSAGE); 
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
		}
		else {
			start.pscs.setVisible(false);
			start.cs.setVisible(true);
		}
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start s =new Start();
					s.pscs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

