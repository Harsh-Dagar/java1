package RecursionPracticeProblem;

public class ReturnSubsetOfAnArray {
    public static int[][] subsets(int input[]){
        if(input.length==0){
            int ans[][]=new int[1][0];
            return ans;
        }
        //------------------------------------
        int smallInput[]=new int[input.length-1];
        for(int i=0;i<smallInput.length;i++){
            smallInput[i]=input[i+1];
        }
        //------------------------------------
        int smallAns[][]=subsets(smallInput);
        int ans[][]=new int[2*smallAns.length][];
        int k=0;
        for(int i=0;i<smallAns.length;i++){
            ans[k]=new int[smallAns[i].length];
            for(int j=0;j<smallAns[i].length;j++){
                ans[k][j]=smallAns[i][j];
            }
            k++;
        }
        for(int i=0;i<smallAns.length;i++){
            ans[k]=new int[1+smallAns[i].length];
            ans[k][0]=input[0];
            for(int j=1;j<=smallAns[i].length;j++){
                ans[k][j]=smallAns[i][j-1];
            }
            k++;
        }
        return ans;
    }
}
