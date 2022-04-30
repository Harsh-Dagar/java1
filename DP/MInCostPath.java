package DP;

public class MInCostPath {
    public static int minCostPath(int[][] input, int i, int j) {
        if (i == input.length - 1) {
            int sum = 0;
            for (int m = j; m < input[0].length; m++) {
                sum += input[i][m];
            }
            return sum;
        }
        if (j == input.length - 1) {
            int sum = 0;
            for (int m = i; m < input.length; m++) {
                sum += input[m][j];
            }
            return sum;
        }
        int a = minCostPath(input, i + 1, j + 1);
        int b = minCostPath(input, i + 1, j);
        int c = minCostPath(input, i, j + 1);
        int min = Math.min(c, Math.min(a, b));
        return min + input[i][j];
    }

    public static int minCostPath(int[][] input) {
        return minCostPath(input, 0, 0);
    }

    private static int minCostPathM(int[][] input, int i, int j, int memo[][]) {
        int m = input.length;
        int n = input[0].length;
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (i == m - 1 && j == n - 1) {
            memo[i][j] = input[i][j];
            return input[i][j];
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int a = minCostPathM(input, i + 1, j + 1, memo);
        int b = minCostPathM(input, i + 1, j, memo);
        int c = minCostPathM(input, i, j + 1, memo);
        memo[i][j] = input[i][j] + Math.min(c, Math.min(a, b));
        return memo[i][j];
    }

    public static int minCostPathM(int[][] input) {
        int memo[][] = new int[input.length][input[0].length];
        return minCostPathM(input, 0, 0, memo);
    }

    public static int minCostPathDP(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        int storage[][] = new int[m][n];
        storage[m-1][n-1]=input[m-1][n-1];
        for(int i=m-2;i>=0;i--){
            storage[i][n-1]=storage[i+1][n-1]+input[i][n-1];
        }
        for(int i=n-2;i>=0;i--){
            storage[m-1][i]=storage[m-1][i+1]+input[m-1][i];
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                storage[i][j]=Math.min(storage[i+1][j+1],Math.min(storage[i+1][j],storage[i][j+1]))+input[i][j];
            }
        }
        return storage[0][0];
 
    }
}
