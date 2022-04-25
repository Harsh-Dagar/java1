package PriorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElements {
    public static ArrayList<Integer> kLargest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> output = new ArrayList<>();
        int i = 0;
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        for (; i < arr.length; i++) {
            if (pq.peek() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        for (int j = 0; j < k; j++) {
            output.add(pq.remove());
        }
        return output;
    }
}
