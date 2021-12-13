package Recursion;

public class SumOfNaturalNumbers {
    public int sum(int n){
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }
}
