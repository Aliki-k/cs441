package rmiClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class ListPatients extends JFrame implements ActionListener{
	private Start start;
	private JTextField textField;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 * @param start 
	 */
	public ListPatients(Start start) {
		this.start=start;
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(22, 24, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		
		btnNewButton.setBounds(122, 23, 89, 23);
		getContentPane().add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(22, 345, 552, -286);
		getContentPane().add(list);
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
