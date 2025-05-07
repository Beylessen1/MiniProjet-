package miniprojet;

import java.util.ArrayList;
import java.util.List;

public class MoteurDeRecherche {

    private final Pretraiteur pretraiteur;
    private final GenerateurDeCandidats generateur;
    private final ComparateurDeNom comparateur;
    private final Selectionneur selectionneur;

    public MoteurDeRecherche(Praitraiteur pretraiteur,
                             GenerateurDeCandidats generateur,
                             ComparateurDeNom comparateur,
                             Selectionneur selectionneur) {
        this.pretraiteur = pretraiteur;
        this.generateur = generateur;
        this.comparateur = comparateur;
        this.selectionneur = selectionneur;
    }

    public List<Nom> rechercher(Nom nomRecherche, List<Nom> liste) {
        if (nomRecherche == null || liste == null || liste.isEmpty()) {
            return List.of();  
        }
        List<Nom> listeNettoyee = nettoyerListe(liste);
        List<Nom> candidats = generateur.generer(nomRecherche, listeNettoyee);
        List<CoupleDeNomAvecScore> couples = comparer(nomRecherche, candidats);
        return selectionneur.selectionner(couples);
    }

    private List<Nom> nettoyerListe(List<Nom> liste) {
        List<Nom> nettoyee = new ArrayList<>();
        for (Nom nom : liste) {
            nettoyee.add(praitraiteur.traiter(nom));
        }
        return nettoyee;
    }

    private List<CoupleDeNomAvecScore> comparer(Nom nomRecherche, List<Nom> candidats) {
        List<CoupleDeNomAvecScore> couples = new ArrayList<>();
        for (Nom candidat : candidats) {
            double score = comparateur.comparer(nomRecherche, candidat);
            couples.add(new CoupleDeNomAvecScore(nomRecherche, candidat, score));
        }
        return couples;
    }
}
