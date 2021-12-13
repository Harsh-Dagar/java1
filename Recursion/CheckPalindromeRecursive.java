package Recursion;


public class CheckPalindromeRecursive {
    public static boolean isStringPalindrome(String input) {
		// Write your code here
        return isStringPalindrome(input,0,input.length()-1);

	}
    private static boolean isStringPalindrome(String input,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return true;
        }
        boolean ans=isStringPalindrome(input,startIndex+1,endIndex-1);
        if(ans==false){
            return false;
        }
        else{
            if(input.charAt(startIndex)==input.charAt(endIndex)){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(isStringPalindrome("harah"));
    }
}
