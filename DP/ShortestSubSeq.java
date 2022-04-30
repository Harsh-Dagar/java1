package DP;
/*
Gary has two string S and V. Now, Gary wants to know the length shortest subsequence in S, which is not a subsequence in V.
Note: The input data will be such that there will always be a solution.
*/

public class ShortestSubSeq {
    static final int MAX=1011;
    public static int solve(String s1,String s2){
        int l1=s1.length();
        int l2=s2.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<=l2;i++){
            dp[0][i]=MAX;
        }
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                int k=j-1;
                for(;k>=0;k--){
                    if(s1.charAt(i-1)==s2.charAt(k)){
                        break;
                    }
                }
                if(k==-1){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],1+dp[i-1][k]);
                }
            }
        }
        return dp[l1][l2];
    }
    
}
