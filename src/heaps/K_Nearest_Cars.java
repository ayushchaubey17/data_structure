package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class K_Nearest_Cars {
    static  Points[] heap;
    static  int i=0;
    public static void main(String[] args) {

        int points[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
//        Arrays.sort(points,(a,b)->((a[1]*a[1])+(a[2]*a[2]))-((b[1]*b[1])+(b[2]*b[2])));

        for(int []arr: points)
            System.out.println(Arrays.toString(arr));


        method2(points, k);
        System.out.println();
        method3(points, k);


    }

    private static void method3(int[][] points, int k) {
      heap  = new Points[points.length];

        for (int j = 0; j < points.length; j++)
            insert(new Points(j, (points[j][0] * points[j][0]) + (points[j][1] * points[j][1])));


        for (int j = 0; j < 3; j++) {
            System.out.println("CAR "+remove().index);

        }


    }

    public static void insert(Points points) {
        heap[i++]= points;

        int child = i-1;
        int par = (child-1)/2;

        while (child > 0 && heap[par].dist > heap[child].dist) {
            Points temp = heap[par];
            heap[par] = heap[child];
            heap[child] = temp;

            child = par;
            par = (child-1)/2;

        }

    }

    public static Points remove() {
Points   ans = heap[0];
heap[0] = heap[--i];
        heapify(0);
        return ans;

    }

    private static void heapify(int i) {
        int min = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if (left<i && heap[min].dist > heap[left].dist)min = left;
        if (right<i && heap[min].dist > heap[right].dist)min = right;

        if (min != i) {
            Points temp = heap[min];
            heap[min] = heap[i];
            heap[i] = temp;
            heapify(min);
        }


    }


    private static void method2(int[][] points, int k) {
        PriorityQueue<Points> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < points.length ; i++)
            priorityQueue.add(new Points(i, (points[i][0] * points[i][0]) + (points[i][1] * points[i][1])));

        for (int i = 0; i <3 ; i++) {
            System.out.println("CAR "+priorityQueue.poll().index);

        }

    }

    static class Points implements Comparable<Points> {
        private  int index,x,y,dist;

        public Points(int index,int dist) {
            this.index = index;

            this.dist = dist;
        }


        @Override
        public  int compareTo(Points p2){
            return this.dist -p2.dist;
        }
    }
}

