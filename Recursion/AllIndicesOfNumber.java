package Recursion;

public class AllIndicesOfNumber {
    private static int[] allIndexes(int input[],int x,int si){
        if(input.length==si){
            int arr[]=new int[0];
            return  arr;
        }
        int smallArr[]=allIndexes(input,x,si+1);
        if(input[si]==x){
            int arr[]=new int[smallArr.length+1];
            arr[0]=si;
            for(int i=0;i<smallArr.length;i++){
                arr[i+1]=smallArr[i];
            }
            return arr;
        }
        return smallArr;
    }

	public static int[] allIndexes(int input[], int x) {
        return allIndexes(input,x,0);
	}
}
