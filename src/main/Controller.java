package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Controller {
	  private View view;
	  
	  private PanelQuestion panelQuestion;
	  
	  private PanelFunctions panelFunctions;
	  
	  private Functions functions;
	  
	  public Controller() {
	    this.view = new View();
	    this.panelQuestion = new PanelQuestion();
	    this.panelFunctions = new PanelFunctions();
	    this.functions = new Functions();
	    this.view.setContentPane(this.panelQuestion);
	    this.panelQuestion.getBtn().addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	            String number = Controller.this.panelQuestion.getTxtField().getText().intern();
	            if (Controller.this.verify(number)) {
	              if (!Controller.this.functions.verifyFolderPath())
	                return; 
	              Utils.saveNumber = number;
	              if (Controller.this.panelQuestion.getRdbtnMultiplayer().isSelected()) {
	                Utils.isMultiplayer = true;
	                Controller.this.panelFunctions.getLblGameMode().setText("Multiplayer");
	              } else {
	                Utils.isMultiplayer = false;
	                Controller.this.panelFunctions.getLblGameMode().setText("Singleplayer");
	              } 
	              Controller.this.panelFunctions.getLblSave().setText("Currently save: " + number);
	              Controller.this.view.setContentPane(Controller.this.panelFunctions);
	              System.gc();
	            } 
	          }
	        });
	    this.panelQuestion.getLblOpenFolder().addMouseListener(new MouseAdapter() {
	          public void mouseClicked(MouseEvent e) {
	            try {
	              Controller.this.functions.openFolder();
	            } catch (IOException iOException) {}
	          }
	        });
	    this.panelQuestion.getLblSearchFolder().addMouseListener(new MouseAdapter() {
	          public void mouseClicked(MouseEvent e) {
	            try {
	              Controller.this.functions.folderChooser();
	            } catch (IOException e1) {
	              e1.printStackTrace();
	            } 
	          }
	        });
	    this.panelFunctions.getBtnBack().addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	            Controller.this.view.setContentPane(Controller.this.panelQuestion);
	            Utils.saveNumber = "";
	            System.gc();
	          }
	        });
	    this.panelFunctions.getBtnSave().addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	            try {
	              Controller.this.functions.save(Utils.saveNumber);
	            } catch (IOException iOException) {}
	          }
	        });
	    this.panelFunctions.getBtnRestore().addActionListener(new ActionListener() {
	          public void actionPerformed(ActionEvent e) {
	            try {
	              Controller.this.functions.restore(Utils.saveNumber);
	            } catch (IOException iOException) {}
	          }
	        });
	  }
	  
	  private boolean verify(String number) {
	    if (number.isBlank())
	      return false; 
	    try {
	      Integer.parseInt(number);
	      return true;
	    } catch (Exception e) {
	      return false;
	    } 
	  }
}
