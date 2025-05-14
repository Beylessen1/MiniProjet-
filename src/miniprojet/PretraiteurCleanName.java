import java.util.ArrayList;
import java.util.List;

public class PretraiteurCleanName implements Pretraiteur{
    public List<Nom> traiter(List<Nom> noms) {
        List<Nom> result = new ArrayList<>();
        for (Nom nom : noms) {
            String cleaned = nom.getNom().toLowerCase()
                    .replaceAll("[^a-z0-9]", "");
            result.add(new Nom(cleaned, nom.getId()));
        }
        return result;
    }
}
