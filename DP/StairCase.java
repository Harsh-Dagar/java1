package DP;

public class StairCase {
    public static long staircase(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        long a = staircase(n - 1);
        if (n > 2) {
            a += staircase(n - 2);
        }
        if (n > 3) {
            a += staircase(n - 3);

        }
        return a;
    }

    private static long staircase(int n,long storage[]){
        if(n==0||n==1){
            storage[n]=1;
            return storage[n];
        }
        long a=0;
        if(storage[n-1]!=0){
            a=storage[n-1];
        }
        else{
            a=staircase(n-1,storage);
            storage[n-1]=a;
        }
        if(n>=2){
            if(storage[n-2]!=0){
                long b=storage[n-2];
                a+=b;
            }
            else{
                long b=staircase(n-2,storage);
                storage[n-2]=b;
                a+=b;
            }
        }
        if(n>=3){
            if(storage[n-3]!=0){
                long b=storage[n-3];
                a+=b;
            }
            else{
                long b=staircase(n-3,storage);
                storage[n-3]=b;
                a+=b;
            }
        }
        storage[n]=a;
        return a;
    }
    public static long staircaseM(int n){
        long storage[]=new long[n+1];
        return staircase(n,storage);
    }

    public static long staircaseDP(int n){
        long storage[]=new long[n+1];
        storage[0]=1;
        storage[1]=1;
        for(int i=2;i<=n;i++){
            long a=storage[i-1];
            if(i>=2){
                a+=storage[i-2];
            }
            if(i>=3){
                a+=storage[i-3];
            }
            storage[i]=a;
        }
        return storage[n];
    }
}
