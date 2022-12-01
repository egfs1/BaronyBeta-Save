package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.LayoutManager;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelQuestion extends JPanel {
	  private static final long serialVersionUID = 1L;
	  
	  private PlaceholderTextField txtField;
	  
	  private JButton btn;
	  
	  private JRadioButton rdbtnSingleplayer;
	  
	  private JRadioButton rdbtnMultiplayer;
	  
	  private JLabel lblOpenFolder;
	  
	  private JLabel background;
	  
	  private JLabel lblSearchFolder;
	  
	  public PanelQuestion() {
	    setBounds(0, 0, 450, 300);
	    setLayout((LayoutManager)null);
	    URL url = getClass().getResource(Utils.backgroundLocalPath);
	    ImageIcon imgIcon = new ImageIcon(url);
	    this.background = new JLabel("", imgIcon, 0);
	    this.background.setBounds(0, 0, 450, 300);
	    JLabel lblNewLabel = new JLabel("Barony save");
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setHorizontalAlignment(0);
	    lblNewLabel.setFont(Main.font.deriveFont(40.0F));
	    lblNewLabel.setBounds(0, 11, 450, 55);
	    add(lblNewLabel);
	    this.txtField = new PlaceholderTextField();
	    this.txtField.setPlaceholder("Save number");
	    this.txtField.setForeground(Color.WHITE);
	    this.txtField.setBackground(Color.GRAY);
	    this.txtField.setHorizontalAlignment(0);
	    this.txtField.setFont(Main.font.deriveFont(25.0F));
	    this.txtField.setBounds(114, 77, 222, 35);
	    add(this.txtField);
	    this.btn = new JButton("Next");
	    this.btn.setForeground(Color.WHITE);
	    this.btn.setBackground(Color.GRAY);
	    this.btn.setFont(Main.font.deriveFont(20.0F));
	    this.btn.setBounds(44, 217, 130, 35);
	    add(this.btn);
	    ButtonGroup bGroup = new ButtonGroup();
	    this.rdbtnSingleplayer = new JRadioButton("Singleplayer");
	    this.rdbtnSingleplayer.setForeground(Color.WHITE);
	    this.rdbtnSingleplayer.setOpaque(false);
	    this.rdbtnSingleplayer.setBounds(170, 150, 166, 23);
	    this.rdbtnSingleplayer.setFont(Main.font.deriveFont(15.0F));
	    this.rdbtnSingleplayer.setSelected(true);
	    bGroup.add(this.rdbtnSingleplayer);
	    add(this.rdbtnSingleplayer);
	    this.rdbtnMultiplayer = new JRadioButton("Multiplayer");
	    this.rdbtnMultiplayer.setForeground(Color.WHITE);
	    this.rdbtnMultiplayer.setOpaque(false);
	    this.rdbtnMultiplayer.setBounds(170, 176, 166, 23);
	    this.rdbtnMultiplayer.setFont(Main.font.deriveFont(15.0F));
	    bGroup.add(this.rdbtnMultiplayer);
	    add(this.rdbtnMultiplayer);
	    this.lblOpenFolder = new JLabel("Open folder in explorer");
	    this.lblOpenFolder.setForeground(Color.WHITE);
	    this.lblOpenFolder.setCursor(Cursor.getPredefinedCursor(12));
	    this.lblOpenFolder.setFont(Main.font.deriveFont(13.0F));
	    this.lblOpenFolder.setHorizontalAlignment(0);
	    this.lblOpenFolder.setBounds(142, 114, 166, 14);
	    add(this.lblOpenFolder);
	    this.lblSearchFolder = new JLabel("Choose the Barony folder");
	    this.lblSearchFolder.setForeground(Color.WHITE);
	    this.lblSearchFolder.setCursor(Cursor.getPredefinedCursor(12));
	    this.lblSearchFolder.setFont(Main.font.deriveFont(16.0F));
	    this.lblSearchFolder.setHorizontalAlignment(0);
	    this.lblSearchFolder.setBounds(184, 221, 232, 27);
	    add(this.lblSearchFolder);
	    add(this.background);
	    setVisible(true);
	  }
	  
	  public static long getSerialversionuid() {
	    return 1L;
	  }
	  
	  public JTextField getTxtField() {
	    return this.txtField;
	  }
	  
	  public JButton getBtn() {
	    return this.btn;
	  }
	  
	  public JRadioButton getRdbtnSingleplayer() {
	    return this.rdbtnSingleplayer;
	  }
	  
	  public JRadioButton getRdbtnMultiplayer() {
	    return this.rdbtnMultiplayer;
	  }
	  
	  public JLabel getLblOpenFolder() {
	    return this.lblOpenFolder;
	  }
	  
	  public JLabel getLblSearchFolder() {
	    return this.lblSearchFolder;
	  }
}
