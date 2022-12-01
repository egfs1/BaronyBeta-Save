package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;
import javax.swing.text.Document;

public class PlaceholderTextField extends JTextField {
	  private static final long serialVersionUID = 1L;
	  
	  private String placeholder;
	  
	  public PlaceholderTextField() {}
	  
	  public PlaceholderTextField(Document pDoc, String pText, int pColumns) {
	    super(pDoc, pText, pColumns);
	  }
	  
	  public PlaceholderTextField(int pColumns) {
	    super(pColumns);
	  }
	  
	  public PlaceholderTextField(String pText) {
	    super(pText);
	  }
	  
	  public PlaceholderTextField(String pText, int pColumns) {
	    super(pText, pColumns);
	  }
	  
	  public String getPlaceholder() {
	    return this.placeholder;
	  }
	  
	  protected void paintComponent(Graphics pG) {
	    super.paintComponent(pG);
	    if (this.placeholder == null || this.placeholder.length() == 0 || getText().length() > 0)
	      return; 
	    Graphics2D g = (Graphics2D)pG;
	    g.setColor(Color.lightGray);
	    g.drawString(this.placeholder, getWidth() / 4 - (getInsets()).right, pG.getFontMetrics()
	        .getMaxAscent() + (getInsets()).right - 2);
	  }
	  
	  public void setPlaceholder(String s) {
	    this.placeholder = s;
	  }
}
