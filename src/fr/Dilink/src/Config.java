package fr.Dilink.src;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config
{
	private static FileOutputStream outputStream;
	private static InputStream input;
	private static Properties config = new Properties();
	static File configFile = new File(System.getProperty("user.home") + "/ImageManager.config.txt");
	
	public Config () {
		if ((configFile.exists()) && (configFile.length() != 0)) {
			System.out.println("Le fichier de config existe.");
		} else {
			System.out.println("Le fichier de config n'existe pas.");
			try {
				configFile.createNewFile();
				outputStream = new FileOutputStream(configFile);
				config.setProperty("directory", "localhost");
				config.store(outputStream, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void setDirectoryConfig() {
		if ((configFile.exists()) && (configFile.length() != 0)) {
			System.out.println("Le fichier de config existe.");
		} else {
			System.out.println("Le fichier de config n'existe pas.");
			try {
				configFile.createNewFile();
				outputStream = new FileOutputStream(configFile);
				config.setProperty("directory", FrameDirectoryChooser.directoryPath);
				config.store(outputStream, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void overrideDirectoryConfig() {
		try {
			configFile.createNewFile();
			outputStream = new FileOutputStream(configFile);
			config.setProperty("directory", FrameChangeDirectory.directoryPath);
			config.store(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static boolean isConfigExist() {
		if ((configFile.exists()) && (configFile.length() != 0)) {
			System.out.println("Le fichier de config existe.");
			return true;
		} else {
			System.out.println("Le fichier de config n'existe pas.");
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	public static String getProperty(String string) {
		try {
			input = new FileInputStream(configFile);
			config.load(input);
//			System.out.println("System : " + System.getProperty("user.home")); // Vers le dossier de session
//			System.out.println("System : " + System.getProperty("user.dir")); // Vers le dossier de l'application
		} catch (IOException e) {
			e.printStackTrace();
		}
		return config.getProperty(string);
	}
}