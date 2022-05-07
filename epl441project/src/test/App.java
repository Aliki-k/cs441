package test;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
	Test1 t1;
	Test2 t2;
	CardLayout cl;
	
	public App() {
		JFrame jf=new JFrame();
		jf.setLayout(null);
		jf.setSize(600,400);
		jf.setVisible(true);
		cl=new CardLayout();
		
		JPanel jp=new JPanel();
		jp.setSize(600,400);
		jp.setLayout(cl);
		jf.add(jp);
	
		t1=new Test1(cl,jp);
		t2=new Test2(cl,jp);
		jp.add(t1,"1");
		jp.add(t2,"2");
		jf.repaint();
		jf.revalidate();
		
	}

	public static void main(String[] args) {
		new App();

	}

}
