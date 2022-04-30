package DP;

public class WayToMakeCoinChange {
    public static int countWaysToMakeChange(int denominations[], int i,int value){
        if(value==0){
            return 1;
        }
        if(value<0){
            return 0;
        }
        if(i>=denominations.length&&value>=1){
            return 0;
        }
        int a=countWaysToMakeChange(denominations, i+1, value);
        int b=countWaysToMakeChange(denominations, i, value-denominations[i]);
        return a+b;

    }
    public static int countWaysToMakeChange(int denominations[],int value){
        return countWaysToMakeChange(denominations, 0, value);
    }

    public static int countWaysToMakeChangeDP(int denominations[],int value){
        int l=denominations.length;
        int dp[]=new int[value+1];
        dp[0]=1;

        for(int i=0;i<l;i++){
            for(int j=denominations[i];j<=value;j++){
                dp[j]+=dp[j-denominations[i]];
            }
        }
        return dp[value];


    }


}
