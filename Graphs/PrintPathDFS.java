package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintPathDFS {

    private static ArrayList<Integer> getPath(int edges[][], int v1, int v2, boolean visited[]) {
        int n = edges.length;
        if (v1 == v2) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(v1);
            return output;
        }
        visited[v1] = true;
        for (int i = 0; i < n; i++) {
            if (edges[v1][i] == 1 && !visited[i]) {
                ArrayList<Integer> smallAns = getPath(edges, i, v2, visited);
                if (smallAns != null) {
                    smallAns.add(v1);
                    return smallAns;
                }
            }
        }
        return null;
    }

    public static ArrayList<Integer> getPath(int edges[][], int v1, int v2) {
        boolean visited[] = new boolean[edges.length];
        return getPath(edges, v1, v2, visited);
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
        ArrayList<Integer> output = getPath(edges, v1, v2);
        if (output != null) {
            for (int i = 0; i < output.size(); i++) {
                System.out.print(output.get(i) + " ");

            }
        }
        sc.close();

    }
}
