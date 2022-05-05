package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsConnected {

    private static boolean isConnected(int[][]edges,int sv,boolean visited[]){
        if(edges.length==0){
            return true;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv]=true;
        while (!q.isEmpty()) {
            int a = q.remove();
            for (int i = 0; i < edges.length; i++) {
                if (!visited[i]&&edges[a][i]==1) {
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                return false;
            }
        }
        return true;
    }
    public static boolean isConnected(int[][]edges){
        boolean visited[]=new boolean[edges.length];
        return isConnected(edges,0,visited);
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
        System.out.println(isConnected(edges));
        
        sc.close();
    }
}
