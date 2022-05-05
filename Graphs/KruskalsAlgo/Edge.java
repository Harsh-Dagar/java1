package Graphs.KruskalsAlgo;

public class Edge implements Comparable<Edge>{
    int source;
    int destination;
    int weight;
    public Edge(int source,int destination,int weight){
        this.destination=destination;
        this.weight=weight;
        this.source=source;
    }
    @Override
    public int compareTo(Edge e1) {
        if(this.weight<e1.weight){
            return -1;
        }
        else if(this.weight>e1.weight){
            return 1;
        } 
        return 0;
    }
    // public static void main(String[] args) {
    //     Comparator<Edge> c = new Comparator<Edge>() {
    //         @Override
    //         public int compare(Edge a, Edge b) {
    //             if (a.weight < b.weight) {
    //                 return -1;
    //             } else if (a.weight > b.weight) {
    //                 return 1;
    //             } else {
    //                 return 0;
    //             }
    //         }
    //     };
    //     ArrayList<Edge> a=new ArrayList<>();
    //     Edge e1=new Edge(0, 1, 9);
    //     Edge e2=new Edge(0, 1, 6);
    //     Edge e3=new Edge(0, 1, 11);
    //     a.add(e1);
    //     a.add(e2);
    //     a.add(e3);
    //     a.sort(c);
    //     for(int i =0;i<a.size();i++){
    //         System.out.println(a.get(i).weight);
    //     }
    // }
}
