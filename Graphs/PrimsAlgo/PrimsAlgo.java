package Graphs.PrimsAlgo;

import java.util.*;

public class PrimsAlgo {
    static int findMinVertex(int[] weight, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < weight.length; i++) {
            if (!visited[i] && (minVertex == -1 || weight[minVertex] > weight[i])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void primsAlgo(int[][] edges, int n) {
        int weight[] = new int[n];
        weight[0] = 0;
        for (int i = 1; i < n; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        boolean visited[] = new boolean[n];
        int parents[] = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int minvertex = findMinVertex(weight, visited);
            visited[minvertex] = true;
            for (int j = 0; j < n; j++) {
                if (edges[minvertex][j] != 0 && !visited[j]) {
                    if(edges[minvertex][j]<weight[j]){
                        weight[j]=edges[minvertex][j];
                        parents[j]=minvertex;
                    }
                }
            } 
        }

        //printing MST

        for(int i=1;i<n;i++){
            if(parents[i]<i){
                System.out.println(parents[i]+" "+i+" "+weight[i]);
            }
            else{
                System.out.println(i+" "+parents[i]+" "+weight[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int edges[][] = new int[n][e];
        for (int i = 0; i < e; i++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            int weight = sc.nextInt();
            edges[sv][ev] = weight;
            edges[ev][sv] = weight;
        }
        primsAlgo(edges, n);
        sc.close();
    }
}
