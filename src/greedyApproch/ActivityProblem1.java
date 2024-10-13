package greedyApproch;
// sorting basased on end time

import java.util.ArrayList;

public class ActivityProblem1 {
    public static void main(String[] args) {
//        int start[] = {10, 12, 20};
//        int end[] = {20, 25, 30};

        int start[] = {1, 3, 0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        maxActivity(start, end);
    }

    private static void maxActivity(int[] start, int[] end) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        int lastTime = end[0];


        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastTime) {
                // next task should be assigned
                arrayList.add(i);
                lastTime = end[i];
            }
        }


        for (int i: arrayList) System.out.print("A"+i+" ");

    }
}
