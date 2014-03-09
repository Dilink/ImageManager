package fr.Dilink.src;

import java.io.*;

public class Copy
{
	public static boolean copie(String pathFile, String pathDesination) {
        boolean resultat = false ;
        FileInputStream sourceFile = null;
        FileOutputStream destinationFile = null;
        String pathDestinationTronquer = pathFile.toString().replace(pathFile.toString().substring(0, pathFile.lastIndexOf('.')), pathFile.toString().substring(pathFile.lastIndexOf('/')));
        String name = pathDestinationTronquer.toString().substring(0, pathDestinationTronquer.lastIndexOf('.')).replace("/", "");
//      pathDesination = pathDesination + name;
        
        if (!(pathDesination.endsWith("/"))) {
        	pathDesination = pathDesination + "/" + name;
        } else {
        	pathDesination = pathDesination + name;
        }
        System.out.println("FICHIER DE PROVENANCE : " + pathFile);
        System.out.println("FICHIER DE DESTINATION : " + pathDesination);
        try {
        	new File(pathDesination).createNewFile();
            sourceFile = new FileInputStream(pathFile);
            destinationFile = new FileOutputStream(pathDesination);
            byte buffer[] = new byte[512*1024];
            int nbLecture;
            while( (nbLecture = sourceFile.read(buffer)) != -1 ) {
                destinationFile.write(buffer, 0, nbLecture);
            }
            resultat = true;
        } catch(FileNotFoundException f) {
        } catch(IOException e) {
        } finally {
	        try {
	            sourceFile.close();
	        } catch(Exception e) { }
	        try {
	            destinationFile.close();
	        } catch(Exception e) { }
        }
        return(resultat);
	}
	
	public static void ecrire(String texte) {
		String pathFile = FrameDirectoryChooser.directoryPath + "/config.txt";
		try {
			/** BufferedWriter a besoin d un FileWriter, les 2 vont ensemble, on donne comme argument le nom
			 *  du fichiertrue signifie qu on ajoute dans le fichier (append), on ne marque pas par dessus */
			File fichier = new File(pathFile);
			fichier.delete();
			fichier.createNewFile(); // Creer le ficher
			
			FileWriter fw = new FileWriter(pathFile, true); // le BufferedWriter output auquel on donne comme argument le FileWriter fw cree juste au dessus
			BufferedWriter output = new BufferedWriter(fw); //on marque dans le fichier ou plutot dans le BufferedWriter qui sert comme un tampon(stream)
			output.write(texte); //on peut utiliser plusieurs fois methode write
			output.flush(); //ensuite flush envoie dans le fichier, ne pas oublier cette methode pour le BufferedWriter
			output.close();
			System.out.println("Fichier créé et écrit");
		} catch(IOException ioe) {
			System.out.print("Erreur : ");
			ioe.printStackTrace();
		}
	}
}