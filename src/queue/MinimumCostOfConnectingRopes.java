package queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostOfConnectingRopes {

    public static void main(String args[]) {
        int []ropes = {4, 3, 2, 6};

        System.out.println("Total cost for connecting"
                + " ropes is "
                + minCost(ropes));

    }

    private static int minCost(int... ropes) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();

        for (int rope:ropes) priorityQueue.offer(rope);

        int cost =0;
        while (priorityQueue.size()>1){
            int firstRope = priorityQueue.poll();
            int secondRope = priorityQueue.poll();

            int combineRope = firstRope + secondRope;
            cost+=combineRope;
            priorityQueue.offer(combineRope);
        }

        return cost;

    }
}