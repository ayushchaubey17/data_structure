package greedyApproch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivityProblem3 {
    public static void main(String[] args) {
        int start[] = {0, 5, 1, 3, 5, 8};
        int end[] = {6, 9, 2, 4, 7, 9};

        maxActivity(start, end);
    }

    static class tasks {
        private  int index;
        private  int start;
        private  int end;

        public tasks(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return this.index+" ,"+this.start+","+this.end;
        }
    }


    private static void maxActivity(int[] start, int[] end) {
        tasks[] arr = new  tasks[start.length];

        for (int i = 0; i < start.length; i++)  arr[i] = new tasks(i, start[i], end[i]);

        ArrayList<Integer> arrayList = new ArrayList();

        Arrays.sort(arr, Comparator.comparingInt(o->o.end));

        for (tasks el:arr) System.out.println(el);

    }

}