package Graphs.KruskalsAlgo;

import java.util.Arrays;
import java.util.Scanner;

public class KruskalsAlgo {

    static int findParent(int[] parents, int a) {
        while (true) {
            int x = parents[a];
            if (x == a) {
                break;
            }
            a = x;
        }
        return a;
    }

    public static void kruskalsAlgo(Edge[] input, int n) {
        Arrays.sort(input);
        int parents[] = new int[input.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        Edge output[] = new Edge[n - 1];
        int i = 0;
        int count = 0;
        while (count != (n - 1)) {
            Edge currentE = input[i];
            int p1 = findParent(parents, currentE.source);
            int p2 = findParent(parents, currentE.destination);
            if (p1 != p2) {
                output[count] = currentE;
                parents[p1] = p2;
                count++;
            }
            i++;
        }

        for (int j = 0; j < output.length; j++) {
            if (output[j].source < output[j].destination) {
                System.out.println(output[j].source + " " + output[j].destination + " " + output[j].weight);
            } else {
                System.out.println(output[j].destination + " " + output[j].source + " " + output[j].weight);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Edge[] input = new Edge[e];
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            Edge inputE = new Edge(s, d, w);
            input[i] = inputE;
        }
        kruskalsAlgo(input, n);
        sc.close();
    }
}
