package Graphs.Assignment;

import java.util.LinkedList;
import java.util.Queue;

public class Island {

    public static void BFS(int edges[][], int sv, int n, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while (!q.isEmpty()) {
            int a = q.remove();
            for (int i = 0; i < edges.length; i++) {
                if (!visited[i] && edges[a][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static int numConnected(int[][] edges, int n) {
        boolean visited[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                BFS(edges, i, n, visited);
                count++;
            }

        }
        return count;

    }
}