package RecursionPracticeProblem;
/*
  Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. 
  You are given a numeric string S. Write a program to print 
  the list of all possible codes that can be generated from 
  the given string.
*/

public class PrintAllCodesString {
    private static char getChar(int n){
        return (char)('a'+n-1);
    }
    private static void printAllPossibleCodes(String input,String outputSoFar){
        if(input.length()==0){
            System.out.println(outputSoFar);
            return;
        }
        printAllPossibleCodes(input.substring(1), outputSoFar+getChar(Integer.parseInt(input.charAt(0)+"")));
        if(input.length()>=2&&Integer.parseInt(input.substring(0, 2))<=26){
            printAllPossibleCodes(input.substring(2), outputSoFar+getChar(Integer.parseInt(input.substring(0, 2))));
        }
	}
    public static void printAllPossibleCodes(String input){
        printAllPossibleCodes(input,"");
    }
    
}
