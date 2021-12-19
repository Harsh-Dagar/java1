package Recursion2;
public class MergeSort {
/*     public static void mergeSort(int[]arr){
        if(arr.length<=1){
            return;
        }
        int[]p1=new int[arr.length/2];
        int[]p2=new int[arr.length-p1.length];
        for(int i=0;i<p1.length;i++){
            p1[i]=arr[i];
        }
        for(int i=0;i<p2.length;i++){
            p2[i]=arr[p2.length-1+i];
        }
        mergeSort(p1);
        mergeSort(p2);
        int arrTemp[]=new int[p1.length+p2.length];
        int i=0,j=0,k=0;
        while(i<p1.length&&j<p2.length){
            if(p1[i]<=p2[j]){
                arrTemp[k]=p1[i];
                k++;i++;
            }
            else{
                arrTemp[k]=p2[j];
                k++;j++;
            }
        }
        while(i<p1.length){
            arrTemp[k]=p1[i];
            k++;i++;
        }
        while(j<p2.length){
            arrTemp[k]=p2[j];
            k++;j++;
        }
        arr=arrTemp;
    } */
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

    public static void main(String[] args) {
        int arr[]={1,234,4,3,6,5,34};
        mergeSort(arr,0,arr.length-1);
        for(int e: arr){
            System.out.println(e);
        }
    }
}
