package DP;

public class LCS {
    public static int lcs(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l1 == 0 || l2 == 0) {
            return 0;
        }
        if (str1.charAt(0) == str2.charAt(0)) {
            int smallAns = lcs(str1.substring(1), str2.substring(1));
            return smallAns + 1;
        } else {
            int a = lcs(str1.substring(1), str2);
            int b = lcs(str1, str2.substring(1));
            return Math.max(a, b);
        }
    }

    private static int lcsM(String str1, String str2, int[][] storage) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l1 == 0) {
            storage[0][l2] = 0;
            return 0;
        }
        if (l2 == 0) {
            storage[l1][0] = 0;
            return 0;
        }
        if (storage[l1][l2] != -1) {
            return storage[l1][l2];
        }
        if (str1.charAt(0) == str2.charAt(0)) {

            int smallAns = lcsM(str1.substring(1), str2.substring(1), storage);
            storage[l1][l2] = smallAns + 1;
            return smallAns + 1;

        } else {
            int a;
            if (storage[l1 - 1][l2] != -1) {
                a = storage[l1 - 1][l2];
            } else {
                a = lcsM(str1.substring(1), str2, storage);
                storage[l1 - 1][l2] = a;
            }
            int b;
            if (storage[l1][l2 - 1] != -1) {
                b = storage[l1][l2 - 1];
            } else {
                b = lcsM(str1, str2.substring(1), storage);
                storage[l1][l2 - 1] = b;
            }
            int ans = Math.max(a, b);
            storage[l1][l2] = ans;
            return ans;
        }
    }

    public static int lcsM(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int storage[][] = new int[l1 + 1][1 + l2];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                storage[i][j] = -1;
            }
        }
        return lcsM(str1, str2, storage);
    }

    public static int lcsDP(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int storage[][] = new int[l1 + 1][1 + l2];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (str1.charAt(l1 - i) == str2.charAt(l2 - j)) {
                    storage[i][j] = storage[i - 1][j - 1] + 1;
                } else {
                    int a = storage[i - 1][j];
                    int b = storage[i][j - 1];
                    storage[i][j] = Math.max(a, b);
                }
            }
        }
        return storage[l1][l2];
    }
}
