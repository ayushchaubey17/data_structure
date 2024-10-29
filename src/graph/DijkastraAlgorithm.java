package graph;

import java.util.*;

public class DijkastraAlgorithm {
   private static  class  Edge{
       private int src;



       private int des;
       private int weitght;

       public Edge(int src, int des, int weitght) {
           this.src = src;
           this.des = des;
           this.weitght = weitght;
       }
    }

    public static class Pair{
       int vertices;
       int distance;

        public Pair(int vertices, int distance) {
            this.vertices = vertices;
            this.distance = distance;
        }

      
    }





    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        creation(graph);

        belmanFord(graph);
//        bfs(graph);
        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>((a,b)->a.distance-b.distance);


        findShortest(graph, pairPriorityQueue);

    }

    private static void belmanFord(ArrayList<Edge>[] graph) {
       int v = graph.length;
        int dist[] = new int[v];
        for (int i = 0; i < dist.length; i++) {
            if (i != 0)dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <=v-1 ; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (Edge e : graph[j]) {
                    int u = e.src;
                    int V = e.des;
                    int wt = e.weitght;

                    if (dist[u]!=Integer.MAX_VALUE && dist[V]>dist[u]+wt){
                        dist[V]= dist[u]+wt;
                    }

                }
            }

        }

        System.out.println(Arrays.toString(dist));
    }

    private static void findShortest(ArrayList<Edge>[] graph, PriorityQueue<Pair> pairPriorityQueue) {
        int dist[] = new int[graph.length];
        for (int i = 1; i < dist.length ; i++)dist[i] = Integer.MAX_VALUE;
        boolean[] visit = new boolean[graph.length];

        pairPriorityQueue.offer(new Pair(0,0));
        while (!pairPriorityQueue.isEmpty()) {
            Pair p = pairPriorityQueue.poll();
            if (!visit[p.vertices]){
                visit[p.vertices]=true;
            for (Edge e: graph[p.vertices])
            {


               int u = e.src;
               int v = e.des;
               int wt = e.weitght;

               if (dist[v]> dist[u]+wt) {
                   dist[v]= dist[u]+wt;

                   pairPriorityQueue.offer(new Pair(v,dist[v]));
               }

                }
            }

        }

        System.out.println("-->"+Arrays.toString(dist));
    }

    private static void bfs(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]){
                bfsUtil(i,graph,visit);
            }

        }



    }

    private static void bfsUtil(int i, ArrayList<Edge>[] graph, boolean[] visit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;

        while (!queue.isEmpty()) {
            int el = queue.poll();
            System.out.print(el+" ");

            for (Edge e : graph[el]) {
                int des = e.des;
                if (!visit[des]) {
                    queue.offer(des);
                    visit[des] = true;

                }
            }
        }



    }

    private static void creation(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();


        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));


        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));



    }



}
