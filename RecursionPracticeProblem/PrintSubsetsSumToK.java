package RecursionPracticeProblem;

public class PrintSubsetsSumToK {
    private static void printSubsetsSumToK(int input[],int k,int si,int[]outputSoFar){
        if(k==0){
            for(int i=0;i<outputSoFar.length;i++){
                System.out.print(outputSoFar[i]+" ");
            }
            System.out.println();
            return;
        }
        if(si==input.length){
            return;
        }
        int arr[]=new int[outputSoFar.length+1];
        for(int i=0;i<outputSoFar.length;i++){
            arr[i]=outputSoFar[i];
        }
        arr[outputSoFar.length]=input[si];
        printSubsetsSumToK(input, k, si+1, outputSoFar);
        printSubsetsSumToK(input, k-input[si], si+1, arr);
    }
    public static void printSubsetsSumToK(int[]input,int k){
        printSubsetsSumToK(input, k,0,new int[]{});
    }
}
