import java.util.List;

public class ComparateurJaroWinkler implements ComparateurDeNom {
    public List<CoupleDeNomAvecScore> comparer(Nom nom1, Nom nom2) {
        double score = calculateJaroWinkler(nom1.getNom(), nom2.getNom());
        return List.of(new CoupleDeNomAvecScore(nom1, nom2, score));
    }

    private double calculateJaroWinkler(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 && len2 == 0) return 1.0;
        if (len1 == 0 || len2 == 0) return 0.0;

        int maxDist = Math.max(len1, len2) / 2 - 1;
        int matches = 0;
        int transpositions = 0;
        int[] matches1 = new int[len1];
        int[] matches2 = new int[len2];

        for (int i = 0; i < len1; i++) {
            int start = Math.max(0, i - maxDist);
            int end = Math.min(len2, i + maxDist + 1);
            for (int j = start; j < end; j++) {
                if (matches2[j] == 0 && s1.charAt(i) == s2.charAt(j)) {
                    matches1[i] = 1;
                    matches2[j] = 1;
                    matches++;
                    break;
                }
            }
        }

        if (matches == 0) return 0.0;

        int k = 0;
        for (int i = 0; i < len1; i++) {
            if (matches1[i] == 1) {
                while (matches2[k] == 0) k++;
                if (s1.charAt(i) != s2.charAt(k)) transpositions++;
                k++;
            }
        }

        double jaro = ((double) matches / len1 + (double) matches / len2 + (double) (matches - transpositions / 2.0) / matches) / 3.0;

        int prefixLen = 0;
        for (int i = 0; i < Math.min(4, Math.min(len1, len2)); i++) {
            if (s1.charAt(i) == s2.charAt(i)) prefixLen++;
            else break;
        }

        return jaro + prefixLen * 0.1 * (1.0 - jaro);
    }
}
