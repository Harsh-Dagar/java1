package RecursionPracticeProblem;
/*
  Given a string S, find and return all the possible 
  permutations of the input string.

Note 1 : The order of permutations is not important.
Note 2 : If original string contains duplicate
characters, permutations will also be duplicates.

*/

public class ReturnPermutationsString {
    private static int fact(int n){
        if(n==0){
            return 1; 
        }
        int smallAns=fact(n-1);
        return n*smallAns;
    }
    public static String[] permutationOfString(String input){
        if(input.length()==0){
            String output[]={""};
            return output;
        }
        String temp[][]=new String[input.length()][0];
        for(int i=0;i<input.length();i++){
            temp[i]=permutationOfString(input.substring(0,i)+input.substring(i+1));
            for(int j=0;j<temp[i].length;j++){
                temp[i][j]=input.charAt(i)+temp[i][j];
            }
        }
        String finalAns[]=new String[fact(input.length())];
        int k=0;
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[i].length;j++){
                finalAns[k]=temp[i][j];
                k++;
            }
        }
        return finalAns;
	}
}
