package miniprojet;

public class Nom {
	public String nom;
	public final int id;
	

	public Nom (String nom, int id) {
		this.nom=nom;
		this.id=id;
	}

	/*public Boolean equals(Object o){
		this.nom.equals(o.)
	}*/ //nzidha??
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}
	
	

}
