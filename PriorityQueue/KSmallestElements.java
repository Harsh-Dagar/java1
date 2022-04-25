package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestElements {
    public static ArrayList<Integer> kSmallest(int arr[], int k) {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer l, Integer r) {
                if (l > r)
                    return -1;
                if (l < r) 
                    return 1;
                return 0;
            }
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(c);
        ArrayList<Integer> output = new ArrayList<>();
        int i = 0;
        for (; i < k; i++) {
            pq.add(arr[i]);
        }
        for (; i < arr.length; i++) {
            if (pq.peek() > arr[i]) {
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
