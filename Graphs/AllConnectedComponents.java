package Graphs;

import java.util.*;

public class AllConnectedComponents {

    private static ArrayList<Integer> componentsHelper(int edges[][], int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        ArrayList<Integer> output = new ArrayList<>();
        visited[sv] = true;
        output.add(sv);
        while (!q.isEmpty()) {
            int a = q.remove();
            output.add(a);
            for (int i = 0; i < edges.length; i++) {
                if (!visited[i] && edges[a][i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return output;
    }

    public static ArrayList<ArrayList<Integer>> allconnectedComp(int edges[][]) {
        boolean[] visited = new boolean[edges.length];
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                ArrayList<Integer> al = new ArrayList<>();
                al = componentsHelper(edges, i, visited);
                output.add(al);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a < b) {
                    return -1;
                } else if (a > b) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
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
        ArrayList<ArrayList<Integer>> output = allconnectedComp(edges);
        for (int i = 0; i < output.size(); i++) {
            output.get(i).sort(c);
            for (int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j) + " ");
            }
            System.out.println();
        }

        sc.close();

    }
}
