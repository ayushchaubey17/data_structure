package deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingDeque {
    static  class Queue{
      static   Deque<Integer> deque = new LinkedList<>();

        public static void offer(int el) {
            deque.offerLast(el);
        }
        public static int  poll() {
            if (deque.isEmpty()){
                return -1;
            }
          return   deque.removeFirst();
        }

        public static int size() {
          return   deque.size();
        }

        public static boolean isEmpty() {
            return deque.isEmpty();
        }

        @Override
        public String toString() {
            return deque.toString();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.offer(12);
        q.offer(13);
        q.offer(14);
        q.poll();
        System.out.println(q);
    }
}
