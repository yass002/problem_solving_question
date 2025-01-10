import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static int etalonnage() throws IOException {
        String fichier = "test.txt"; // ceci le fichier que je vais lire
        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String ligne; // je mets chaque ligne ici
        int s = 0; // somme
        while ((ligne = br.readLine()) != null) {
            String chaine = "";
            char premierChiffre = '\0'; // je sais pas pourquoi ' ' ne fonctionne pas ici
            char dernierChiffre = ' ';

            // Parcourir la ligne
            for (int i = 0; i < ligne.length(); i++) {
                char c = ligne.charAt(i);
                if (Character.isDigit(c)) {
                    if (premierChiffre == '\0') { // ici j'ai garanti que ceci est le premier chiffre
                        premierChiffre = c;
                    }
                    dernierChiffre = c;
                }
            }
            chaine = premierChiffre + "" + dernierChiffre;
            int num = 0;
            try {
                num = Integer.parseInt(chaine);
            } catch (NumberFormatException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
            s = s +num;
        }
        System.out.println(s);
        return s;
    }


    public static void main(String[] args) throws IOException {
        System.out.println(etalonnage());
    }
}