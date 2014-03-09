package fr.Dilink.src;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainClass
{
	public static JFrame frame;
	public static String titre = "Images Manager";
	public static final int FrameWidth = 1000, FrameHeight = 800;
	
	public static void main(String[]args) {
//		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		frame = new Frame(titre, new Dimension(FrameWidth, FrameHeight));
		EventQueue.invokeLater(new VersionChecker());
	}
}