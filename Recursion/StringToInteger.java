package Recursion;


public class StringToInteger {
    private static int placeOfDigit(int n){
        int ans=1;
        for(int i=1;i<n;i++){
            ans=ans*10;
        }
        return ans;
    }
    public static int convertStringToInt(String input){
        if(input.length()==0){
            return 0;
        }
        int smallAns=convertStringToInt(input.substring(1));
        int temp=input.charAt(0)-'0';
        int finalAns=temp*placeOfDigit(input.length())+smallAns;
        return finalAns;
    }
}
