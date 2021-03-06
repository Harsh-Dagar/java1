package DP;

public class MaxSqMatrixWithAllZeros {
    public static int findMaxSquareWithAllZeros(int[][] input) {
        int n=input.length;
        if(n==0){
            return 0;
        }
        int m=input[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            if(input[i][0]==0){
                dp[i][0]=1;
            }
            else{
                dp[i][0]=0;
            }
        }
        for(int i=0;i<m;i++){
            if(input[0][i]==0){
                dp[0][i]=1;
            }
            else{
                dp[0][i]=0;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(input[i][j]==0){
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
                }
                else{
                    dp[i][j]=0;
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(max<dp[i][j]){
                    max=dp[i][j];
                }
            }
        }
        return max;
    }

}
