package main;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Functions {
	  private File savegamesFolder;
	  
	  private File backupFolder;
	  
	  private String date;
	  
	  public Functions() {
	    this.savegamesFolder = new File(Utils.savegamesFolderPath);
	    this.backupFolder = new File(Utils.backupFolderPath);
	  }
	  
	  public static void createPathTxtFile() throws IOException {
	    File f = new File(Utils.txtFilePath);
	    if (f.createNewFile()) {
	      FileWriter fileWriter = new FileWriter(f);
	      fileWriter.write(Utils.baronyStandardFolderPath);
	      fileWriter.close();
	    } 
	    String path = new String(Files.readAllBytes(f.toPath()));
	    Utils.baronyFolderPath = path;
	    Utils.savegamesFolderPath = String.valueOf(Utils.baronyFolderPath) + "/savegames";
	    Utils.backupFolderPath = String.valueOf(Utils.baronyFolderPath) + "/savegames/backup";
	  }
	  
	  private void updatePathTxtFile() throws IOException {
	    File f = new File(Utils.txtFilePath);
	    FileWriter fileWriter = new FileWriter(f);
	    fileWriter.write(Utils.baronyFolderPath);
	    fileWriter.close();
	  }
	  
	  public void save(final String number) throws IOException {
	    File files[], newFolder;
	    this.date = DateFormat.getDateFormat();
	    if (Utils.isMultiplayer) {
	      files = this.savegamesFolder.listFiles(new FilenameFilter() {
	            public boolean accept(File dir, String name) {
	              return (name.startsWith("savegame" + number + Utils.fileMultiPlayerComplement) && name.endsWith("baronysave"));
	            }
	          });
	      if (files.length == 0)
	        return; 
	      this.backupFolder.mkdir();
	      newFolder = new File(String.valueOf(Utils.backupFolderPath) + "/savegame" + number + " " + Utils.folderMultiplayerComplement + " " + this.date);
	      newFolder.mkdir();
	    } else {
	      files = this.savegamesFolder.listFiles(new FilenameFilter() {
	            public boolean accept(File dir, String name) {
	              return (name.startsWith("savegame" + number) && name.endsWith("dat") && !name.contains("mp"));
	            }
	          });
	      if (files.length == 0)
	        return; 
	      this.backupFolder.mkdir();
	      newFolder = new File(String.valueOf(Utils.backupFolderPath) + "/savegame" + number + " " + Utils.folderSingleplayerComplement + " " + this.date);
	      newFolder.mkdir();
	    } 
	    for (int i = 0; i < files.length; i++) {
	      File newFile = new File(newFolder.toPath() + "/" + files[i].getName());
	      Files.copy(files[i].toPath(), newFile.toPath(), new java.nio.file.CopyOption[0]);
	    } 
	  }
	  
	  public void restore(final String number) throws IOException {
	    File[] folders = this.backupFolder.listFiles(new FilenameFilter() {
	          public boolean accept(File dir, String name) {
	            if (Utils.isMultiplayer)
	              return name.startsWith("savegame" + number + " " + Utils.folderMultiplayerComplement); 
	            return name.startsWith("savegame" + number + " " + Utils.folderSingleplayerComplement);
	          }
	        });
	    if (folders.length == 0)
	      return; 
	    Arrays.sort(folders, new Comparator<File>() {
	          public int compare(File f1, File f2) {
	            return Long.valueOf(f1.lastModified()).compareTo(Long.valueOf(f2.lastModified()));
	          }
	        });
	    File folder = folders[folders.length - 1];
	    File[] files = folder.listFiles();
	    for (int i = 0; i < files.length; i++) {
	      File newFile = new File(this.savegamesFolder.toPath() + "/" + files[i].getName());
	      if (!newFile.exists())
	        Files.copy(files[i].toPath(), newFile.toPath(), new java.nio.file.CopyOption[0]); 
	    } 
	  }
	  
	  public void openFolder() throws IOException {
	    if (verifyFolderPath())
	      Desktop.getDesktop().open(this.savegamesFolder); 
	  }
	  
	  public void folderChooser() throws IOException {
	    JFileChooser chooser = new JFileChooser(Utils.baronyFolderPath);
	    chooser.setFileSelectionMode(1);
	    int response = chooser.showOpenDialog(null);
	    if (response == 0) {
	      Utils.baronyFolderPath = chooser.getSelectedFile().getAbsolutePath();
	      Utils.savegamesFolderPath = String.valueOf(Utils.baronyFolderPath) + "/savegames";
	      Utils.backupFolderPath = String.valueOf(Utils.baronyFolderPath) + "/savegames/backup/";
	      updatePathTxtFile();
	      updateFolders();
	    } 
	  }
	  
	  public boolean verifyFolderPath() {
	    if (!this.savegamesFolder.exists()) {
	      JOptionPane.showMessageDialog(null, "The folder path is wrong, please choose the BaronyBeta folder");
	      return false;
	    } 
	    return true;
	  }
	  
	  private void updateFolders() {
	    this.savegamesFolder = new File(Utils.savegamesFolderPath);
	    this.backupFolder = new File(Utils.backupFolderPath);
	  }
}
