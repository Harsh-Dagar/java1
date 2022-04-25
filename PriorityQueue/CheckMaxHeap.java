package PriorityQueue;

public class CheckMaxHeap {
    public static boolean checkMaxHeap(int arr[]){
        for(int i=1;i<arr.length;i++){
            int childIndex=i;
            int parentIndex=(i-1)/2;
            if(arr[childIndex]>arr[parentIndex]){
                return false;
            }
        }
        return true;
    }
}
