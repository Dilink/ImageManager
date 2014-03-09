package fr.Dilink.src;

import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class VersionChecker extends MouseAdapter implements Runnable
{
	@Override
	public void run() {
		try {
			URL url = new URL(Util.URLVersionFile);
			URLConnection urlConnection = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				int nbr = Integer.decode(line);
				System.out.println("Version locale : " + Util.Version);
				System.out.println("Version internet : " + nbr);
				if (nbr > Util.Version) {
					JLabel label = new JLabel("Une nouvelle mise à jour est disponible,\n vous pouvez la télécharger ici :");
					JLabel labelLien = new JLabel("<html><u>Télécharger</u></html>");
					labelLien.addMouseListener(this);
			        JFrame f = new JFrame();
			        f.setLayout(new FlowLayout());
			        f.add(label);
			        f.add(labelLien);
			        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			        f.pack();
			        f.setLocationRelativeTo(null);
			        f.setIconImage(Util.icone);
			        f.setVisible(true);
			        f.setAlwaysOnTop(true);
					System.out.println("Mise à jour disponible !");
				}
			}
			in.close();
		} catch (final Exception e) { }
	}
	@Override
    public void mousePressed(MouseEvent evt) {
        try {
            URI uri = new URI(Util.URLProgramFile);
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}