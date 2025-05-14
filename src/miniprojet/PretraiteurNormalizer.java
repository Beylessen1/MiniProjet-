import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class PretraiteurNormalizer implements Pretraiteur{
    public List<Nom> traiter(List<Nom> noms) {
        List<Nom> result = new ArrayList<>();
        for (Nom nom : noms) {
            String normalized = Normalizer.normalize(nom.getNom(), Normalizer.Form.NFD)
                    .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            result.add(new Nom(normalized, nom.getId()));
        }
        return result;
    }
}
