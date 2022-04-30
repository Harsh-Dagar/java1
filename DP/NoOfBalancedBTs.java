package DP;


public class NoOfBalancedBTs {

    public static long balancedBTs(long n){
        int mod=(int)Math.pow(10, 9)+7;
        return balancedBTs(n,mod);
    }
    private static long balancedBTs(long n,int mod) {
        if (n == 1||n==0) {
            return 1;
        }
        long x=balancedBTs(n-1);
        long y=balancedBTs(n-2);
        return (((long)x*x)%mod+((long)2*x*y)%mod)%mod;
    }


    private static int balancedBTsDP(int height,int mod){
        int storage[]=new int[height+1];
        storage[0]=1;
        storage[1]=1;
        for(int i=2;i<=height;i++){
            int x=storage[i-1];
            int y=storage[i-2];
            long res1=(long)x*x;
            long res2=(long)2*x*y;
            int value1=(int)(res1%mod);
            int value2=(int)(res2%mod);
            storage[i]=(value1+value2)%mod;
        }
        return storage[height];
    }
    public static int balancedBTsDP(int height){
        int mod=(int)Math.pow(10, 9)+7;
        return balancedBTsDP(height,mod);
    }


}
