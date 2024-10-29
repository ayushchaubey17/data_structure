package graph;

import java.util.ArrayList;

public class HasPath {
    public static void main(String[] args) {
        int vertices = 8;

        ArrayList<UsingAdjacencyList.Edge> graph[] = new ArrayList[vertices];
        for (int i = 0; i <vertices ; i++)  graph[i] = new ArrayList<>();
        boolean visited[] = new boolean[graph.length];

        BFS.creation(graph);

        boolean b =   hasPath(graph, visited, 0, 7);
        System.out.println(b);
    }

    private static boolean hasPath(ArrayList<UsingAdjacencyList.Edge>[] graph, boolean[] visited, int src, int dest) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;


        for (UsingAdjacencyList.Edge e : graph[src]) {

            if ( !visited[e.destination] && hasPath(graph,visited,e.destination,dest)) return  true;
        }

        return false;
    }
}
