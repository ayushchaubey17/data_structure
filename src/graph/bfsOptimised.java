package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsOptimised {
    static class  Edge{
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[v];;;

        creation(graph);

        bfs(graph);

        System.out.println();
        dfs(graph);


     boolean ans =    detectCycle(graph);
        System.out.println("\n"+ans);


        boolean ans2 = checkBipartite(graph);
        System.out.println(ans2);

        System.out.println(checkForCycle(graph));

    }

    private static boolean checkForCycle(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];


        for (int i = 0; i <graph.length ; i++) {
            if (!visit[i]) {
                if (checkForCycleUtil(graph, visit, stack, i)) {
                    return  true;
                }
            }

        }
        return false;
    }

    private static boolean checkForCycleUtil(ArrayList<Edge>[] graph, boolean[] visit, boolean[] stack, int curr) {
        visit[curr] = stack[curr] = true;
        for (Edge e : graph[curr]) {
            if (stack[e.des])return true;

            if (!visit[e.des] && checkForCycleUtil(graph, visit, stack, e.des)) {
                return true;
            }

        }
        return false;
    }

    private static boolean checkBipartite(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i]==0){
                queue.add(i);
                color[i] = 1;

                while (!queue.isEmpty()) {
                    int r = queue.poll();

                    for (Edge e : graph[i]) {
                        int dest = e.des;
                        //colored nii hai---0
                        if (color[dest]==0){
                            color[dest]= (color[r]==1)?-1:1;
                            queue.add(dest);
                        }

                        //colored hai
                        else if (color[dest]==color[r]) {
                                    return false;
                        }


                    }

                }


            }
        }
        return true;
    }



    private static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];


        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]){
             if (detectCycleUtil(graph, visit, i, -1))return true;
            }
        }

       return false;
    }

    private static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visit, int curr, int parr) {
        visit[curr] = true;

        for (Edge e: graph[curr]){
            int dest = e.des;
            if(!visit[dest]) {
                if (detectCycleUtil(graph, visit, dest, curr)) return true;
            }
            else if (visit[dest] && dest!=parr)return true;
        }
        return false;
    }

    private static void dfs(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length ; i++) {
            if (!visit[i]){
                dfsUtil(graph,visit,i);
            }

        }
    }

    private static void dfsUtil(ArrayList<Edge>[] graph, boolean[] visit, int i) {
        visit[i] = true;
        System.out.print(i+" ");
        for (Edge e : graph[i]) {
            if (!visit[e.des]) dfsUtil(graph,visit,e.des);
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length ; i++) {
            if (!visit[i]){
                bfsUtil(graph, visit,i);
            }

        }
    }

    private static void bfsUtil(ArrayList<Edge>[] graph, boolean[] visit, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;

        while (!queue.isEmpty()) {
            int r = queue.poll();
            System.out.print(r+" ");

            for (Edge e :graph[r]){
                if (!visit[e.des]){
                    queue.offer(e.des);
                    visit[e.des]= true;
                }
            }
        }

    }

    private static void creation(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();

        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));


        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,2));
    }
}
