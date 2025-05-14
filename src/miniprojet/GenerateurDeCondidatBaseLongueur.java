/*import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GenerateurDeCondidatBaseLongueur implements GenerateurDeCondidat {
    private final IndexeurParLongueur indexeur;

    public GenerateurDeCondidatBaseLongueur() {
        this.indexeur = new IndexeurParLongueur();
    }

    public List<CoupleDeNom> generer(Nom nomRecherche, List<Nom> candidats) {
        Map<Integer, List<Nom>> indexed = indexeur.indexer(candidats);
        List<CoupleDeNom> couples = new ArrayList<>();
        int len = nomRecherche.getNom().length();
        for (int i = Math.max(1, len - 2); i <= len + 2; i++) {
            List<Nom> similarLength = indexed.getOrDefault(i, Collections.emptyList());
            for (Nom candidat : similarLength) {
                couples.add(new CoupleDeNom(nomRecherche, candidat));
            }
        }
        return couples;
    }
}*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenerateurDeCondidatBaseLongueur implements GenerateurDeCondidat {
    private final IndexeurParLongueur indexeur;

    public GenerateurDeCondidatBaseLongueur() {
        this.indexeur = new IndexeurParLongueur();
    }

    public List<CoupleDeNom> generer(Nom nomRecherche, List<Nom> candidats) {
        Map<Integer, List<Nom>> indexed = indexeur.indexer(candidats);
        List<CoupleDeNom> couples = new ArrayList<>();
        int len = nomRecherche.getNom().length();

        for (int i = Math.max(1, len - 2); i <= len + 2; i++) {
            List<Nom> similaireLength = indexed.get(i);
            if (similaireLength == null) {
                similaireLength = new ArrayList<>();
            }
            for (Nom candidat : similaireLength) {
                couples.add(new CoupleDeNom(nomRecherche, candidat));
            }
        }

        return couples;
    }
}

