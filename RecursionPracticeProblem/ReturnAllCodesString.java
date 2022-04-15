package RecursionPracticeProblem;
/*
   Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric
   string S. Write a program to return the list of all possible codes that can be
   generated from the given string.

   Note : The order of codes are not important. And input string does not contain 0s.
   Input format :
*/
public class ReturnAllCodesString {
    private static char getChar(int n){
        return (char)('a'+n-1);
    }
    public static String[] getCode(String input){
        if(input.length()==0){
            String str[]={input};
            return str;
        }
        String output1[]=getCode(input.substring(1));
        char getChar=getChar(Integer.parseInt(input.charAt(0)+""));
        for(int i=0;i<output1.length;i++){
            output1[i]=getChar+output1[i];
        }
        String output2[]=new String[0];
        if(input.length()>=2&&Integer.parseInt(input.substring(0,2))<=26){
            output2=getCode(input.substring(2));
            getChar=getChar(Integer.parseInt(input.substring(0,2)));
            for(int i=0;i<output2.length;i++){
                output2[i]=getChar+output2[i];
            }
        }
        String finalOutput[]=new String[output1.length+output2.length];
        int k=0;
        for(int i=0;i<output1.length;i++){
            finalOutput[k]=output1[i];
            k++;
        }
        for(int i=0;i<output2.length;i++){
            finalOutput[k]=output2[i];
            k++;
        }
        return finalOutput;
    }
}
