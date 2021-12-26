package Recursion2;

public class ReturnKeypadProblem {
    private static String[] returnChar(int n){
        if(n==0||n==1){
            String str[]={""};
            return str;
        }
        if(n==2){
            String str[]={"a","b","c"};
            return str;
        }
        else if(n==3){
            String str[]={"d","e","f"};
            return str;
        }
        else if(n==4){
            String str[]={"g","h","i"};
            return str;
        }
        else if(n==5){
            String str[]={"j","k","l"};
            return str;
        }
        else if(n==6){
            String str[]={"m","n","o"};
            return str;
        }
        else if(n==7){
            String str[]={"p","q","r","s"};
            return str;
        }
        else if(n==8){
            String str[]={"t","u","v"};
            return str;
        }
        else{
            String str[]={"w","x","y","z"};
            return str;
        }
    }
    public static String[] keypad(int n){
        if(n==0){
            String str[]={""};
            return str;
        }
        int k=0;
        String smallAns[]=keypad(n/10);
        String str[]=returnChar(n%10);
        String ans[]=new String[str.length*smallAns.length];
        for(int i=0;i<str.length;i++){
            for(int j=0;j<smallAns.length;j++){
                ans[k]=smallAns[j]+str[i];
                k++;
            }
        }
        return ans;
    }
}
