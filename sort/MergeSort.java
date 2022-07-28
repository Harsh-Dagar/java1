package sort;

public class MergeSort {
    private static void merge(int arr[],int si,int ei){
        int ans[]=new int[ei-si+1];
        int mid=(si+ei)/2;
        int i=si,j=mid+1,k=0;
        while(i<=mid&&j<=ei){
            if(arr[i]<=arr[j]){
                ans[k]=arr[i];
                i++;k++;
            }
            else{
                ans[k]=arr[j];
                j++;k++;
            }
        }
        while(i<=mid){
            ans[k]=arr[i];
            k++;i++;
        }
        while(j<=ei){
            ans[k]=arr[j];
            k++;j++;
        }
        for(int index=0;index<ans.length;index++){
            arr[si+index]=ans[index];
        }
    }
    private static void sort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int mid=(si+ei)/2;
        sort(arr,si,mid);
        sort(arr,mid+1,ei);
        merge(arr,si,ei);
    } 
    public static void sort(int arr[]){
        sort(arr,0,arr.length-1);
    }
}
