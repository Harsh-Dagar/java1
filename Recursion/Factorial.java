package Recursion;

public class Factorial {
    long fact(int n){
        if(n==0){
            return 1; 
        }
        long smallAns=fact(n-1);
        return n*smallAns;
    }
}

