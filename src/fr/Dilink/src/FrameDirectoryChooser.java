package fr.Dilink.src;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.Dilink.src.panels.PanelGeneral;

public class FrameDirectoryChooser extends JFrame
{
	private static final long serialVersionUID = 1L;
	JFileChooser directory = new JFileChooser();
	private static final String buttonTitle = "Choisissez le dossier contenant vos images...";
	JButton button = new JButton(buttonTitle);
	private Frame frame;
	public static String directoryPath =  null;
	
	public FrameDirectoryChooser(String title, Frame frameInstance) {
		this.frame = frameInstance;
		this.setTitle(title);
		this.setSize(buttonTitle.length() + 263, 64);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
				if(/*file != null && */state == JFileChooser.APPROVE_OPTION) {
//					JOptionPane.showMessageDialog(null, file.getPath());
					FrameDirectoryChooser.this.setVisible(false);
					directoryPath = file.getPath();
					System.out.println("FOLDER : "  + directoryPath);
//	                int dialogResult = JOptionPane.showConfirmDialog (null, "Veuillez copier ceci dans le fichier de configuration présent \n dans l'application et la relancer : '" + directoryPath + "' \n N'oubliez pas de doubler les '\'","Attention !", JOptionPane.DEFAULT_OPTION);
	                Config.setDirectoryConfig();
//					JOptionPane.showMessageDialog (null, "Veuillez redémarrer l'application.", "Redémarrage !", JOptionPane.INFORMATION_MESSAGE);
//	                if(dialogResult == JOptionPane.YES_OPTION){ System.exit(0); }
					System.out.println("FOLDER : "  + directoryPath);
//					System.out.println("FOLDER : "  + System.getProperty("user.home").toString());
					JPanel contentPane = (JPanel) frame.getContentPane();
					contentPane.removeAll();
					contentPane.add(new PanelGeneral());
					contentPane.revalidate(); 
					contentPane.repaint();
					frame.setVisible(true);
				} else if(state == JFileChooser.CANCEL_OPTION) {
					FrameDirectoryChooser.this.setVisible(true);
				}
			}
		});
		this.setVisible(true);
	}
}