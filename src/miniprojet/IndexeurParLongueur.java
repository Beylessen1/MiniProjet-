import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class IndexeurParLongueur implements Indexeur {
    public <T> Map<T, List<Nom>> indexer(List<Nom> noms) {
        Map<Integer, List<Nom>> index = new HashMap<>();
        for (Nom nom : noms) {
            int length = nom.getNom().length();
            List<Nom> existante = index.get(length);
            if (existante == null) {
                existante = new ArrayList<>();
                index.put(length, existante);
            }
            existante.add(nom);
        }
        return (Map<T, List<Nom>>) index;
    }


}
