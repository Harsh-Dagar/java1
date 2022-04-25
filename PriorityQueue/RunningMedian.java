package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void findMedian(int arr[]) {
        if(arr.length==0){
            return;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a > b) {
                    return -1;
                }
                if (a < b) {
                    return 1;
                }
                return 0;
            }
        });
        maxHeap.add(arr[0]);
        System.out.print(arr[0] + " ");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxHeap.peek()) {
                minHeap.add(arr[i]);
                if (minHeap.size() == (2 + maxHeap.size())) {
                    maxHeap.add(minHeap.remove());
                    System.out.print((minHeap.peek() + maxHeap.peek()) / 2 + " ");
                } else if (minHeap.size() == (1 + maxHeap.size())) {
                    System.out.print(minHeap.peek() + " ");
                } else {
                    System.out.print((minHeap.peek() + maxHeap.peek()) / 2 + " ");
                }
            } else {
                maxHeap.add(arr[i]);
                if (maxHeap.size() == (2 + minHeap.size())) {
                    minHeap.add(maxHeap.remove());
                    System.out.print((minHeap.peek() + maxHeap.peek()) / 2 + " ");
                } else if (maxHeap.size() == (1 + minHeap.size())) {
                    System.out.print(maxHeap.peek() + " ");
                } else {
                    System.out.print((minHeap.peek() + maxHeap.peek()) / 2 + " ");
                }
            }
        }

    }
}
