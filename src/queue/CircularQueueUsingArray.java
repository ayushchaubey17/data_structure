package queue;

import java.util.Arrays;
import java.util.Queue;

public class CircularQueueUsingArray {
    static class Queue {
        static  int len;
//        static  int arr[];

        static  int rear,front,arr[];

        public Queue(int len) {
            this.len = len;
            arr =new int[len];
            front = -1;
            rear = -1;
        }

        public static boolean isEmpty() {
            return (front== -1 && rear== -1);
        }

        public static boolean isFull() {
            return ((rear+1)%len== front);
        }

        public static void offer(int el) {
            if (isFull()){
                System.out.println("");
                return;
            }

            if (front == -1) front++;

            rear= (rear+1)%len;
            arr[rear] =el;
        }

        public static int poll() {
            if (isEmpty()) {
                System.out.println("empty");
                return -1;
            }
            int ans = arr[front];
            arr[front] =0;

            if (rear==front){

                rear = front = -1;
                return ans ;
            }
            front = front+1%len;
            return ans;
        }
        public  String toString() {
            return Arrays.toString(arr);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(6);
        q.offer(21);
        q.offer(22);
        q.offer(23);
        q.poll();
        q.poll();
        q.offer(24);
        q.offer(25);
        q.offer(26);
        q.offer(27);
        q.offer(28);
        q.offer(29);
        System.out.println(q);
    }

}
