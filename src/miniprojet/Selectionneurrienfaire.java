package miniprojet;
import java.util.List;
import java.util.ArrayList;
public class Selectionneurrienfaire implements Selectionneur {
  public List <Nom> est_acceptable (List<CoupleDeNomAvecScore> liste){
    List<Nom> result = new ArrayList<>();
        for (CoupleDeNomAvecScore cnas : liste) {
            result.add(cnas.nom2());
        }
        return result;
  }
}
//yraj3 id nom couple w score te3hom
//ya benty esmou ne rien faire yraja3ha kima heya
