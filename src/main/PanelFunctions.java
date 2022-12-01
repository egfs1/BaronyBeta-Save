package main;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.SystemColor;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelFunctions extends JPanel {
	  private static final long serialVersionUID = 1L;
	  
	  private JButton btnSave;
	  
	  private JButton btnBack;
	  
	  private JButton btnRestore;
	  
	  private JLabel lblSave;
	  
	  private JLabel lblGameMode;
	  
	  private JLabel background;
	  
	  public PanelFunctions() {
	    setBackground(SystemColor.controlDkShadow);
	    setBounds(0, 0, 450, 300);
	    setLayout((LayoutManager)null);
	    URL url = getClass().getResource(Utils.backgroundLocalPath);
	    ImageIcon imgIcon = new ImageIcon(url);
	    this.background = new JLabel("", imgIcon, 0);
	    this.background.setBounds(0, 0, 450, 300);
	    this.btnSave = new JButton("Save");
	    this.btnSave.setForeground(Color.WHITE);
	    this.btnSave.setBackground(Color.GRAY);
	    this.btnSave.setFont(Main.font.deriveFont(30.0F));
	    this.btnSave.setBounds(30, 107, 178, 61);
	    add(this.btnSave);
	    this.btnBack = new JButton("Back");
	    this.btnBack.setForeground(Color.WHITE);
	    this.btnBack.setBackground(Color.GRAY);
	    this.btnBack.setFont(Main.font.deriveFont(20.0F));
	    this.btnBack.setBounds(160, 213, 130, 35);
	    add(this.btnBack);
	    this.btnRestore = new JButton("Restore");
	    this.btnRestore.setForeground(Color.WHITE);
	    this.btnRestore.setBackground(Color.GRAY);
	    this.btnRestore.setFont(Main.font.deriveFont(30.0F));
	    this.btnRestore.setBounds(242, 107, 178, 61);
	    add(this.btnRestore);
	    this.lblSave = new JLabel("Currently save: " + Utils.saveNumber);
	    this.lblSave.setForeground(Color.WHITE);
	    this.lblSave.setHorizontalAlignment(0);
	    this.lblSave.setFont(Main.font.deriveFont(35.0F));
	    this.lblSave.setBounds(0, 6, 450, 51);
	    add(this.lblSave);
	    this.lblGameMode = new JLabel("");
	    this.lblGameMode.setForeground(Color.WHITE);
	    this.lblGameMode.setHorizontalAlignment(0);
	    this.lblGameMode.setFont(Main.font.deriveFont(25.0F));
	    this.lblGameMode.setBounds(0, 55, 450, 35);
	    add(this.lblGameMode);
	    add(this.background);
	    setVisible(true);
	  }
	  
	  public static long getSerialversionuid() {
	    return 1L;
	  }
	  
	  public JButton getBtnSave() {
	    return this.btnSave;
	  }
	  
	  public JButton getBtnBack() {
	    return this.btnBack;
	  }
	  
	  public JButton getBtnRestore() {
	    return this.btnRestore;
	  }
	  
	  public JLabel getLblSave() {
	    return this.lblSave;
	  }
	  
	  public JLabel getLblGameMode() {
	    return this.lblGameMode;
	  }
}
