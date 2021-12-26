package sort;

public class QuickSort {
    private static int partition(int arr[],int si,int ei){
        int[]ans=new int[ei-si+1];
        int pivotPt=arr[si];
        int pivotPos=0;
        int j=0;
        for(int i=si+1;i<=ei;i++){
            if(arr[i]<=pivotPt){
                pivotPos++;
                ans[j]=arr[i];
                j++;
            }
        }
        ans[pivotPos]=pivotPt;
        j++;
        for(int i=si+1;i<=ei;i++){
            if(arr[i]>pivotPt){
                ans[j]=arr[i];
                j++;
            }
        }
        for(int i=0;i<ans.length;i++){
            arr[si+i]=ans[i];
        }
        return pivotPos+si;
    }
    private static void sort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int pivotPos=partition(arr, si, ei);
        sort(arr,si,pivotPos-1);
        sort(arr,pivotPos+1,ei);
    }
    public static void sort(int arr[]){
        sort(arr,0,arr.length-1);
    }
}
