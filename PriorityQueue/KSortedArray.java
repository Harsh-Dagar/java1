package PriorityQueue;

import java.util.PriorityQueue;

public class KSortedArray {
    public static void sortKSorted(int arr[],int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        for(i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(;i<arr.length;i++){
            arr[i-k]=pq.remove();
            pq.add(arr[i]);
        }
        for(int j=arr.length-k;j<arr.length;j++){
            arr[j]=pq.remove();
        }

    }
    public static void main(String[] args) {
        int arr[]={3,1,2,5,4,6,9,8,7};
        sortKSorted(arr, 3);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
