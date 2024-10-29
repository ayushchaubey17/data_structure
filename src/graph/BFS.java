package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int vertices = 8;

        ArrayList<UsingAdjacencyList.Edge> graph[] = new ArrayList[vertices];
        for (int i = 0; i <vertices ; i++)  graph[i] = new ArrayList<>();

        creation(graph);


        traversing(graph);
    }

    public static void traversing(ArrayList<UsingAdjacencyList.Edge>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        queue.offer(graph[0].get(0).source);
        visited[graph[0].get(0).source] = true;

        while (!queue.isEmpty()) {
            int r = queue.poll();
            System.out.print(r+" ");


            for (int i = 0; i < graph[r].size(); i++) {
                if (!visited[graph[r].get(i).destination])
                queue.offer(graph[r].get(i).destination);
                visited[graph[r].get(i).destination] = true;
            }
        }
    }


    public static void creation(ArrayList<UsingAdjacencyList.Edge>[] graph) {
        //vertex 0
        graph[0].add(new UsingAdjacencyList.Edge(0, 1, 5));
        graph[0].add(new UsingAdjacencyList.Edge(0, 2, 5));

        //vertex 1
        graph[1].add(new UsingAdjacencyList.Edge(1, 3, 1));
        graph[1].add(new UsingAdjacencyList.Edge(1, 0, 5));


        //vertex 2
        graph[2].add(new UsingAdjacencyList.Edge(2, 0, 1));
        graph[2].add(new UsingAdjacencyList.Edge(2, 4, 1));

        //vertex 3
        graph[3].add(new UsingAdjacencyList.Edge(3, 1, 3));
        graph[3].add(new UsingAdjacencyList.Edge(3, 5, 1));


        //vertex 4
        graph[4].add(new UsingAdjacencyList.Edge(4, 2, 3));
        graph[4].add(new UsingAdjacencyList.Edge(4, 6, 1));


        //vertex 5
        graph[5].add(new UsingAdjacencyList.Edge(5, 3, 3));
        graph[5].add(new UsingAdjacencyList.Edge(5, 6, 1));
        graph[5].add(new UsingAdjacencyList.Edge(5, 7, 1));


        //vertex 6
        graph[6].add(new UsingAdjacencyList.Edge(6, 4, 3));
        graph[6].add(new UsingAdjacencyList.Edge(6, 5, 1));
        graph[6].add(new UsingAdjacencyList.Edge(6, 7, 1));


        //vertex 6
        graph[7].add(new UsingAdjacencyList.Edge(7, 6, 3));
        graph[7].add(new UsingAdjacencyList.Edge(7, 5, 1));



    }
}
