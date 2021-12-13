package Recursion;

public class FindNumberInArray {
    public static boolean checkNumber(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		if(input.length==1&&input[0]!=x){
			return false;

		}
		if(input[0]==x){
			return true;
		}
		int smallInput[]=new int[input.length-1];
		for(int i=0;i<smallInput.length;i++){
			smallInput[i]=input[i+1];
		}
		boolean smallAns=checkNumber(smallInput, x);
		return smallAns;
	}


}
