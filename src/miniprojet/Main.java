package miniprojet;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Nom> liste = List.of(
            new Nom("Ahmed", 15),
            new Nom("Ahmad", 2),
            new Nom("Ahmet", 20),
            new Nom("Hamed", 500),
            new Nom("Mohamed", 4),
            new Nom("Aymen" , 30)
        );
        Nom nomRecherche = new Nom("ahmed", 2);
       
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
