package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetPathBFS {

    private static ArrayList<Integer> getPathHelper(int[][] edges, int v1, int v2, boolean[] visited) {

        if (v1 > (edges.length - 1) || v2 > (edges.length - 1)) {
            return null;
        }
        if (v1 == v2 && edges[v1][v2] == 1) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(v1);
            return output;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(v1);
        visited[v1] = true;
        while (!q.isEmpty()) {
            int a = q.remove();
            for (int i = 0; i < edges.length; i++) {
                if (!visited[i] && edges[a][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                    map.put(i, a);
                    if (i == v2) {
                        ArrayList<Integer> output = new ArrayList<>();
                        output.add(v2);
                        int value = map.get(v2);
                        while (value != v1) {
                            output.add(value);
                            value = map.get(value);
                        }
                        output.add(value);
                        return output;
                    }
                }
            }
        }
        return null;

    }

    public static ArrayList<Integer> getPathBFS(int edges[][], int v1, int v2) {
        boolean visited[] = new boolean[edges.length];
        return getPathHelper(edges, v1, v2, visited);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int edges[][] = new int[n][n];
        for (int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;

        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        ArrayList<Integer> output = getPathBFS(edges, v1, v2);
        if (output != null) {
            for (int i = 0; i < output.size(); i++) {
                System.out.print(output.get(i) + " ");

            }
        }
        sc.close();
    }
}
