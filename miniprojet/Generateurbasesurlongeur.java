package miniprojet;
import java.util.ArrayList;
public class Generateurbasesurlongeur implements GenerateurDeCandidats {
  public List<Nom> genererCandidats(Nom nom, List<Nom> liste1){
    int longueur= (nom.getNom()).length();
    List<Nom> liste_candidats = new ArrayList<>();
    for (Nom i : liste1){
      int j = i.length();
      if (j==longueur){
        liste_candidats.add(i);
      }
     return liste_candidats;
  }
    
  
}
//=- 3 lettre
