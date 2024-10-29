package graph;

import java.util.ArrayList;

public class FindAllPath {
    public static void main(String[] args) {
        TopologicalSortUsingBfs.creation(TopologicalSortUsingBfs.graph);
        findPath(TopologicalSortUsingBfs.graph,5,1,"");

    }

    private static void findPath(ArrayList<TopologicalSortUsingBfs.Edge>[] graph,int src,int des ,String path) {
        if (src == des){
            System.out.println(path+src);
            return;
        }

        for (TopologicalSortUsingBfs.Edge e :graph[src]){
            findPath(graph,e.des,des,path+src);
        }
    }
}
