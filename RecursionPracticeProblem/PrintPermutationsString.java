package RecursionPracticeProblem;
/*
  Given an input string (STR), 
  print all possible permutations of the input string.
*/

public class PrintPermutationsString {
    private static void findPermutations(String str,String output){
        if(str.length()==0){
            System.out.println(output);
            return;
        }
        for(int i=0;i<str.length();i++){
            findPermutations(str.substring(0,i)+str.substring(i+1), output+str.charAt(i));
        }
    }
    public static void FindPermutations(String str){
        findPermutations(str,"");
    }
}
