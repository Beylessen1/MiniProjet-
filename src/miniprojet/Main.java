
import java.util.*;

public class Main {
        private static final MoteurDeRecherche moteur = new MoteurDeRecherche();
        private static final LecteurDeFichier lecteur = new LecteurDeFichierCSV();
        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            while (true) {
                afficherMenuPrincipal();
                String choix = scanner.nextLine();
                switch (choix) {
                    case "1" -> effectuerRecherche();
                    case "2" -> comparerDeuxListes();
                    case "3" -> effectuerDedupliquerListe();
                    case "4" -> configurerParametres();
                    case "5" -> {
                        System.out.println("Fin du programme.");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Choix invalide.");
                }
            }
        }

        private static void afficherMenuPrincipal() {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Effectuer une recherche");
            System.out.println("2. Comparer deux listes");
            System.out.println("3. Dédupliquer une liste");
            System.out.println("4. Configurer les paramètres");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
        }

        private static void afficherMenuConfiguration() {
            System.out.println("\n===== MENU CONFIGURATION =====");
            System.out.println("1. Choisir les prétraitements");
            System.out.println("2. Choisir une mesure de comparaison");
            System.out.println("3. Choisir un générateur de candidats");
            System.out.println("4. Choisir un sélecteur");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
        }

        private static void configurerParametres() {
            while (true) {
                afficherMenuConfiguration();
                String choix = scanner.nextLine();
                switch (choix) {
                    case "1" -> choixPretraiteurs();
                    case "2" -> choixComparateur();
                    case "3" -> choixGenerateurDeCandidats();
                    case "4" -> choixSelectionneur();
                    case "5" -> {
                        return;
                    }
                    default -> System.out.println("Choix invalide.");
                }
            }
        }

        private static void afficherMenuPretraiteurs() {
            System.out.println("\n===== MENU PRETRAITEUR =====");
            System.out.println("Le prétraitement par défaut est PretraiteurCleanName");
            System.out.println("1. Supprimer PretraiteurCleanName");
            System.out.println("2. Ajouter PretraiteurNormalizer");
            System.out.println("3. Ajouter PretraiteurPhonetique");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
        }

        private static void choixPretraiteurs() {
            while (true) {
                afficherMenuPretraiteurs();
                String choix = scanner.nextLine();
                switch (choix) {
                    case "1" -> supprimerPretraiteurCleanName();
                    case "2" -> ajouterPretraiteurNormalizer();
                    case "3" -> ajouterPretraiteurPhonetique();
                    case "4" -> {
                        return;
                    }
                    default -> System.out.println("Choix invalide.");
                }
            }
        }

        private static void supprimerPretraiteurCleanName() {
            List<Pretraiteur> pretraiteurs = moteur.getPretraiteurs();
            pretraiteurs.removeIf(p -> p instanceof PretraiteurCleanName);
            if (pretraiteurs.isEmpty()) {
                pretraiteurs.add(new PretraiteurCleanName());
                System.out.println("PretraiteurCleanName rétabli comme prétraitement par défaut.");
            }
        }

        private static void ajouterPretraiteurNormalizer() {
            moteur.getPretraiteurs().add(new PretraiteurNormalizer());
            System.out.println("PretraiteurNormalizer ajouté.");
        }

        private static void ajouterPretraiteurPhonetique() {
            moteur.getPretraiteurs().add(new PretraiteurPhonetique());
            System.out.println("PretraiteurPhonetique ajouté.");
        }

        private static void afficherMenuComparateur() {
            System.out.println("\n===== MENU COMPARATEUR =====");
            System.out.println("1. Choisir ComparateurExacte");
            System.out.println("2. Choisir ComparateurJaroWinkler");
            System.out.println("3. Choisir ComparateurLevenshtein");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
        }

        private static void choixComparateur() {
            while (true) {
                afficherMenuComparateur();
                String choix = scanner.nextLine();
                switch (choix) {
                    case "1" -> {
                        moteur.setComparateurDeNoms( new ComparateurExacte());
                    }
                    case "2" -> {
                        moteur.setComparateurDeNoms( new ComparateurJaroWinkler());
                    }
                    case "3" -> moteur.setComparateurDeNoms(new ComparateurLevenshtein());
                    case "4" -> {
                        return;
                    }
                    default -> System.out.println("Choix invalide.");
                }
            }
        }

        private static void afficherMenuGenerateurDeCandidats() {
            System.out.println("\n===== MENU GENERATEUR DE CANDIDATS =====");
            System.out.println("1. Choisir GenerateurDeCondidatSimple");
            System.out.println("2. Choisir GenerateurDeCondidatBaseLongueur");
            System.out.println("3. Choisir GenerateurDeCondidatPrefixe");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");
        }

        private static void choixGenerateurDeCandidats() {
            while (true) {
                afficherMenuGenerateurDeCandidats();
                String choix = scanner.nextLine();
                switch (choix) {
                    case "1" -> moteur.setGenerateurDeCandidats(new GenerateurDeCondidatSimple());
                    case "2" -> moteur.setGenerateurDeCandidats(new GenerateurDeCondidatBaseLongueur());
                    case "3" -> moteur.setGenerateurDeCandidats(new GenerateurDeCondidatPrefixe());
                    case "4" -> {
                        return;
                    }
                    default -> System.out.println("Choix invalide.");
                }
            }
        }

        private static void afficherMenuSelectionneur() {
            System.out.println("\n===== MENU SELECTIONNEUR =====");
            System.out.println("1. Choisir SelectionneurNeRienFaire");
            System.out.println("2. Choisir SelectionneurParSeuil");
            System.out.println("3. Choisir SelectionneurNPremier");
            System.out.println("4. Choisir SelectionneurTopScore");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
        }

        private static void choixSelectionneur() {
            while (true) {
                afficherMenuSelectionneur();
                String choix = scanner.nextLine();
                switch (choix) {
                    case "1" -> moteur.setSelectionneur(new SelectionneurNeRienFaire());
                    case "2" -> {
                        System.out.print("Entrez le seuil (0.0 à 1.0, ex: 0.8 : ");
                        double seuil = scanner.nextDouble();
                        scanner.nextLine();
                        moteur.setSelectionneur(new SelectionneurParSeuil(seuil));
                    }
                    case "3" -> {
                        System.out.print("Entrez le nombre de résultats à sélectionner : ");
                        int n = scanner.nextInt();
                        scanner.nextLine();
                        moteur.setSelectionneur(new SelectionneurNPremier(n));
                    }
                    case "4" -> moteur.setSelectionneur(new SelectionneurTopScore());
                    case "5" -> {
                        return;
                    }
                    default -> System.out.println("Choix invalide.");
                }
            }
        }

        private static void effectuerRecherche() {
            System.out.print("Entrez le nom à rechercher : ");
            String nomRecherche = scanner.nextLine();
            System.out.print("Entrez le chemin du fichier CSV : ");
            String filepath = scanner.nextLine();
            Nom nom = new Nom(nomRecherche, "-1");
            List<Nom> listeNoms = lecteur.lireFichier(filepath);
            if (listeNoms == null || listeNoms.isEmpty()) {
                System.out.println("Erreur : la liste des candidats est vide ou n'a pas pu être chargée.");
                return;
            }
            long start = System.currentTimeMillis();
            List<CoupleDeNomAvecScore> resultats = moteur.rechercher(nom, listeNoms);
            long end = System.currentTimeMillis();
            System.out.println("\nRésultats pour : " + nom.getNom());
            if (resultats.isEmpty()) {
                System.out.println("Aucun résultat trouvé.");
            } else {
                for (CoupleDeNomAvecScore couple : resultats) {
                    System.out.printf("Nom: %s (ID: %s, Score: %.2f)%n",
                            couple.nom2().getNom(), couple.nom2().getId(), couple.score());
                }
            }
            System.out.println("Temps d'exécution : " + (end - start) + " ms");
        }

        private static void comparerDeuxListes() {
            System.out.print("Entrez le chemin du premier fichier CSV : ");
            String filepath1 = scanner.nextLine();
            List<Nom> liste1 = lecteur.lireFichier(filepath1);
            if (liste1 == null || liste1.isEmpty()) {
                System.out.println("Erreur : la liste 1 est vide ou n'a pas pu être chargée.");
                return;
            }
            System.out.print("Entrez le chemin du deuxième fichier CSV : ");
            String filepath2 = scanner.nextLine();
            List<Nom> liste2 = lecteur.lireFichier(filepath2);
            if (liste2 == null || liste2.isEmpty()) {
                System.out.println("Erreur : la liste 2 est vide ou n'a pas pu être chargée.");
                return;
            }
            long start = System.currentTimeMillis();
            List<CoupleDeNomAvecScore> resultats = moteur.comparer(liste1, liste2);
            long end = System.currentTimeMillis();
            if (resultats.isEmpty()) {
                System.out.println("Aucun résultat trouvé.");
            } else {
                for (CoupleDeNomAvecScore couple : resultats) {
                    System.out.printf("Nom1: %s (ID: %s), Nom2: %s (ID: %s), Score: %.2f%n",
                            couple.nom1().getNom(), couple.nom1().getId(),
                            couple.nom2().getNom(), couple.nom2().getId(), couple.score());
                }
            }
            System.out.println("Temps d'exécution : " + (end - start) + " ms");
        }

        private static void effectuerDedupliquerListe() {
            System.out.print("Entrez le chemin du fichier CSV : ");
            String filepath = scanner.nextLine();
            List<Nom> liste = lecteur.lireFichier(filepath);
            if (liste == null || liste.isEmpty()) {
                System.out.println("Erreur : la liste est vide ou n'a pas pu être chargée.");
                return;
            }
            long start = System.currentTimeMillis();
            List<CoupleDeNomAvecScore> resultats = moteur.dedupliquer(liste);
            long end = System.currentTimeMillis();

            if (resultats.isEmpty()) {
                System.out.println("Aucun doublon trouvé.");
            } else {
                Map<String, List<Nom>> groupeDeDoublons = new HashMap<>();
                for (CoupleDeNomAvecScore couple : resultats) {
                    String nom = couple.nom1().getNom();
                    groupeDeDoublons.computeIfAbsent(nom, k -> new ArrayList<>());
                    if (!groupeDeDoublons.get(nom).contains(couple.nom1())) {
                        groupeDeDoublons.get(nom).add(couple.nom1());
                    }
                    if (!groupeDeDoublons.get(nom).contains(couple.nom2())) {
                        groupeDeDoublons.get(nom).add(couple.nom2());
                    }
                }
                System.out.println("\nDoublons trouvés :");
                for (Map.Entry<String, List<Nom>> entree : groupeDeDoublons.entrySet()) {
                    String nom = entree.getKey();
                    List<Nom> noms = entree.getValue();
                    System.out.print("Nom: " + nom + " (répété " + noms.size() + " fois) - IDs: ");
                    for (int i = 0; i < noms.size(); i++) {
                        System.out.print(noms.get(i).getId());
                        if (i < noms.size() - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                }
            }
            System.out.println("Temps d'exécution : " + (end - start) + " ms");
        }
}