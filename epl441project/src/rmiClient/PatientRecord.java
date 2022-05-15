package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rmiInterface.RmiInterface;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class PatientRecord extends JFrame implements ActionListener{
	private Start start;
	JTextField name;
	JTextField surname;
	JTextField id;
	JTextField allergies;
	JTextArea textArea,textArea_1;
	JComboBox diagnosis;
	JComboBox medication;
	JTextArea diagnosisNotes;
	JTextArea selfHarmInfo;
	JRadioButton critical;
	private JButton update,back,sideEffects;
	

	/**
	 * Create the frame.
	 * @param start 
	 */
	public PatientRecord(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		setSize(600,500);
		setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Patient's record");
		lblNewLabel.setBounds(40, 21, 159, 35);
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(23, 80, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Surname:");
		lblNewLabel_2.setBounds(191, 80, 59, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setBounds(383, 80, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		critical = new JRadioButton("Critical patient");
		critical.setBounds(382, 31, 109, 23);
		getContentPane().add(critical);
		
		name = new JTextField();
		name.setBounds(82, 77, 86, 20);
		getContentPane().add(name);
		name.setEditable(false);
		
		surname = new JTextField();
		surname.setBounds(260, 77, 86, 20);
		surname.setEditable(false);
		getContentPane().add(surname);
	
		
		id = new JTextField();
		id.setBounds(410, 77, 86, 20);
		id.setEditable(false);
		getContentPane().add(id);
	
		
		JLabel lblNewLabel_4 = new JLabel("Allergies:");
		lblNewLabel_4.setBounds(23, 114, 59, 14);
		getContentPane().add(lblNewLabel_4);
		
		allergies = new JTextField();
		allergies.setBounds(92, 111, 145, 20);
		getContentPane().add(allergies);
		
		
		diagnosisNotes = new JTextArea();
		diagnosisNotes.setBounds(23, 207, 264, 143);
		getContentPane().add(diagnosisNotes);
		
		JLabel lblNewLabel_6 = new JLabel("Diagnosis:");
		lblNewLabel_6.setBounds(23, 154, 77, 14);
		getContentPane().add(lblNewLabel_6);
		
		selfHarmInfo = new JTextArea();
		selfHarmInfo.setBounds(297, 207, 266, 143);
		getContentPane().add(selfHarmInfo);
		
		sideEffects = new JButton("List of drugs side effects");
		sideEffects.setBounds(270, 110, 172, 23);
		getContentPane().add(sideEffects);
		
		JButton btnNewButton_1 = new JButton("Patient profile");
		btnNewButton_1.setBounds(458, 110, 115, 23);
		getContentPane().add(btnNewButton_1);
		String disorder[]= {"Depression","Bipolar disorder","OCD","Schizophrenia"};
		diagnosis = new JComboBox(disorder);
		
		diagnosis.setBounds(102, 150, 139, 22);
		getContentPane().add(diagnosis);
		
		JLabel lblNewLabel_7 = new JLabel("Medication:");
		lblNewLabel_7.setBounds(280, 154, 71, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Diagnosis Notes");
		lblNewLabel_8.setBounds(23, 191, 99, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Self harm info");
		lblNewLabel_9.setBounds(297, 191, 109, 14);
		getContentPane().add(lblNewLabel_9);
		
		update = new JButton("Update");
		update.setBounds(231, 396, 145, 35);
		update.addActionListener(this);
		getContentPane().add(update);
		
		back = new JButton("Back");
		back.setBounds(0, 427, 89, 23);
		back.addActionListener(this);
		getContentPane().add(back);
		String medicine[]= {"Celexa","Prozac","Paxil","Pristic","Cymbalta","Zanax"};
		medication = new JComboBox(medicine);
		medication.setBounds(361, 150, 159, 22);
		getContentPane().add(medication);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==update) {
			Registry registry;
			try {
				registry = LocateRegistry.getRegistry();
				RmiInterface stub = (RmiInterface) registry.lookup("Server");
				int x=stub.updatePatientRecord(Integer.parseInt(id.getText()) , allergies.getText(), diagnosisNotes.getText(), critical.isSelected(), diagnosis.getSelectedIndex(),medication.getSelectedIndex(), selfHarmInfo.getText());
				if(x==1) {
					JOptionPane.showMessageDialog(null,"Info updated successfully","",JOptionPane.DEFAULT_OPTION);
					start.pr.setVisible(false);
					start.cs.setVisible(true);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		else {
			start.pr.setVisible(false);
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
					Start s=new Start();
					s.pr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
