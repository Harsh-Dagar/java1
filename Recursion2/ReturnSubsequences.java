package Recursion2;

public class ReturnSubsequences {
    public static String[] findSubsequences(String str){
        if(str.isEmpty()){
            String ans[]={""};
            return ans;
        }
        String smallAns[]=findSubsequences(str.substring(1));
        String ans[]=new String[2*smallAns.length];
        int i=0;
        for(;i<smallAns.length;i++){
            ans[i]=smallAns[i];
          
        }
        for(int j=0;i<ans.length;i++,j++){
     
            ans[i]=str.charAt(0)+smallAns[j];
        }
        return ans;
    }
}
