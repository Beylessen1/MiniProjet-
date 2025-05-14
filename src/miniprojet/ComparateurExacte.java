import java.util.ArrayList;
import java.util.List;

public class ComparateurExacte implements ComparateurDeNom  {
    public List<CoupleDeNomAvecScore> comparer(Nom nom1, Nom nom2) {
        double score = nom1.getNom().equals(nom2.getNom()) ? 1.0 : 0.0;

        List<CoupleDeNomAvecScore> resultList = new ArrayList<>();
        resultList.add(new CoupleDeNomAvecScore(nom1, nom2, score));
        return resultList;
    }
}
