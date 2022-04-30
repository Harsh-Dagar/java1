package DP;
/*
 Given two integers a and b. You need to find and return the count of possible ways in which we can represent the number a as the sum of unique integers raise to the power b.

 For example: if a = 10 and b = 2, only way to represent 10 as sum of unique integers raised to power 2 is-
 10 = 1^2 + 3^2 
Hence, answer is 1.
Note : x^y represents x raise to the power y
 */

public class AllPosibleWays {
    private static int allWays(int s,int n,int base){
        int res=(int)Math.pow(base, n);
        if(res==s){
            return 1;
        }
        if(res>s){
            return 0;
        }
        int a=allWays(s-res, n, base+1);
        int b=allWays(s, n, base+1);
        return a+b;
    }
    public static int allWays(int x,int n){
        return allWays(x,n,1);
    }

    // public static int allWaysDP(int x,int n){

    // }
}
