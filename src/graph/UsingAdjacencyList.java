package graph;

import java.util.ArrayList;

public class UsingAdjacencyList {
    static class Edge{
        int source;
        public int destination;
        public int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int vertices = 5;

        ArrayList<Edge> graph[] = new ArrayList[vertices];
        for (int i = 0; i <vertices ; i++)  graph[i] = new ArrayList<>();

        creation(graph);

        findNeighours(3,graph);
    }

    private static void findNeighours(int v,ArrayList<Edge>[] graph) {

        for (int j = 0; j <graph[v].size() ; j++) {
            Edge e = graph[v].get(j);
            System.out.println(e.destination);

        }
    }

    private static void creation(ArrayList<Edge>[] graph) {
        //vertex 0
        graph[0].add(new Edge(0, 1, 5));

        //vertex 1
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 3, 3));


        //vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));

        //vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));



    }
}
