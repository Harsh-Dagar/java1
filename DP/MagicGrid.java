package DP;

public class MagicGrid {
    public static int getMinimumStrength(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dp[][] = new int[r+1][c+1];
        for(int i=0;i<=r;i++){
            dp[i][c]=Integer.MAX_VALUE;
        }
        for(int i=0;i<=c;i++){
            dp[r][i]=Integer.MAX_VALUE;
        }
        
        dp[r - 1][c] = 1;
        dp[r][c - 1] = 1;

        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                int a=Math.min(dp[i][j+1],dp[i+1][j])-grid[i][j];
                dp[i][j]=(a<=0)?1:a;
            }
        }
        return dp[0][0];
    }
}
