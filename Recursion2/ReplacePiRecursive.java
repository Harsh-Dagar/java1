package Recursion2;

public class ReplacePiRecursive {
    
    public static String replacePi(String input){
        if(input.length()<=1){
            return input;
        }
        String ans="";
        String smallAns="";
        if(input.substring(0,2).equals("pi")){
            ans="3.14";
            smallAns=replacePi(input.substring(2));
        }
        else{
            ans=ans+input.charAt(0);
            smallAns=replacePi(input.substring(1));
            
        }
        
        return ans+smallAns;
    }
    public static String replace2(String input){
        if(input.length()<=1){
            return input;
        }
        String ans="";
        String smallAns=replace2(input.substring(1));
        if(input.charAt(0)=='p'&&input.charAt(1)=='i'){
            ans="3.14"+smallAns.substring(1);
        }
        else{
            ans=input.charAt(0)+smallAns;
        }
        return ans;

    }
}
