import java.util.ArrayList;
import java.util.List;
public class PretraiteurPhonetique implements Pretraiteur{
    public List<Nom> traiter(List<Nom> noms) {
        List<Nom> result = new ArrayList<>();
        for (Nom nom : noms) {
            String phonetic = toPhonetic(nom.getNom());
            result.add(new Nom(phonetic, nom.getId()));
        }
        return result;
    }

    private String toPhonetic(String name) {
        String cleaned = name.toLowerCase().replaceAll("[^a-z]", "");
        if (cleaned.isEmpty()) return "";
        StringBuilder phonetic = new StringBuilder();
        phonetic.append(cleaned.charAt(0));
        for (int i = 1; i < cleaned.length(); i++) {
            char c = cleaned.charAt(i);
            if ("aeiouy".indexOf(c) == -1) {
                phonetic.append(c);
            }
        }
        return phonetic.toString();
    }
}
