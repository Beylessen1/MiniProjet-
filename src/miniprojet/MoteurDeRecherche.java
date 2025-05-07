package miniprojet;

import java.util.ArrayList;
import java.util.List;

public class MoteurDeRecherche {

    private final Pretraiteur pretraiteur;
    private final GenerateurDeCandidats generateur;
    private final ComparateurDeNom comparateur;
    private final Selectionneur selectionneur;

    public MoteurDeRecherche(Pretraiteur pretraiteur,
                             GenerateurDeCandidats generateur,
                             ComparateurDeNom comparateur,
                             Selectionneur selectionneur) {
        this.pretraiteur = pretraiteur;
        this.generateur = generateur;
        this.comparateur = comparateur;
        this.selectionneur = selectionneur;
    }

    public List<Nom> rechercher(Nom nomRecherche, List<Nom> liste) {
        
        List<Nom> listeNettoyee = nettoyerListe(liste);
        List<Nom> candidats = generateur.genererCandidats(nomRecherche, listeNettoyee);
        List<CoupleDeNomAvecScore> couples = comparer(nomRecherche, candidats);
        return selectionneur.est_acceptable(couples);

    }

    private List<Nom> nettoyerListe(List<Nom> liste) {
        return pretraiteur.traiter(liste);
    }

    private List<CoupleDeNomAvecScore> comparer(Nom nomRecherche, List<Nom> candidats) {
        List<CoupleDeNomAvecScore> couples = new ArrayList<>();
        for (Nom candidat : candidats) {
            double score = comparateur.Comparer(nomRecherche, candidat);
            couples.add(new CoupleDeNomAvecScore(nomRecherche, candidat, score));
        }
        return couples;
    }
}
