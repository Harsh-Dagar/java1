package Recursion;

public class FibonacciNumber {
    // int fib(int n) returns nth fibonacci number
    public int fib(int n){
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        int ans=fib(n-1)+fib(n-2);
        return ans;
    }
}
