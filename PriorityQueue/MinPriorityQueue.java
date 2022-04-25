package PriorityQueue;

import java.util.ArrayList;

public class MinPriorityQueue {
    private ArrayList<Integer> heap;

    public MinPriorityQueue() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }
 
    public int getMin() throws PriorityQueueException {
        if (heap.isEmpty()) {
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    public void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }

    }

    public int removeMin() throws PriorityQueueException {
        if (heap.isEmpty()) {
            throw new PriorityQueueException();
        }
        int data = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int parentIndex = 0;
        int childIndex = 1;
        while (childIndex + 1 < heap.size()) {
            int temp;
            if (heap.get(childIndex) < heap.get(childIndex + 1)) {
                if (heap.get(childIndex) < heap.get(parentIndex)) {
                    temp = heap.get(childIndex);
                    heap.set(childIndex, heap.get(parentIndex));
                    heap.set(parentIndex, temp);
                    parentIndex = childIndex;
                    childIndex = (parentIndex * 2) + 1;
                } else {
                    break;
                }
            } else {
                if (heap.get(childIndex + 1) < heap.get(parentIndex)) {
                    temp = heap.get(childIndex + 1);
                    heap.set(childIndex + 1, heap.get(parentIndex));
                    heap.set(parentIndex, temp);
                    parentIndex = childIndex + 1;
                    childIndex = (parentIndex * 2) + 1;

                } else {
                    break;
                }
            }
        }
        if (childIndex == (heap.size() - 1)) {
            if (heap.get(childIndex) < heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
            }
        }
        return data;
    }

    // public static void main(String[] args) throws PriorityQueueException {
    //     int arr[] = { 5, 34, 6486, 654, 4234, 6, 6, 6866, 443, 54 };
    //     MinPriorityQueue pq = new MinPriorityQueue();
    //     for (int i = 0; i < arr.length; i++) {
    //         pq.insert(arr[i]);
    //     }
    //     System.out.println(pq.size());
    //     System.out.println(pq.getMin());
    //     System.out.println("Removing all the elements");
    //     while (!pq.isEmpty()) {
    //         System.out.println(pq.removeMin());
    //     }
    // }
}
