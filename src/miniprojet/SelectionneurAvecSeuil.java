package miniprojet;


import java.util.List;
import java.util.ArrayList;
public class SelectionneurAvecSeuil  implements Selectionneur {
  public double seuil ;
  public SelectionneurAvecSeuil(double seuil) {
        this.seuil = seuil;
    }
  public List <CoupleDeNomAvecScore> est_acceptable (List<CoupleDeNomAvecScore> liste){
      List<CoupleDeNomAvecScore> list_select = new ArrayList<>();
      for (CoupleDeNomAvecScore cnas : liste){
       if (cnas.score() >= seuil){
         list_select.add(cnas.nom2());
       }
      }
      return list_select;
  }
  
        
                   
}
 //seuil double compare
