package miniprojet;

public interface GenerateurDeCondidat {

		private  List<Nom> ;

		public GenerateurDeCandidats(List<Nom> listeDeNom) {
			this.listeDeNom = listeDeNom;
		}

		public List<Nom> genererCandidats() {
			return listeDeNom;
		}
}
