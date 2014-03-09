package fr.Dilink.src.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelLeft extends JPanel
{
	private static final long serialVersionUID = 1L;

	public PanelLeft() {
		this.setLayout(new GridLayout(1, 1));		
		this.add(new PanelListeImages(), BorderLayout.WEST);
	}
}