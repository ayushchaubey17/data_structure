package queue;

import java.util.LinkedList;
import java.util.Queue;


public class StackUsingTwoQueue {

  private static class Stack {
        private static Queue<Integer> q1 = new LinkedList<>();
        private static Queue<Integer> q2 = new LinkedList<>();



        //o(n)

        public static void push(int el) {
            if (q1.isEmpty() && q2.isEmpty()){
                q1.offer(el);
                return;
            }
            else if (q2.isEmpty()) {
                q2.offer(el);
                while (!q1.isEmpty()) q2.offer(q1.poll());
            }
            else{
                q1.offer(el);
                while (!q2.isEmpty()) q1.offer(q2.poll());
            }


        }

        public static int pop() {

            if (q1.isEmpty() && q2.isEmpty()){
                System.out.println("empty stack");
                return -1;

            }
            return  (q1.isEmpty())? q2.poll() :q1.poll();
        }

        public static int peek() {
            if (q1.isEmpty() && q2.isEmpty()){
                System.out.println("stack is empty");

                return  -1;
            }


            return q1.isEmpty() ? q2.peek() : q1.peek();
        }


      public String toString() {
            if (q1.isEmpty() && q2.isEmpty()) return "[]";
            return (q1.isEmpty())? q2.toString(): q1.toString();

      }
    }

    public static void main(String[] args) {
       Stack stack = new Stack();
       stack.push(12);
       stack.push(13);
       stack.push(14);
       stack.pop();

        System.out.println(stack);
    }


}


