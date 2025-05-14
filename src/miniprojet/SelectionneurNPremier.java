import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SelectionneurNPremier implements Selectionneur {
    private final int n;

    public SelectionneurNPremier(int n) {
        this.n = n;
    }


    public List<CoupleDeNomAvecScore> est_acceptable(List<CoupleDeNomAvecScore> couples) {
        List<CoupleDeNomAvecScore> sorted = new ArrayList<>(couples);
        sorted.sort(Comparator.comparingDouble(CoupleDeNomAvecScore::score).reversed());
        return sorted.subList(0, Math.min(n, sorted.size()));
    }
}
