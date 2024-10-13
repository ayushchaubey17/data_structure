package greedyApproch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ActivityProblem2 {
    public static void main(String[] args) {
        int start[] = {0,5,1, 3,5,8};
        int end[] = {6,9,2,4,7,9};

        maxActivity(start, end);
    }

    private static void maxActivity(int[] start, int[] end) {

        int tasks [][] = new int[start.length][3];


        for (int i = 0; i < start.length; i++) {
            tasks[i][0] = i;
            tasks[i][1]= start[i];
            tasks[i][2]= end[i];
        }
        for (int[] el:tasks) System.out.println(Arrays.toString(el));

//        Arrays.sort(tasks,(a,b)->a[2]-b[2]);
        Arrays.sort(tasks, Comparator.comparingInt(a->a[2]));
        System.out.println();
        for (int[] el:tasks) System.out.println(Arrays.toString(el));

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(tasks[0][0]);
        int lastTime = tasks[0][2];


        for (int i = 1; i < tasks.length; i++) {
            if (tasks[i][1] > lastTime) {
                arrayList.add(tasks[i][0]);
                lastTime= tasks[i][2];
            }
        }

        System.out.println(arrayList);

    }



}
