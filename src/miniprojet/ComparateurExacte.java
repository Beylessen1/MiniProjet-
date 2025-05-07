package miniprojet;

public class ComparateurExacte implements ComparateurDeNom {
    public int Comparer(Nom n1, Nom n2) {
        String nom1 = n1.getNom().trim().toLowerCase();
        String nom2 = n2.getNom().trim().toLowerCase();
        return nom1.equals(nom2) ? 1 : 0;
    }
}
