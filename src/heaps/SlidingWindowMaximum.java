package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int windows[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        System.out.println(Arrays.toString(usingBruteForce(windows,k)));
        System.out.println(Arrays.toString(usingHeap(windows, k)));
    }

    public static int[] usingHeap(int[] windows, int k) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i <k ; i++) {
            priorityQueue.add(new Pair(windows[i], i));
        }
        int[] ans = new int[windows.length - k + 1];
        ans[0] = priorityQueue.peek().val;

        for (int i = k; i < windows.length; i++) {


            while (!priorityQueue.isEmpty() && priorityQueue.peek().idx <= (i - k)) {
                priorityQueue.poll();
            }
            priorityQueue.add(new Pair(windows[i], i));
            ans[i-k+1] = priorityQueue.peek().val;

        }
        return ans;
    }

    static class Pair implements Comparable<Pair>{
        private  int val,idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public  int compareTo(Pair p2)
        {
            return p2.val - this.val;
        }

    }


    private static int[] usingBruteForce(int[] windows, int k) {
        int ans[] = new int[windows.length - k + 1];

        for (int i = 0; i <= windows.length-k; i++) {
            int max= windows[i];
            for (int j = 1; j < k; j++) if (windows[i+j]>max)max = windows[i+j];

            ans[i]= max;

        }
        return  ans;
    }
}
