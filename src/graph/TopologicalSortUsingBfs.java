package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBfs {
   static ArrayList<Edge> graph[] = new ArrayList[6];
    static class  Edge{
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }
    public static void main(String[] args) {

        
        creation(graph);

        ts(graph);

    }

    private static void ts(ArrayList<Edge>[] graph) {
        int inDegree[] = new int[graph.length];

        for (int i = 0; i < graph.length ; i++)
            for (Edge e : graph[i]) inDegree[e.des]++;


        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<inDegree.length ;i++)if (inDegree[i]==0) queue.offer(i);


        while (!queue.isEmpty()) {
            int el = queue.poll();
            for (Edge e : graph[el]) {
                inDegree[e.des]--;
                if (inDegree[e.des]==0) queue.offer(e.des);
            }
            System.out.print(el+" ");
        }

//        System.out.println(Arrays.toString(inDegree));

    }


    public static void creation(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();

        }
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));



        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
    }

}
