package Recursion;
public class CheckSorted {
    public boolean checkSorted(int arr[]){
        if(arr.length<=1){
            return true;
        }
        int []smallInput=new int[arr.length-1];
        for(int i=0;i<smallInput.length;i++){
            smallInput[i]=arr[i+1];
        }
        boolean smallAns=checkSorted(smallInput);
        if(!smallAns){
            return false;
        }
        if(arr[0]<=arr[1]){
            return true;
        } 
        else{
            return false;
        }
    }
    public boolean checkSorted_2(int arr[]){
        if(arr.length<=1){
            return true;
        }
        if(arr[0]>arr[1]){
            return false;
        }
        int smallInput[]=new int[arr.length-1];
        for(int i=0;i<smallInput.length;i++){
            smallInput[i]=arr[i+1];
        }
        boolean smallAns=checkSorted_2(smallInput);
        return smallAns;
    }
    // this method is better in terms of space consumption
    // this method checks if the array is sorted form startIndex to end
    private static boolean checkSortedBetter(int arr[], int startIndex){
        if(startIndex==arr.length-1){
            return true;
        }
        if(arr[startIndex]>arr[startIndex+1]){
            return false;
        }
        boolean smallAns=checkSortedBetter(arr, startIndex+1);
        return smallAns;
    }
    // helper funtion for method boolean checkSortedBetter(int arr[],int startIndex)
    public boolean checkSortedBetter(int arr[]){
        return checkSortedBetter(arr,0);
    }
}
