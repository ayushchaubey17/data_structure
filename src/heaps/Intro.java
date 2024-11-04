package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Intro {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());


        priorityQueue.add(12);
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(4);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

    }
}