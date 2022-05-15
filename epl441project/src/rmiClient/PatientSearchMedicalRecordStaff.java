package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rmiInterface.RmiInterface;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PatientSearchMedicalRecordStaff extends JFrame implements ActionListener{
	private Start start;
	private JTextField id;
	private JButton search,back;


	/**
	 * Create the frame.
	 * @param start 
	 */
	public PatientSearchMedicalRecordStaff(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search by");
		lblNewLabel.setBounds(33, 22, 122, 34);
		lblNewLabel.setFont(new Font("Times New Rowman",Font.BOLD,20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setBounds(33, 92, 24, 14);
		getContentPane().add(lblNewLabel_3);
		
		search = new JButton("Search");
		search.setBounds(248, 297, 100, 40);
		search.addActionListener(this);
		getContentPane().add(search);
		
		id = new JTextField();
		id.setBounds(67, 89, 86, 20);
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
			try {

				Registry registry = LocateRegistry.getRegistry();
				RmiInterface stub = (RmiInterface) registry.lookup("Server");
				String a[]=stub.patientSearch1(Integer.parseInt(id.getText()));
				if(a[0]!=null) {
					start.upi.textField.setText(a[0]);
					start.upi.textField_1.setText(a[1]);
					start.upi.textField_2.setText(a[6]);
					start.upi.textField_3.setText(a[2]);
					start.upi.textField_4.setText(a[3]);
					start.upi.textField_5.setText(a[5]);
					String temp[]=a[4].split("-");
					String bd=temp[2]+"/"+temp[1]+"/"+temp[0];
					start.upi.textField_6.setText(bd);
					start.psmrs.setVisible(false);
					start.upi.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"ID does not exists","Alert",JOptionPane.WARNING_MESSAGE); 
				}

			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} 
		}
		else {
			start.psmrs.setVisible(false);
			start.mrs.setVisible(true);
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
					s.psmrs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

