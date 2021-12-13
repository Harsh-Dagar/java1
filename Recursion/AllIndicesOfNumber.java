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
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        return allIndexes(input,x,0);
	}
    public static void main(String[] args) {
        int a[]=allIndexes(new int[]{1,2,34,5,2,54,2,54}, 2);
        for(int e:a){
            System.out.println(e);
        }
    }
}
