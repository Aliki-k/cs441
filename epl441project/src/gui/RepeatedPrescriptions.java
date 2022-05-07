package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class RepeatedPrescriptions extends JFrame implements ActionListener{
	private Start start;
	private JTextField textField;


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


		textField = new JTextField();
		textField.setBounds(196, 61, 86, 23);
		getContentPane().add(textField);



		JTextArea textArea = new JTextArea();
		textArea.setBounds(150, 150, 300, 130);
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(292, 61, 89, 23);
		getContentPane().add(btnNewButton);

		JButton button = new JButton("Repeat prescription");
		button.setBounds(225, 300, 150, 30);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()!=0) {
					getContentPane().add(button);
					getContentPane().add(textArea);
					repaint();
					revalidate();
				}
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
					s.rp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
