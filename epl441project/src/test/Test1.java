package test;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Test1 extends JPanel implements ActionListener{
	private CardLayout cl;
	private JPanel p;
	/**
	 * Create the panel.
	 */
	public Test1(CardLayout cl,JPanel p) {
		this.cl=cl;
		this.p=p;
		setSize(600,400);
		setLayout(null);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		p.add(panel);
		
		JButton btnNewButton = new JButton("ldjaf[wjdlsf'");
		btnNewButton.setBounds(0,0,100,20);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		JLabel lblNewLabel = new JLabel("Test1");
		panel.add(lblNewLabel);
		panel.setSize(600,400);
		add(panel);

	}

	@Override

		public void actionPerformed(ActionEvent e) {
			cl.show(p, "2");
			
		}
		
	

}
