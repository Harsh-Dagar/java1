package Recursion2;

public class RemoveConsecutiveDuplicates {
    public static String removeConsecutiveDuplicates(String s){
        if(s.length()<=1){
            return s;
        }
        String smallAns=removeConsecutiveDuplicates(s.substring(1));
        String ans="";
        if(s.charAt(0)==s.charAt(1)){
            ans=s.charAt(0)+smallAns.substring(1);
        }
        if(s.charAt(0)!=s.charAt(1)){
            ans=s.charAt(0)+smallAns;
        }
        return ans;
    }
}
