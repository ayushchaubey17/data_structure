package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue2 {
    private static class Stack {
        private static Queue<Integer> q1 = new LinkedList<>();
        private static Queue<Integer> q2 = new LinkedList<>();

        public static void push(int el) {
            if (!q1.isEmpty()) {
                q1.offer(el);
            } else {
                q2.offer(el);
            }
        }

        public static int pop() {
            if (q1.isEmpty() && q2.isEmpty()) {
                System.out.println("stack is empty");
                return -1;
            }

            int el = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    el = q1.poll();
                    if (!q1.isEmpty()) q2.offer(el);  // move to q2 except last element
                }
            } else {
                while (!q2.isEmpty()) {
                    el = q2.poll();
                    if (!q2.isEmpty()) q1.offer(el);  // move to q1 except last element
                }
            }

            return el;
        }

        @Override
        public String toString() {
            return (!q1.isEmpty()) ? q1.toString() : q2.toString();
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.pop();

        System.out.println(stack);  // should print remaining elements
    }
}
