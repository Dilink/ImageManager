package fr.Dilink.src;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;

import fr.Dilink.src.panels.PanelGeneral;
import fr.Dilink.src.panels.PanelListeImages;

public class Util
{
	public static final int Version = 1;
	public static final String URLVersionFile = "https://dl.dropboxusercontent.com/u/86671460/Projets/ImageManager/version.txt";
	public static final String URLProgramFile = "https://dl.dropboxusercontent.com/u/86671460/Projets/ImageManager/ImageManager.jar";
	
	public Font fontBig;
	public Font fontLight;
	public static Image icone = new ImageIcon(MainClass.class.getResource("res/icon.png")).getImage();

	public Util() {
		try {
			fontBig = Font.createFont(Font.TRUETYPE_FONT, MainClass.class.getResource("res/font.ttf").openStream()).deriveFont(Font.PLAIN, 24);
			fontLight = Font.createFont(Font.TRUETYPE_FONT, MainClass.class.getResource("res/font.ttf").openStream()).deriveFont(Font.PLAIN, 18);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontBig);
			ge.registerFont(fontLight);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void listerRepertoire(String repertoire) {
		String[] dir = new File(repertoire).list( );
		for (int i=0; i<dir.length; i++) {
//			System.out.println(dir[i].substring(0, dir[i].lastIndexOf('.')));			System.out.println(dir[i].substring(dir[i].lastIndexOf('.')));
			PanelListeImages.afficherTexte(dir[i]);
		}
	}
	public static void rename(String newName) {
		if(!newName.equals(PanelListeImages.liste.getSelectedValue().toString())) {
			File source = new File(Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue());
			if (source.renameTo(new File(Config.getProperty("directory") + "/" + newName))) {
				PanelListeImages.modele.clear();
				listerRepertoire(PanelGeneral.directoryUrl);
				System.out.println("NEW NAME !");
			}
		}
	}
	public static void moveFile(String newDirectory) {
		if (!(new File(newDirectory + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath()).equals(new File(Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath())) {
			new File(newDirectory).mkdir();
//			System.out.println("ANCIENT DIRECTORY ! : " + (new File(PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath()));
//			System.out.println("ANCIENT DIRECTORY ! : " + (new File(Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath()));
//			System.out.println("NEW DIRECTORY ! : " + (new File(newDirectory + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath()));
			System.out.println("Copy file from : " + (new File(Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath()) + ", to : " + (new File(newDirectory + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath()));
		    System.out.println("Copie du fichier : " + Copy.copie(Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue().toString(), newDirectory));
		    File s = new File((Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue()));
		    System.out.println("Suppression du fichier de base : " + s.delete());
		    PanelListeImages.modele.clear();
			listerRepertoire(PanelGeneral.directoryUrl);
		}
	}
	public static void copyFile(String newDirectory) {
		if (!(new File(newDirectory + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath()).equals(new File(Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath())) {
			new File(newDirectory).mkdir();
			System.out.println("Copy file from : " + (new File(Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath()) + ", to : " + (new File(newDirectory + PanelListeImages.liste.getSelectedValue().toString()).getAbsolutePath()));
		    System.out.println("Copie du fichier : " + Copy.copie(Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue().toString(), newDirectory));
		    PanelListeImages.modele.clear();
			listerRepertoire(PanelGeneral.directoryUrl);
		}
	}
	public static String isSelectedValue() {
		if (PanelListeImages.liste.getSelectedValue() != null) {
			return PanelListeImages.liste.getSelectedValue().toString();
		} else {
			return "";
		}
	}
}