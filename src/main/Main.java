package main;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;

public class Main {
	
	public static Font font;

	public static void main(String[] args) {
		try {
	      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	    } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException classNotFoundException) {
	    	classNotFoundException.printStackTrace();
	    }
	    try {
	      font = Font.createFont(0, Main.class.getClassLoader().getResourceAsStream(Utils.fontLocalPath));
	      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	      ge.registerFont(Font.createFont(0, new File("./rsc/" + Utils.fontLocalPath)));
	    } catch (IOException|java.awt.FontFormatException iOException) {
	    	iOException.printStackTrace();
	    }
	    try {
	      Functions.createPathTxtFile();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    
	    new Controller();
	}
}
