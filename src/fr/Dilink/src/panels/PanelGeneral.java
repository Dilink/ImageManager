package fr.Dilink.src.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import fr.Dilink.src.Config;
import fr.Dilink.src.Util;

public class PanelGeneral extends JPanel
{
	private static final long serialVersionUID = 1L;
	private static String directoryUrlRaw = Config.getProperty("directory");
	public static String directoryUrl = directoryUrlRaw.replace("\\", "/");
	
	public PanelGeneral() {
		this.setLayout(new GridLayout(1,2));
		this.add(new PanelLeft(), BorderLayout.WEST);
		this.add(new PanelRight(), BorderLayout.EAST);
		Util.listerRepertoire(directoryUrl);
	}
}