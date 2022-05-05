package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    private static void printHelper(int edges[][], int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv]=true;
        while (!q.isEmpty()) {
            int a = q.remove();
            System.out.print(a+" ");
            for (int i = 0; i < edges.length; i++) {
                if (!visited[i]&&edges[a][i]==1) {
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
    }

    public static void printBFS(int edges[][]) {
        boolean visited[] = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i])
                printHelper(edges, i, visited);
        }

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
        printBFS(edges);
        sc.close();
    }
}
