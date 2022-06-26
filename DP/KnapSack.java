package DP;

public class KnapSack {
    public static int knapsack(int[] weights, int[] values, int i, int n, int maxWeight) {
        if (i >= n || maxWeight <= 0) {
            return 0;
        }
        

        if (maxWeight < weights[i]) {
            int ans = knapsack(weights, values, i + 1, n, maxWeight);
            return ans;
        } else {
            int a = values[i] + knapsack(weights, values, i + 1, n, maxWeight - weights[i]);
            int b = knapsack(weights, values, i + 1, n, maxWeight);
            int ans = Math.max(a, b);
            return ans;
        }
    }

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        return knapsack(weights, values, 0, n, maxWeight);
    }


    public static int knapsackDP(int[] weights, int[] values, int n, int maxWeight) {
        int storage[][] = new int[n + 1][maxWeight+1];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=maxWeight;j++){
                int ans;
                if(j<weights[i]){
                    ans=storage[i+1][j];
                }
                else{
                    int ans1=storage[i+1][j-weights[i]]+values[i];
                    int ans2=storage[i+1][j];
                    ans=Math.max(ans1,ans2);
                }
                storage[i][j]=ans;
            }
        }
        return storage[0][maxWeight];
        
    }
    public static void main(String[] args) {
        int weights[]={1,3,4,6};
        int values[]={20,30,10,50};
        int maxWeight=10;
        System.out.println(knapsack(weights, values, 0, 4, maxWeight));
        
    }
}
