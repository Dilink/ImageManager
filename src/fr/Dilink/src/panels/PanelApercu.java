package fr.Dilink.src.panels;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fr.Dilink.src.Config;
import fr.Dilink.src.Util;

public class PanelApercu extends JPanel
{
	private static final long serialVersionUID = 1L;
	BufferedImage img;

	public PanelApercu() {
		this.setBackground(new Color(0x717171));
		PanelListeImages.liste.addMouseListener(mouseListener);
		PanelListeImages.liste.addKeyListener(keyListener);
	}
	MouseListener mouseListener = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 1) {
				paint(getGraphics());
			} else if (e.getClickCount() == 2) {
				if(Desktop.isDesktopSupported()) {
					if(Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
						try {
							Desktop.getDesktop().open(new File(Config.getProperty("directory") + "/" + Util.isSelectedValue()));
						} catch (IOException ex) { }
					} else {
						//La fonction n'est pas supportée par votre système d'exploitation
						JOptionPane.showMessageDialog(null, "La fonction n'est pas supportée par votre système d'exploitation", "Fonction non supportée", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					//Desktop pas supportée par votre système d'exploitation
					JOptionPane.showMessageDialog(null, "Desktop pas supportée par votre système d'exploitation", "Fonction non supportée", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	};
	KeyListener keyListener = new KeyListener() {
		@Override
		public void keyPressed(KeyEvent e) {
			if (!Util.isSelectedValue().equals("")) {
				if (e.getKeyCode() == 127) {
					int dialogResult = JOptionPane.showConfirmDialog (null, "Vous vous appretez à supprimer ce fichier : '" + Util.isSelectedValue() + "'","Attention, suppression !", JOptionPane.WARNING_MESSAGE);
					if(dialogResult == JOptionPane.YES_OPTION) {
						File s = new File((Config.getProperty("directory") + "/" + PanelListeImages.liste.getSelectedValue()));
					    System.out.println("Suppression du fichier de base : " + s.delete());
						System.out.println("Suppression en cours !");
					    PanelListeImages.modele.clear();
						Util.listerRepertoire(PanelGeneral.directoryUrl);
					}
				}
			}
		}
		@Override
		public void keyReleased(KeyEvent e) { }
		@Override
		public void keyTyped(KeyEvent e) { }
	};
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.ORANGE);
		g.drawRect(4, 4, this.getWidth() - 10, this.getHeight() - 10);
		g.drawRect(5, 5, this.getWidth() - 12, this.getHeight() - 12);
		g.drawRect(6, 6, this.getWidth() - 14, this.getHeight() - 14);
		try {
			if(PanelListeImages.liste.getSelectedValue() != null) {
				this.img = ImageIO.read(new File(Config.getProperty("directory") + "/" + Util.isSelectedValue()));
				g.drawImage (img, 7, 7, this.getWidth() - 15, this.getHeight() - 15, null);
			}
		} catch (IOException e) { e.printStackTrace(); }
	}
}