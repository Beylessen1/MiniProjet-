package miniprojet;

public class ComparateurExacte implements ComparateurDeChaine{
  public int Comparer(Nom nom1, Nom nom2){
    String x1= nom1.getNom();
    String x2= nom2.getNom();
    if (x1.equals(x2)) {
        return 1;
    } else {
        return 0;
  }
}
