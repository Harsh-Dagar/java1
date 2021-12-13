package Recursion;

public class RecursiveMultiplication {
	public static int multiplyTwoIntegers(int m, int n){
		// Write your code here
        if(n==1){
            return m;
        }
        int ans=m+multiplyTwoIntegers(m, n-1);
        return ans;
	}
}
