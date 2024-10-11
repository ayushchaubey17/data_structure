package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseTheQueue {

private static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);


         reverseIt();
        System.out.println(q);
    }


    private static void reverseIt() {

        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty()) stack.push(q.poll());

        while (!stack.isEmpty()) q.offer(stack.pop());


    }
}
