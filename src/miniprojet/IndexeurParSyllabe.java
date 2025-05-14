import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class IndexeurParSyllabe implements Indexeur {

    public <T> Map<T, List<Nom>> indexer(List<Nom> noms) {
        Map<String, List<Nom>> index = new HashMap<>();
        for (Nom nom : noms) {
            String premiereSyllabe = getPremiereSyllabe(nom.getNom());
            index.computeIfAbsent(premiereSyllabe, k -> new ArrayList<>()).add(nom);
        }
        return (Map<T, List<Nom>>) index;
    }

    private String getPremiereSyllabe(String name) {
        String voyelle = "aeiouy";
        int premiereVoyelle = -1;
        for (int i = 0; i < name.length(); i++) {
            if (voyelle.indexOf(Character.toLowerCase(name.charAt(i))) >= 0) {
                premiereVoyelle = i;
                break;
            }
        }
        if (premiereVoyelle == -1) return name;
        return name.substring(0, premiereVoyelle + 1);
    }
}
