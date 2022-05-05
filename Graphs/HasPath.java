package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HasPath {

    private static boolean hasPath(int edges[][], int v1, int v2, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v1);
        while (!q.isEmpty()) {
            int a = q.remove();
            for (int i = 0; i < edges.length; i++) {
                if (edges[a][i] == 1 && !visited[i]) {
                    if (i == v2) {
                        return true;
                    }
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public static boolean hasPath(int edges[][], int v1, int v2) {
        boolean visited[] = new boolean[edges.length];
        return hasPath(edges, v1, v2, visited);
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
        System.out.println(hasPath(edges, v1, v2));
        sc.close();
    }
}
