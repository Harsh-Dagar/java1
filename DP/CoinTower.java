package DP;

public class CoinTower {
    public static String findWinner(int n,int x,int y){
        int storage[]=new int[n+1];
        storage[1]=1;
        for(int i=2;i<=n;i++){
            int a=storage[i-1]^1;
            if((i-x)>=0){
                int b=storage[i-x]^1;
                if(b==1){
                    a=1;
                }
            }
            if((i-y)>=0){
                int c=storage[i-y]^1;
                if(c==1){
                    a=1;
                }
            }
            storage[i]=a;
        }
        if(storage[n]==1){
            return "Beerus";
        }
        else{
            return "Whis";
        }
        
    }
}
