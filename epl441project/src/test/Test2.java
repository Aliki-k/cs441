package test;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test2 extends JPanel implements ActionListener{
	private CardLayout cl;
	private JPanel p;
	/**
	 * Create the panel.
	 */
	public Test2(CardLayout cl,JPanel p) {
		this.cl=cl;
		this.p=p;
		setSize(600,400);
		setLayout(null);
		
		JPanel panel = new JPanel();
		//panel.setLayout(null);
		p.add(panel);
		JLabel lblNewLabel = new JLabel("Test2");
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0,0,100,20);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		panel.add(lblNewLabel);
		panel.setSize(600,400);
		add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cl.show(p, "1");
		
	}

}
