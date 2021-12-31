package RecursionPracticeProblem;

public class PrintSubsetsOfArray {
    private static void printSubsets(int input[],int outputSoFar[],int si){
        if(si==input.length){
            for(int i=0;i<outputSoFar.length;i++){
                System.out.print(outputSoFar[i]+" ");
            }
            System.out.println();
            return;
        }
        int arr[]=new int[outputSoFar.length+1];
        for(int i=0;i<outputSoFar.length;i++){
            arr[i]=outputSoFar[i];
        }
        arr[outputSoFar.length]=input[si];
        printSubsets(input, outputSoFar, si+1);
        printSubsets(input, arr, si+1);
    }
    public static void printSubsets(int input[]){
        int output[]=new int[0];
        printSubsets(input,output,0);
    }
}
