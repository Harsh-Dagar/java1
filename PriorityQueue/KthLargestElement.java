package PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int kthLargest(int input[],int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(input[i]);
        }
        for(int i=k;i<input.length;i++){
            if(pq.peek()<input[i]){
                pq.remove();
                pq.add(input[i]);
            }
        }
        return pq.remove();

    }
}
