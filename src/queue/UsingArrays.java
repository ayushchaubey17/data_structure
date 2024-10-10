package queue;

import java.util.Arrays;

public class UsingArrays {
    static class Queue{
        static int len;
       static int arr[];
       static int rear;


        public Queue(int len) {
            this.len = len;
            arr = new int[len];

            rear =-1;
        }

        public static boolean isEmpty() {
            return  rear== -1;
        }

        public static int peek() {
            return isEmpty()? -1:  arr[0];
        }

        public static boolean push(int el){
            if (rear == len-1) {
                System.out.println("can not insert your queue is full");
                return false;
            }
            rear++;
            arr[rear] = el;
            return  true;

        }


        public static int getLen() {
            return len;
        }

        public static int pop() {
            if (rear == -1) return  -1;
            int temp = arr[0];

            for (int i = 0; i <rear ; i++) {
                arr[i] = arr[i+1];
            }
            arr[rear--] =0;
            return  temp;
        }

        @Override
        public String toString() {
            return Arrays.toString(arr);
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(6);
        q.push(12);
        q.push(14);
        q.push(11);
        q.push(23);
        q.push(23);
        q.push(23);
        q.push(11);
        q.pop();
        System.out.println(q);
        System.out.println(q.getLen());

    }
}
