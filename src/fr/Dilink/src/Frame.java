package fr.Dilink.src;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.Dilink.src.panels.PanelGeneral;

public class Frame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public Frame(String titre, Dimension d) {
		this.setTitle(titre);
		this.setSize(d.width, d.height);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(Util.icone);
//		this.setExtendedState(JFrame.ICONIFIED); REDUIRE EN ICONE
		
//		if(Config.getProperty("directory").equals("")) {
		if (Config.isConfigExist() == false) {
			this.setVisible(false);
			new FrameDirectoryChooser("Choisissez le dossier", this).setIconImage(Util.icone);
		}else{
			JPanel contentPane = (JPanel) this.getContentPane();
			contentPane.removeAll();
			contentPane.add(new PanelGeneral());
			contentPane.revalidate(); 
			contentPane.repaint();
			this.setVisible(true);
		}
	}
	public Frame() { }
}