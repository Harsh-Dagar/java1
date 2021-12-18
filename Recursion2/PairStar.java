package Recursion2;


public class PairStar {
    public static String addStars(String s) {
		// Write your code here
        if(s.length()<=1){
            return s;
        }
        String ans="";
        String smallAns=addStars(s.substring(1));
        if(s.charAt(0)==s.charAt(1)){
            ans=s.charAt(0)+"*"+smallAns;
        }
        else{
            ans=s.charAt(0)+smallAns;
        }
        return ans;

	}
}
