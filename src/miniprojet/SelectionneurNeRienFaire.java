import java.util.List;

public class SelectionneurNeRienFaire implements Selectionneur {
    public List<CoupleDeNomAvecScore> est_acceptable(List<CoupleDeNomAvecScore> couples) {
        return couples;
    }
}
