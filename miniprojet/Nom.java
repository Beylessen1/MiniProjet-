package miniprojet;

public class Nom {
	public String nomDeFamille;
	public String prenom;
	public final int id;
	

	public Nom (String nomDeFamille,String prenom, int id) {
		this.nomDefamille=nomDeFamille;
		this.prenom=prenom;
		this.id=id;
	}
	public String getNomDeFamille() {
		return nom;
	}
	public String getPrenom() {
        return prenom;
        }
	public void setPrenom(String prenom) {
        this.prenom = prenom;
    	
	}
	public void getNom(){
		return(nomDeFamille + "  " + prenom );
	}
	
	

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}
	public String toString() {
        return "Nom{" +"nom='" + nom + '  ' +", prenom='" + prenom + '  ' +", id=" + id +'}';
    	}
	
	

}
