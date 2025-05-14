
import java.util.Objects;

public class Nom {
        private String nom;
        private String id;

        public Nom(String id, String nom) {
            this.nom = nom;
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


        public String toString() {
            return "Nom{nom='" + nom + "', id='" + id + "'}";
        }


        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Nom other = (Nom) o;
            return Objects.equals(nom, other.nom) && Objects.equals(id, other.id);
        }


        public int hashCode() {
            return Objects.hash(nom, id);
        }
    }

