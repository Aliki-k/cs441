package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EventListener;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import rmiInterface.RmiInterface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;

public class Appointments extends JFrame implements ActionListener{
	private Start start;
	private JTable table;
	DefaultTableModel model;
	String monthS;
	int day,month,year;
	JTable appointments;
	int appID[];


	Calendar cal = new GregorianCalendar();
	JLabel label;
	private JButton back;
	private JButton attended;
	/**
	 * Create the frame.
	 * @param start 
	 */

	public Appointments(Start start) {
		setSize(600,400);
		setLocationRelativeTo(null);
		this.start=start;
		getContentPane().setLayout(null);
		
		SwingCalendar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}

	public void SwingCalendar() {
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(235, 16, 116, 20);

		JButton b1 = new JButton("<-");
		b1.setBounds(180,11,45,30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, -1);
				updateMonth();
			}
		});
		JButton b2 = new JButton("->");
		b2.setBounds(361,11,45,30);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cal.add(Calendar.MONTH, +1);
				updateMonth();
			}
		});
		getContentPane().add(b1);
		getContentPane().add(b2);
		getContentPane().add(label);


		String [] columns = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		model = new DefaultTableModel(null,columns);
		JTable table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 50, 584, 120);


		getContentPane().add(pane);

		back = new JButton("Back");
		back.setBounds(10, 327, 89, 23);
		back.addActionListener(this);
		getContentPane().add(back);

	

		updateMonth();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				int col = table.columnAtPoint(evt.getPoint());
				day=(int) table.getValueAt(row, col);
				month=0;

				switch(monthS){
				case "January":
					month=1;
					break;
				case "February":
					month=2;
					break;
				case "March":
					month=3;
					break;
				case "April":
					month=4;
					break;
				case "May":
					month=5;
					break;
				case "June":
					month=6;
					break;
				case "July":
					month=7;
					break;
				case "August":
					month=8;
					break;
				case "September":
					month=9;
					break;
				case "October":
					month=10;
					break;
				case "November":
					month=11;
					break;
				case "December":
					month=12;
					break;
				}
				try {
					Registry registry = LocateRegistry.getRegistry();
					RmiInterface stub = (RmiInterface) registry.lookup("Server");
					ArrayList<Object> al=stub.viewAppointments(day,month,year,start.sir.clinicID);
					String s[][]=new String[al.size()/7][5];
					appID =new int[al.size()/7];
					for(int i=0;i<al.size()/7;i++) {
						appID[i]=(int) al.get(i*7);
						s[i][0]=al.get(i*7+4)+" "+al.get(i*7+5);
						s[i][1]=""+al.get(i*7+6);
						s[i][2]=""+al.get(i*7+1);
						s[i][3]=""+al.get(i*7+2);	
						s[i][4]=""+al.get(i*7+3);
					}

					String column[]= {"Patient name","Doctor name","Date","Time","Attended"};
					appointments = new JTable(s,column);
					appointments.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent evt) {
							int row = table.rowAtPoint(evt.getPoint());
							int col = table.columnAtPoint(evt.getPoint());
							int point=(int) table.getValueAt(row, col);
							if(col==4) {
								Registry registry;
								try {
									registry = LocateRegistry.getRegistry();
									RmiInterface stub = (RmiInterface) registry.lookup("Server");
									stub.attendAppointment(appID[col]);			
								} catch (Exception ex) {
									// TODO Auto-generated catch block
									ex.printStackTrace();
								} 
							}
						}
					});
					JScrollPane pane = new JScrollPane(appointments);
					pane.setBounds(0, 180, 584, 200);
					getContentPane().add(pane);

				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} 
			}
		});

	}

	void updateMonth() {
		cal.set(Calendar.DAY_OF_MONTH, 1);

		monthS = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		year = cal.get(Calendar.YEAR);
		label.setText(monthS + " " + year);
		int startDay = cal.get(Calendar.DAY_OF_WEEK);
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);

		model.setRowCount(0);
		model.setRowCount(weeks);

		int i = startDay-1;
		for(int day=1;day<=numberOfDays;day++){
			model.setValueAt(day, i/7 , i%7 );    
			i = i + 1;
		}

	}



	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			start.a.setVisible(false);
			start.r.setVisible(true);
		}
	}



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
