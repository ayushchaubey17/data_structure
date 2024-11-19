package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectingCitiesWIthMinCost {
    static class Edge{
        int src,des,weight;

        public Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }


    public static void main(String[] args) {
        int cities[][] = {
                {0,1,2,3,4},
                {1,0,5,0,7},
                {2,5,0,6,0},
                {3,0,6,0,0},
                {4,7,0,0,0}
        };


        int v = cities.length;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph,cities);

        bfs(graph);
        System.out.println();

        prims(graph);
    }

    private static void prims(ArrayList<Edge>[] graph) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a,b)->a.cost-b.cost);
        boolean visit[] = new boolean[graph.length];
        priorityQueue.offer(new Pair(0, 0));

        int cost= 0;

        while (!priorityQueue.isEmpty()) {
            Pair p = priorityQueue.poll();
            if (!visit[p.ver]) {
                visit[p.ver] = true;
                cost+=p.cost;
                for (Edge e : graph[p.ver]) {
                    priorityQueue.offer(new Pair(e.des, e.weight));
                }
            }

        }

        System.out.println(cost);
    }


    static  class Pair{
        int ver,cost;

        public Pair(int ver, int cost) {
            this.ver = ver;
            this.cost = cost;
        }
    }

    private static void bfs(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length ; i++) {
            if (!visit[i])bfsUtil(graph, i,visit);

        }
    }

    private static void bfsUtil(ArrayList<Edge>[] graph, int i,boolean [] visit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;
        while (!queue.isEmpty()) {
            int el = queue.poll();
            System.out.print(el+" ");

            for (Edge e : graph[el]) {
                if (!visit[e.des]) {
                    queue.offer(e.des);
                    visit[e.des] = true;
                }
            }
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph, int[][] cities) {
        for(int i=0;i< graph.length;i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j <cities[0].length ; j++) {
                int wt= cities[i][j];
                if (wt !=0) graph[i].add(new Edge(i,j,wt));
            }

        }

    }
}
