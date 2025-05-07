package miniprojet;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Nom> liste = List.of(
            new Nom("Ahmed"),
            new Nom("Ahmad"),
            new Nom("Ahmet"),
            new Nom("Hamed"),
            new Nom("Mohamed"),
            new Nom("Aymen")
        );
        Nom nomRecherche = new Nom("Ahmad");

        Praitraiteur nettoyeur = new CleanName();
        GenerateurDeCandidats generateur = new Generateurbasesurlongeur();
        ComparateurDeNom comparateur = new ComparateurExacte();  // fixed spelling
        Selectionneur selectionneur = new SelectionneurAvecSeuil(0.8);

        MoteurDeRecherche moteur = new MoteurDeRecherche(
            nettoyeur,
            generateur,
            comparateur,
            selectionneur
        );

        List<Nom> resultats = moteur.rechercher(nomRecherche, liste);

        System.out.println("Résultats pour la recherche de '" + nomRecherche.getNom() + "' :");
        for (Nom resultat : resultats) {
            System.out.println(" - " + resultat.getNom());
        }
    }
}
