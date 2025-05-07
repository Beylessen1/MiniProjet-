package miniprojet;

import java.util.List;
import java.util.ArrayList;
import java.text.Normalizer;
//removes uppercase and removes special caracters
/*public class CleanName implements Pretraiteur{

    public List<Nom> traiter(List<Nom> noms){
        List<Nom> liste_noms_traitee = new ArrayList<>();
        for (Nom nom : noms) {
            String valeur = nom.getNom();
            String normalized = Normalizer.normalize(valeur, Normalizer.Form.NFD)
                                          .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            String cleaned = normalized.replaceAll("[A-Z\\W_]", "");
            Nom name= new Nom(cleaned, nom.getId());
            liste_noms_traitee.add(name);
        }
        
        return liste_noms_traitee;
      }
}
*/
public class CleanName implements Pretraiteur {
    public List<Nom> traiter(List<Nom> noms) {
        List<Nom> result = new ArrayList<>();
        for (Nom n : noms) {
            result.add(new Nom(n.getNom().trim(), n.getId())); // assume constructor is (String, int)
        }
        return result;
    }
}
