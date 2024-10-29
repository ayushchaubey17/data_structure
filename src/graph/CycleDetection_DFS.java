package graph;

import java.util.ArrayList;

public class CycleDetection_DFS {
    public static void main(String[] args) {
        int vertices = 8;

        ArrayList<UsingAdjacencyList.Edge> graph[] = new ArrayList[vertices];
        for (int i = 0; i <vertices ; i++)  graph[i] = new ArrayList<>();


        BFS.creation(graph);

      boolean b =  cycleDetection(graph);
        System.out.println(b);
    }

    private static boolean cycleDetection(ArrayList<UsingAdjacencyList.Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];


        for (int i = 0; i < graph.length; i++) {
            if(!visited[i] && cycleDetectionUtil(graph, visited, 0, -1))return true;
        }
        return false;
    }

    private static boolean cycleDetectionUtil(ArrayList<UsingAdjacencyList.Edge>[] graph, boolean[] visited, int current, int parrent) {

        visited[current] = true;
        for (UsingAdjacencyList.Edge e : graph[current]) {
            //case 1
            if ( !visited[e.destination] && e.destination != parrent)
                return true;

            else if (!visited[e.destination]) {
               if (cycleDetectionUtil(graph, visited, e.destination, current))return true;

            }
        }
        return false;
    }
}
