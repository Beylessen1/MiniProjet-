
import java.util.List;

public class ComparateurLevenshtein implements ComparateurDeNom {
    public List<CoupleDeNomAvecScore> comparer(Nom nom1, Nom nom2) {
        double score = calculateLevenshtein(nom1.getNom(), nom2.getNom());
        return List.of(new CoupleDeNomAvecScore(nom1, nom2, score));
    }

    private double calculateLevenshtein(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 && len2 == 0) return 1.0;
        if (len1 == 0 || len2 == 0) return 0.0;

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int j = 0; j <= len2; j++) dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cost = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + cost
                );
            }
        }

        int maxLen = Math.max(len1, len2);
        return 1.0 - (double) dp[len1][len2] / maxLen;
    }
}