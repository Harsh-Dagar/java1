package Graphs.Dijkstra;

import java.util.Scanner;

public class Dijkstra {

    public static int findMinVertex(int[] distance, boolean[] visited) {
        int minvertex = -1;
        int n = distance.length;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && (minvertex == -1 || distance[i] < distance[minvertex])) {
                minvertex = i;
            }
        }
        return minvertex;
    }

    public static void dijkstra(int[][] edges, int n) {
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        distance[0] = 0;
        for (int i = 1; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0 ; i < n - 1; i++) {
            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;

            for (int j = 0; j < n; j++) {
                if (edges[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    int newDist = distance[minVertex] + edges[minVertex][j];
                    if (distance[j] > newDist) {
                        distance[j] = newDist;
                    }
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + " " + distance[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int edges[][] = new int[n][n];
        for (int i = 0; i < e; i++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            int weight = sc.nextInt();
            edges[sv][ev] = weight;
            edges[ev][sv] = weight;
        }
        dijkstra(edges, n);
        sc.close();

    }
}
