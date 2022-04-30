package DP;

public class SubsetSumToK {
    static boolean isSubsetPresent(int arr[],int n,int sum){
        boolean storage[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            storage[i][0]=true;
        }
        for(int i=0;i<=sum;i++){
            storage[0][sum]=false;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j){
                    storage[i][j]=storage[i-1][j];
                }
                else{
                    storage[i][j]=storage[i-1][j]||storage[i-1][j-arr[i-1]];
                }
            }
        }
        return storage[n][sum];

    }
}
