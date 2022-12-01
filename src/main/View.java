package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPanel;
	
	public View() {
		setTitle("Barone salvamentos");
	    setDefaultCloseOperation(3);
	    setSize(450, 300);
	    this.contentPanel = new JPanel();
	    setResizable(false);
	    setLocationRelativeTo(null);
	    setContentPane(this.contentPanel);
	    setVisible(true);
	}

}
