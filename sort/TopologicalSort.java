package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int indeg[]) {
        int numV = indeg.length;
        ArrayList<Integer> output = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numV; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.remove();
            output.add(curr);
            for (int neighbour : adj.get(curr)) {
                if (--indeg[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }
        return output;
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        int indeg[] = new int[V];
        for (ArrayList<Integer> i : adj) {
            for (Integer j : i) {
                indeg[j]++;
            }
        }

        ArrayList<Integer> temp = bfs(adj, indeg);
        int output[] = new int[V];
        for (int i = 0; i < V; i++) {
            output[i] = temp.get(i);
        }
        return output;

    }
}
