package Recursion2;
public class MergeSort {

    private static void merge(int input[],int sI,int eI){
        int mid=(sI+eI)/2;
        int ans[]=new int[eI-sI+1];
        int i=sI;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=eI){
            if(input[i]<=input[j]){
                ans[k]=input[i];
                i++;k++;
            }
            else{
                ans[k]=input[j];
                k++;j++;
            }
        }
        while(i<=mid){
            ans[k]=input[i];
            i++;k++;
        }
        while(j<=eI){
            ans[k]=input[j];
            j++;k++;
        }
        for(int index=0;index<ans.length;index++){
            input[index+sI]=ans[index];
        }
    }
    public static void mergeSort(int[] input,int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=(si+ei)/2;
        mergeSort(input, si, mid);
        mergeSort(input, mid+1, ei);
        merge(input,si,ei);
    }
}
