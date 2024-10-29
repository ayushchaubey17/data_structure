package graph;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        int vertices = 8;

        ArrayList<UsingAdjacencyList.Edge> graph[] = new ArrayList[vertices];
        for (int i = 0; i <vertices ; i++)  graph[i] = new ArrayList<>();
        boolean visited[] = new boolean[graph.length];

        BFS.creation(graph);

        dfs(graph,visited,0);
    }

    private static void dfs(ArrayList<UsingAdjacencyList.Edge>[] graph, boolean[] visited, int i) {
        System.out.print(i+" ");
        visited[i] = true;

        for (int j = 0; j <graph[i].size() ; j++) {
            if (!visited[graph[i].get(j).destination]) dfs(graph,visited,graph[i].get(j).destination);

        }
    }
}
