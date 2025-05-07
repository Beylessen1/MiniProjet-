package miniprojet;

public class Nom {
	private String nom;
	
	private final int id;
	

	public Nom (String nom, int id) {
		this.nom=nom;
		this.id=id;
	}
	public String getNom() {
		return nom;
	}

	
	public String setNom(String nom) {
		return(this.nom=nom);
		
	}
	
	

	

	public int getId() {
		return id;
	}

	

}
