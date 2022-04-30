package DP;

public class EditDistance {
    public static int editDistance(String s1, String s2) {
        if (s1.length() == 0) {
            return s2.length();
        }
        if (s2.length() == 0) {
            return s1.length();
        }

        if (s1.charAt(0) == s2.charAt(0)) {
            return editDistance(s1.substring(1), s2.substring(1));
        } else {
            // replace
            int a = editDistance(s1.substring(1), s2.substring(1));
            // delete
            int b = editDistance(s1.substring(1), s2);
            // insert
            int c = editDistance(s1, s2.substring(1));
            int ans = Math.min(c, Math.min(a, b));
            return ans + 1;
        }
    }

    public static int editDistanceM(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int storage[][] = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                storage[i][j] = -1;
            }
        }
        return editDistanceM(s1, s2, storage);
    }

    private static int editDistanceM(String s1, String s2, int[][] storage) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (storage[l1][l2] != -1) {
            return storage[l1][l2];
        }
        if (l1 == 0) {
            storage[0][l2] = l2;
            return l2;
        }
        if (l2 == 0) {
            storage[l1][0] = l1;
            return l1;
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            int ans = editDistance(s1.substring(1), s2.substring(1));
            storage[l1][l2] = ans;
            return ans;
        }

        // delete
        int a;
        if (storage[l1 - 1][l2] != -1) {
            a = storage[l1 - 1][l2];
        } else {
            a = editDistanceM(s1.substring(1), s2, storage);
            storage[l1 - 1][l2] = a;
        }
        // insert
        int b;
        if (storage[l1][l2 - 1] != -1) {
            b = storage[l1][l2 - 1];
        } else {
            b = editDistanceM(s1, s2.substring(1), storage);
            storage[l1][l2 - 1] = b;
        }
        // replace
        int c;
        if (storage[l1 - 1][l2 - 1] != -1) {
            c = storage[l1 - 1][l2 - 1];
        } else {
            c = editDistanceM(s1.substring(1), s2.substring(1), storage);
            storage[l1 - 1][l2 - 1] = c;
        }
        storage[l1][l2] = 1 + Math.min(c, Math.min(a, b));
        return storage[l1][l2];
    }

    public static int editDistanceDP(String s1,String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int[][]storage=new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            storage[i][0]=i;
        }
        for(int i=0;i<=l2;i++){
            storage[0][i]=i;
        }
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(l1-i)==s2.charAt(l2-j)){
                    storage[i][j]=storage[i-1][j-1];
                }
                else{
                    int a=storage[i-1][j-1];
                    int b=storage[i][j-1];
                    int c=storage[i-1][j];
                    int ans=1+Math.min(c,Math.min(a, b));
                    storage[i][j]=ans;
                }
            }
        }
        return storage[l1][l2];
    }
}
