package miniprojet;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Nom> liste = List.of(
            new Nom("ds", "Ahmed"),
            new Nom("dm","Ahmad"),
            new Nom("gh","Ahmet"),
            new Nom("nl","Hamed"),
            new Nom("mn","Mohamed"),
            new Nom("kl","Aymen")
        );
        Nom nomRecherche = new Nom("ahmed");
       
        Pretraiteur nettoyeur = new CleanName();
        GenerateurDeCandidats generateur = new Generateurbasesurlongeur();
        ComparateurDeNom comparateur = new ComparateurExacte(); 
        //Selectionneur selectionneur = new SelectionneurAvecSeuil(0.8);
        Selectionneur selectionneur = new Selectionneurrienfaire();
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
