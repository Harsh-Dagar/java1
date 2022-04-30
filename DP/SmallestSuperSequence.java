package DP;

public class SmallestSuperSequence {
    public static int smallestSuperSequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l1 == 0) {
            return l2;
        }
        if (l2 == 0) {
            return l1;
        }
        if (str1.charAt(0) == str2.charAt(0)) {
            int smallAns = smallestSuperSequence(str1.substring(1), str2.substring(1));
            return smallAns + 1;
        } else {
            int a = smallestSuperSequence(str1.substring(1), str2);
            int b = smallestSuperSequence(str1, str2.substring(1));
            return Math.min(a, b) + 1;
        }
    }

    public static int smallestSuperSequenceDP(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int dp[][] = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (str1.charAt(l1 - j) == str2.charAt(l2 - j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int a = dp[i - 1][j];
                    int b = dp[i][j - 1];
                    dp[i][j] = Math.min(a, b) + 1;
                }
            }
        }
        return dp[l1][l2];
    }
}
