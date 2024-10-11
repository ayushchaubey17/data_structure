package queue;

import java.util.*;

public class InterLeaveTwoHalfsOfAQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        System.out.println(interLeave(q));

    }

    private static Queue<Integer> interLeave(Queue<Integer> q) {
        Queue<Integer> q2 = new LinkedList<>();
        int size = q.size();
        for (int i = 1; i <= size / 2; i++) q2.offer(q.poll());

        for (int i = 1; i <= size / 2; i++) {

            q.offer(q2.poll());
            q.offer(q.poll());
        }
        return q;
    }
}
