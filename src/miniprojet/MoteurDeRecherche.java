import java.util.*;

public class MoteurDeRecherche {
    private GenerateurDeCondidat generateurDeCandidats;
    private List<Pretraiteur> pretraiteurs;
    private ComparateurDeNom comparateurDeNoms;
    private Selectionneur selectionneur;

    public MoteurDeRecherche() {
        this.generateurDeCandidats = new GenerateurDeCondidatSimple();
        this.pretraiteurs = new ArrayList<>();
        this.pretraiteurs.add(new PretraiteurCleanName());
        this.comparateurDeNoms = new ComparateurExacte();
        this.selectionneur = new SelectionneurNeRienFaire();
    }

    public MoteurDeRecherche(GenerateurDeCondidat generateurDeCandidats, List<Pretraiteur> pretraiteurs,
                             ComparateurDeNom comparateurDeNoms, Selectionneur selectionneur) {
        this.generateurDeCandidats = generateurDeCandidats;
        this.pretraiteurs = pretraiteurs;
        this.comparateurDeNoms = comparateurDeNoms;
        this.selectionneur = selectionneur;
    }

    public GenerateurDeCondidat getGenerateurDeCandidats() {
        return generateurDeCandidats;
    }

    public void setGenerateurDeCandidats(GenerateurDeCondidat generateurDeCandidats) {
        this.generateurDeCandidats = generateurDeCandidats;
    }

    public List<Pretraiteur> getPretraiteurs() {
        return pretraiteurs;
    }

    public void setPretraiteurs(List<Pretraiteur> pretraiteurs) {
        this.pretraiteurs = pretraiteurs;
    }

    public ComparateurDeNom getComparateurDeNoms() {
        return comparateurDeNoms;
    }

    public void setComparateurDeNoms(ComparateurDeNom comparateurDeNoms) {
        this.comparateurDeNoms = comparateurDeNoms;
    }

    public Selectionneur getSelectionneur() {
        return selectionneur;
    }

    public void setSelectionneur(Selectionneur selectionneur) {
        this.selectionneur = selectionneur;
    }

    public List<CoupleDeNomAvecScore> rechercher(Nom nomRecherche, List<Nom> listeNoms) {
        List<Nom> nomsTraites = listeNoms;
        List<Nom> rechercheTraitee = new ArrayList<>();
        rechercheTraitee.add(nomRecherche);

        for (Pretraiteur pretraiteur : pretraiteurs) {
            nomsTraites = pretraiteur.traiter(nomsTraites);
            rechercheTraitee = pretraiteur.traiter(rechercheTraitee);
        }

        nomRecherche = rechercheTraitee.get(0);
        List<CoupleDeNom> candidats = generateurDeCandidats.generer(nomRecherche, nomsTraites);
        List<CoupleDeNomAvecScore> scores = new ArrayList<>();
        for (CoupleDeNom couple : candidats) {
            scores.addAll(comparateurDeNoms.comparer(couple.nom1(), couple.nom2()));
        }

        return selectionneur.est_acceptable(scores);
    }

    public List<CoupleDeNomAvecScore> comparer(List<Nom> liste1, List<Nom> liste2) {
        List<Nom> nomsTraites1 = liste1;
        List<Nom> nomsTraites2 = liste2;

        for (Pretraiteur pretraiteur : pretraiteurs) {
            nomsTraites1 = pretraiteur.traiter(nomsTraites1);
            nomsTraites2 = pretraiteur.traiter(nomsTraites2);
        }

        List<CoupleDeNomAvecScore> resultats = new ArrayList<>();
        for (Nom nom1 : nomsTraites1) {
            List<CoupleDeNom> candidats = generateurDeCandidats.generer(nom1, nomsTraites2);
            for (CoupleDeNom couple : candidats) {
                resultats.addAll(comparateurDeNoms.comparer(couple.nom1(), couple.nom2()));
            }
        }

        return selectionneur.est_acceptable(resultats);
    }

    public List<CoupleDeNomAvecScore> dedupliquer(List<Nom> listeNoms) {
        List<Nom> nomsTraites = listeNoms;
        for (Pretraiteur pretraiteur : pretraiteurs) {
            nomsTraites = pretraiteur.traiter(nomsTraites);
        }

        Map<String, List<Nom>> occurrencesParNom = new HashMap<>();
        for (Nom nom : nomsTraites) {
            String nomTexte = nom.getNom();
            occurrencesParNom.computeIfAbsent(nomTexte, k -> new ArrayList<>()).add(nom);
        }

        List<CoupleDeNomAvecScore> doublons = new ArrayList<>();
        for (Map.Entry<String, List<Nom>> entree : occurrencesParNom.entrySet()) {
            List<Nom> occurrences = entree.getValue();
            if (occurrences.size() > 1) {
                for (int i = 0; i < occurrences.size(); i++) {
                    for (int j = i + 1; j < occurrences.size(); j++) {
                        Nom nom1 = occurrences.get(i);
                        Nom nom2 = occurrences.get(j);
                        doublons.add(new CoupleDeNomAvecScore(nom1, nom2, 1.0));
                    }
                }
            }
        }

        return selectionneur.est_acceptable(doublons);
    }
    }

