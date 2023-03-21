import org.apache.commons.io.IOUtils;
import net.sourceforge.tess4j.TesseractException;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testTesseract {
    public static void main(String[] args) throws TesseractException, IOException {
        // Configuration du processus Tesseract
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("tesseract", "/Users/hugo/Desktop/Cours/MasterMIAGEM2/S2/hackathon/Weather/src/main/resources/images/re-u-parking.jpeg", "output");
        try {
            // Lancement de Tesseract pour effectuer la reconnaissance optique de caractères
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            // Vérification du résultat de Tesseract
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Reconnaissance de caractères réussie !");
                System.out.println(output);
            } else {
                System.out.println("Erreur lors de la reconnaissance de caractères !");
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Récupération du texte reconnu à partir du fichier de sortie de Tesseract
        FileInputStream fis = new FileInputStream("/Users/hugo/Desktop/Cours/MasterMIAGEM2/S2/hackathon/output.txt");
        String data = IOUtils.toString(fis, "UTF-8");
        System.out.println(data);

        // Recherche de la localisation
        Pattern pattern = Pattern.compile("(?i).*\\bORLEANS\\b.*");
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            String location = matcher.group();
            System.out.println("Localisation : " + location);
        } else {
            System.out.println("Localisation non trouvée.");
        }

        // Recherche de la date d'entrée
        pattern = Pattern.compile("ENTR\\.\\s*(\\d{2}\\.\\d{2}\\.\\d{2})");
        matcher = pattern.matcher(data);
        if (matcher.find()) {
            String dateEntree = matcher.group(1);
            System.out.println("Date d'entrée : " + dateEntree);
        } else {
            System.out.println("Date d'entrée non trouvée.");
        }

        // Recherche de la date de sortie
        pattern = Pattern.compile("PAYE\\.\\s*(\\d{2}\\.\\d{2}\\.\\d{2})");
        matcher = pattern.matcher(data);
        if (matcher.find()) {
            String dateSortie = matcher.group(1);
            System.out.println("Date de sortie : " + dateSortie);
        } else {
            System.out.println("Date de sortie non trouvée.");
        }

        // Recherche du prix TTC
        String prixTTCRegex = "PRIX TTC:\\s*(\\d+\\.\\d{2})\\s*EU";
        pattern = Pattern.compile(prixTTCRegex);
        matcher = pattern.matcher(data);
        if (matcher.find()) {
            String prixTTC = matcher.group(1);
            System.out.println("Le prix TTC est : " + prixTTC + "€");
        } else {
            System.out.println("Le prix TTC n'a pas été trouvé.");
        }
    }
}
