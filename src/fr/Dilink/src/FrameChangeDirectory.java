package fr.Dilink.src;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import fr.Dilink.src.panels.PanelListeImages;

public class FrameChangeDirectory extends JFrame
{
	private static final long serialVersionUID = 1L;
	JFileChooser directory = new JFileChooser();
	private static final String buttonTitle = "Choisissez le dossier contenant vos images...";
	JButton button = new JButton(buttonTitle);
	public static String directoryPath;
	
	public FrameChangeDirectory(String title) {
		this.setTitle(title);
		this.setSize(buttonTitle.length() + 263, 64);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.directory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(button);
		
		this.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int state = directory.showOpenDialog(null);
				File file = directory.getSelectedFile();
				if(state == JFileChooser.APPROVE_OPTION) {
					FrameChangeDirectory.this.setVisible(false);
					
					directoryPath = file.getPath();
					System.out.println("FOLDER : "  + file.getPath());
	                Config.overrideDirectoryConfig();
	                PanelListeImages.modele.clear();
	                Util.listerRepertoire(directoryPath);
	                PanelListeImages.etiquette.setText("'" + Config.getProperty("directory") + "'");
					System.out.println("New Folder : "  + Config.getProperty("directory").replace("\\", "/"));
				} else if(state == JFileChooser.CANCEL_OPTION) {
					FrameChangeDirectory.this.setVisible(true);
				}
			}
		});
		this.setVisible(true);
	}
}