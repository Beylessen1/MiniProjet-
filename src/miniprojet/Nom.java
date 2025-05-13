package miniprojet;

public class Nom {
	private String nom;
	
	private final String id;
	

	public Nom (String id, String nom) {
		this.nom=nom;
		this.id=id;
	}
	public Nom (String nom) {
		this.nom=nom;
		
	}
	public String getNom() {
		return nom;
	}
	
	public String setNom(String nom) {
		return(this.nom=nom);
		
	}

	public String getId() {
		return id;
	}

	

}
