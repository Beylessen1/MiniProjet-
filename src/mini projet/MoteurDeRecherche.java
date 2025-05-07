package miniprojet;
import java.util.* ;

public class MoteurDeRecherche {
    private final CleanName pretraitement;
    private final GenerateurDeCandidat generateur;
    private final ComparateurDeNom comparateur;
    private final Selectionneur selectionneur;
    public MoteurDeRecherche(
        CleanName pretraitement,
        GenerateurDeCandidat generateur,
        ComparateurDeNom comparateur,
        Selectionneur selectionneur
    ) {
        this.pretraitement = pretraitement;
        this.generateur = generateur;
        this.comparateur = comparateur;
        this.selectionneur = selectionneur;
    }
     public List<Nom> rechercher(Nom nomRecherche, List<String> liste) {
        List<Nom> nomRechercheTraite = pretraitement.traiter(Collections.singletonList(nomRecherche));
        List<Nom> listePretraitee = pretraitement.traiter(liste);
        List<Nom> candidats = generateur.generer(nomRechercheTraite.get(0), listePretraitee);
        List<CoupleDeNomAvecScore> scores = new ArrayList<>();
        for (Nom candidat : candidats) {
            double score = comparateur.Comparer(nomRechercheTraite.get(0), candidat);
            scores.add(new CoupleDeNomAvecScore(candidat, score));
        }
        List<Nom> selection = selectionneur.est_acceptable(scores);
        return selection;
    }

    public List<Nom> comparerListes(List<Nom> liste1, List<Nom> liste2) {
        
        List<String> correspondances = new ArrayList<>();

        for (Nom n1 : pretraitee1) {
            List<Nom> candidats = generateur.generer(n1, pretraitee2);
            List<CoupleDeNomAvecScore> scores = new ArrayList<>();

            for (Nom n2 : candidats) {
                double score = comparateur.Comparer(n1, n2);
                scores.add(new CoupleDeNomAvecScore(n2, score));
            }

            List<Nom> matches = selectionneur.est_acceptable(scores);
            for (Nom match : matches) {
                correspondances.add(n1.getNom() + "    " + match.getNom());
            }
        }

        return correspondances;
    }

    public List<Nom> dedupliquer(List<Nom> liste) {
        Set<Nom> uniques = new LinkedHashSet<>();

        for (Nom nom : pretraitee) {
            boolean isDuplicate = false;

            for (Nom existant : uniques) {
                double score = comparateur.Comparer(nom, existant);
                if (selectionneur.est_acceptable(
                    Collections.singletonList(new CoupleDeNomAvecScore(existant, score))
                ).size() > 0) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                uniques.add(nom);
            }
        }

        return new ArrayList<>(uniques);
    }
}
}
