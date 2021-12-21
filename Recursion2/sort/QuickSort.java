package Recursion2.sort;

public class QuickSort{
    private static int partition(int[]input,int si,int ei){
        int ans[]=new int[ei-si+1];
        int pivotPt=input[si];
        int pivotPos=0;
        int j=0;
        for(int i=1;i<ans.length;i++){
            if(input[si+i]<=pivotPt){
                ans[j]=input[si+i];
                pivotPos++;
                j++;
            }
        }
        ans[pivotPos]=pivotPt;
        j++;
        for(int i=1;i<ans.length;i++){
            if(input[i+si]>pivotPt){
                ans[j]=input[i+si];
                j++;
            }
        }
        for(int i=0;i<ans.length;i++){
            input[si+i]=ans[i];
        }
        return pivotPos+si;
    }
    private static void quickSort(int input[],int si,int ei){
        if(si>=ei){
            return;
        }
        int pivotPos=partition(input, si, ei);
        quickSort(input, si, pivotPos-1);
        quickSort(input,pivotPos+1,ei); 
    }
    public static void quickSort(int input[]){
        quickSort(input,0,input.length-1);
    }
    public static void main(String[] args) {
        int arr[]={4434,53,56745,2,214,18546542,234548,765433345};
        quickSort(arr);
        for(int e: arr){
            System.out.println(e);
        }
    }
}