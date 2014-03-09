package fr.Dilink.src.panels;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class PanelRight extends JPanel
{
	private static final long serialVersionUID = 1L;

	public PanelRight() {
		this.setLayout(new GridLayout(2,1));		
		this.add(new PanelApercu(), BorderLayout.NORTH);
		this.add(new PanelProperties(), BorderLayout.SOUTH);
	}
}