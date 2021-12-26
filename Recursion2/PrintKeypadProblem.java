package Recursion2;

public class PrintKeypadProblem {
    private static String[] getChar(int n){
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
    private static void printKeypad(int n,String outputSoFar){
        if(n==0){
            System.out.println(outputSoFar);
            return;
        }
        String getCh[]=getChar(n%10);
        for(int i=0;i<getCh.length;i++){
            printKeypad(n/10, getCh[i]+outputSoFar);
        }
    }
    public static void printKeypad(int n){
        printKeypad(n,"");
    }
}
