package Recursion;

public class SumOfDigits {
    public static int sumOfDigits(int input){
		// Write your code here
        if(input<=9){
            return input;
        }
        int smallInput=input/10;
        int ans=input%10+sumOfDigits(smallInput);
        return ans;
	}
}
