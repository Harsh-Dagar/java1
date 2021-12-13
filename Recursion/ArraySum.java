package Recursion;

public class ArraySum {
    
    public static int sum(int input[]) {
        if(input.length==1){
            return input[0];
        }
        if(input.length==0){
            return 0;
        }
        int smallInput[]=new int[input.length-1];
        for(int i=0;i<smallInput.length;i++){
            smallInput[i]=input[i+1];
        }
        int sum=input[0]+sum(smallInput);
        return sum;
	}
}

