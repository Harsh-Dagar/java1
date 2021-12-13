package Recursion;

public class CountZeros {
    public static int countZerosRec(int input){
		// Write your code here
        if(input<=9&&input>=1){
            return 0;
        }
        if(input==0){
            return 1;
        }
        int smallInput=input/10;
        int smallAns=1+countZerosRec(smallInput);

        if(input%10==0){
            return smallAns;
        }
        else{
            return smallAns-1;
        }

	}
}
