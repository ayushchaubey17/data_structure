package dynamicProgramming;

import java.util.Arrays;

public class Warshall_Algorithm {
    public static void main(String[] args) {
        int [][] graph = {

                {0,1,1,0},
                {0,0,1,0},
                {0,0,0,1},
                {1,0,0,0},
        };

        algo(graph);
    }

    private static void algo(int[][] graph) {
        int v = graph.length;
        int transitiveClosure[][] = new int[v][v];

        System.arraycopy(graph, 0, transitiveClosure, 0, v);

        for (int k=0;k<v;k++)
            for (int i=0;i<v;i++)
                for (int j=0;j<v;j++) {
                    transitiveClosure[i][j] = transitiveClosure[i][j] | (transitiveClosure[i][k] & transitiveClosure[k][j]);

                }

        printArray(transitiveClosure);


    }

    public  static  void  printArray(int [][] transitiveClosure ) {
        for (int[] arr : transitiveClosure)
            System.out.println(Arrays.toString(arr));

    }
}
