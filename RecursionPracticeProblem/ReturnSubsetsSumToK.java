package RecursionPracticeProblem;

public class ReturnSubsetsSumToK {
    private static int[][] subsetsSumK(int[]input,int k,int si){
        if(si==input.length){
            if(k==0){
                int output[][]=new int[1][0];
                return output;
            }
            else{
                int output[][]=new int[0][0];
                return output;
            }
        }
        int smallAns1[][]=subsetsSumK(input, k, si+1);
        int tempSmallAns2[][]=subsetsSumK(input, k-input[si], si+1);
        int smallAns2[][]=new int[tempSmallAns2.length][];
        for(int i=0;i<tempSmallAns2.length;i++){
            smallAns2[i]=new int[tempSmallAns2[i].length+1];
            smallAns2[i][0]=input[si];
            for(int j=0;j<tempSmallAns2[i].length;j++){
                smallAns2[i][j+1]=tempSmallAns2[i][j];
            }
        }
        int finalAns[][]=new int[smallAns1.length+smallAns2.length][];
        int index=0;
        for(int i=0;i<smallAns1.length;i++){
            finalAns[index]=new int[smallAns1[i].length];
            for(int j=0;j<smallAns1[i].length;j++){
                finalAns[index][j]=smallAns1[i][j];
            }
            index++;
        }
        for(int i=0;i<smallAns2.length;i++){
            finalAns[index]=new int[smallAns2[i].length];
            for(int j=0;j<smallAns2[i].length;j++){
                finalAns[index][j]=smallAns2[i][j];
            }
            index++;
        }
        return finalAns;
    }
    public static int[][] subsetsSumK(int input[],int k){
        return subsetsSumK(input, k,0);
    }
}
