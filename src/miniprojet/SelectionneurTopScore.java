import java.util.ArrayList;
import java.util.List;

public class SelectionneurTopScore implements Selectionneur{
    public List<CoupleDeNomAvecScore> est_acceptable(List<CoupleDeNomAvecScore> couples) {
        if (couples.isEmpty()) return List.of();
        double maxScore = couples.stream()
                .mapToDouble(CoupleDeNomAvecScore::score)
                .max()
                .orElse(0.0);
        List<CoupleDeNomAvecScore> topScores = new ArrayList<>();
        for (CoupleDeNomAvecScore couple : couples) {
            if (couple.score() == maxScore) {
                topScores.add(couple);
            }
        }
        return topScores;
    }
}
