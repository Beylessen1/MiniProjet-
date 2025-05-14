import java.util.ArrayList;
import java.util.List;

public class GenerateurDeCondidatSimple  implements GenerateurDeCondidat{
    public List<CoupleDeNom> generer(Nom nomRecherche, List<Nom> candidats) {
        List<CoupleDeNom> couples = new ArrayList<>();
        for (Nom candidat : candidats) {
            couples.add(new CoupleDeNom(nomRecherche, candidat));
        }
        return couples;
    }
}
