package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithKStop {
    static  class  Edge{
        private  int src;
        private  int des;
        private  int cost;

        public Edge(int src, int des, int cost) {
            this.src = src;
            this.des = des;
            this.cost = cost;
        }
    }

    static  class  Trio{
        int ver;
        int cost;
        int k;

        public Trio(int ver, int cost, int k) {
            this.ver = ver;
            this.cost = cost;
            this.k = k;
        }
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int des = 3;
        int k = 1;


        int ans = creatingGraph(flights,n,src,k,des);
        System.out.println(ans);
    }

    private static int creatingGraph(int[][] flights, int n, int src,int k,int des) {
        ArrayList<Edge> graph[] = new ArrayList[n];

        intializeEdge(graph,flights);

        //dikastra algo
        int dis[] = new int[n];
        for (int i = 0; i < n; i++) if (i != src) dis[i] = Integer.MAX_VALUE;

        Queue<Trio> queue = new LinkedList<>();

        queue.offer(new Trio(src, 0, 0));

        while (!queue.isEmpty()) {
            Trio curr = queue.poll();
            if (curr.k> k) break;

            for (Edge e : graph[curr.ver]) {
                int u = e.src;
                int v = e.des;
                int wt = e.cost;

                if (dis[v]> curr.cost+wt){
                    dis[v] = curr.cost+wt;
                    queue.offer(new Trio(v,dis[v] , curr.k + 1));
                }
            }


        }


        return (dis[des]== Integer.MAX_VALUE)?-1 :dis[des];



    }

    private static void intializeEdge(ArrayList<Edge>[] graph, int[][] flights) {

        for(int i=0;i<graph.length;i++)graph[i]= new ArrayList<>();

        for (int i = 0; i < flights.length ; i++)
            graph[flights[i][0]].add(new Edge(flights[i][0],flights[i][1],flights[i][2]));

    }
}
