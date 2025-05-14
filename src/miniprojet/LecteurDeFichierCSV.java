import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class LecteurDeFichierCSV implements LecteurDeFichier{
    public List<Nom> lireFichier(String filepath) {
        List<Nom> noms = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    // First column is id, second column is nom
                    noms.add(new Nom(parts[1].trim(), parts[0].trim()));
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier: " + e.getMessage());
            return null;
        }
        return noms;
    }
}
