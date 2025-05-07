package miniprojet;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MoteurDeRecherche moteur = new MoteurDeRecherche(
            new CleanName(),
            new Generateurbasesurlongueur(),
            new ComparateurExact(),
            new SelectionneurAvecSeuil(1.0)
        );

       
        List<Nom> liste1 = List.of(
            new Nom("Ali Ben Salah"),
            new Nom("Zahra Bouzid"),
            new Nom("Khaled Trabelsi"),
            new Nom("ALI BEN SALAH")
        );

        List<Nom> liste2 = List.of(
            new Nom("Ali ben salah"),
            new Nom("Zahra Bou Zid"),
            new Nom("Omar Jendoubi")
        );

       
        Nom nomRecherche = new Nom("Ali Ben Salah");
        List<Nom> resultatsRecherche = moteur.rechercher(nomRecherche, liste1);
        System.out.println("\n Résultats '" + nomRecherche.getNom() + "' :");
        for (Nom n : resultatsRecherche) {
            System.out.println(" - " + n.getNom());
        }

        List<Nom> listeDedoublonnee = moteur.dedupliquer(liste1);
        System.out.println(" Liste après déduplication :");
        for (Nom n : listeDedoublonnee) {
            System.out.println(" - " + n.getNom());
        }

        List<Nom> correspondances = moteur.comparerListes(liste1, liste2);
        System.out.println("\n Liste de Correspondances :");
        for (String c : correspondances) {
            System.out.println(" - " + c);
        }
    }
}
