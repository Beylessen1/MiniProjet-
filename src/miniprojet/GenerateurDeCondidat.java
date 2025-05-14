import java.util.List;

public interface GenerateurDeCondidat {
    List<CoupleDeNom> generer(Nom nomRecherche, List<Nom> candidats);
}
