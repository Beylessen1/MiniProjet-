import java.util.ArrayList;
import java.util.List;

public class SelectionneurParSeuil implements Selectionneur {
    private final double seuil;

    public SelectionneurParSeuil(double seuil) {
        this.seuil = seuil;
    }


    public List<CoupleDeNomAvecScore> est_acceptable(List<CoupleDeNomAvecScore> couples) {
        List<CoupleDeNomAvecScore> acceptable = new ArrayList<>();
        for (CoupleDeNomAvecScore couple : couples) {
            if (couple.score() >= seuil) {
                acceptable.add(couple);
            }
        }
        return acceptable;
    }
}
