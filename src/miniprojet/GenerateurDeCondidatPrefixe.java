/*import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenerateurDeCondidatPrefixe implements GenerateurDeCondidat {
    private final IndexeurParSyllabe indexeur;

    public GenerateurDeCondidatPrefixe() {
        this.indexeur = new IndexeurParSyllabe();
    }

    public List<CoupleDeNom> generer(Nom nomRecherche, List<Nom> candidats) {
        Map<String, List<Nom>> indexed = indexeur.indexer(candidats);
        List<CoupleDeNom> couples = new ArrayList<>();
        String firstSyllable = getFirstSyllable(nomRecherche.getNom());
        List<Nom> similarSyllable = indexed.getOrDefault(firstSyllable, List.of());
        for (Nom candidat : similarSyllable) {
            couples.add(new CoupleDeNom(nomRecherche, candidat));
        }
        return couples;
    }

    private String getFirstSyllable(String name) {
        String vowels = "aeiouy";
        int firstVowel = -1;
        for (int i = 0; i < name.length(); i++) {
            if (vowels.indexOf(Character.toLowerCase(name.charAt(i))) >= 0) {
                firstVowel = i;
                break;
            }
        }
        if (firstVowel == -1) return name;
        return name.substring(0, firstVowel + 1);
    }
}*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenerateurDeCondidatPrefixe implements GenerateurDeCondidat {
    private final IndexeurParSyllabe indexeur;

    public GenerateurDeCondidatPrefixe() {
        this.indexeur = new IndexeurParSyllabe();
    }

    public List<CoupleDeNom> generer(Nom nomRecherche, List<Nom> candidats) {
        Map<String, List<Nom>> indexed = indexeur.indexer(candidats);
        List<CoupleDeNom> couples = new ArrayList<>();
        String premiereSyllabe = getPremiereSyllabe(nomRecherche.getNom());


        List<Nom> similaire = indexed.get(premiereSyllabe);
        if (similaire == null) {
            similaire = new ArrayList<>();
        }

        for (Nom candidat : similaire) {
            couples.add(new CoupleDeNom(nomRecherche, candidat));
        }
        return couples;
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