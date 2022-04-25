package PriorityQueue;

import java.util.ArrayList; 
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    int data;
    int arrNo;
    Pair() {
    }
    Pair(int data, int arrNo) {
        this.data = data;
        this.arrNo = arrNo;
    }
}

public class MergeKSortedArray {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.data < b.data) {
                    return -1;
                } else if (a.data > b.data) {
                    return 1;
                }
                return 0;
            }
        });
        for(int i=0;i<input.size();i++){
            Pair p=new Pair(input.get(i).get(0),i);
            pq.add(p);
            input.get(i).remove(0);
        }
        while(!pq.isEmpty()){
            Pair min=pq.remove();
            output.add(min.data);
            if(input.get(min.arrNo).size()>0){
                Pair current=new Pair(input.get(min.arrNo).get(0),min.arrNo);
                pq.add(current);
                input.get(min.arrNo).remove(0);
            }
        }

        return output;

    }
}
