package queue;
import  java.util.Stack;

public class QueueUsingTwoStacks {
    static  class  Queue{
  private     static   Stack<Integer> stack1 = new Stack<>();
    private   static   Stack<Integer> stack2 = new Stack<>();
    private   static  int size=0;



        public static void add(int el) {
            if (stack1.isEmpty() && stack2.isEmpty()) stack1.push(el);

            else{
                while (!stack1.isEmpty()) stack2.push(stack1.pop());
                stack1.push(el);
                while (!stack2.isEmpty()) stack1.push(stack2.pop());
            }
            size++;

        }


        public static int remove() {
            size = (size>0)?size--:size;
            return  (stack1.isEmpty())? -1: stack1.pop();

        }

        public String toString() {
            if (stack1.isEmpty()) return "empty queue";
            Stack<Integer> stack3 = new Stack<>();
            String ans = "--";
            while (!stack1.isEmpty()){
                int el = stack1.pop();

                ans+= el+"--";
                stack3.push(el);
            }
            while (!stack3.isEmpty()) stack1.push(stack3.pop());
            return  ans;

        }




    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(12);
        q.add(13);
        q.add(14);
        System.out.println(q);
    }
}
