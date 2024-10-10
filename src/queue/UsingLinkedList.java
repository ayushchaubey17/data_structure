package queue;

public class UsingLinkedList {

    static class Node {
        private  int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    static  class  Queue{
        private static Node head = null;
        private static Node tail = null;

        public static boolean isEmpty() {
            return (head== null);
        }

        public static int peek() {
            return (head==null)?-1: head.data;

        }

        public static int pop() {
            if (head == null) {
                return  -1;
            }
            int temp = head.data;

            head = head.next;
            return temp;
        }

        public static void push(int ele) {
            Node newNode = new Node(ele);
            if (tail==null){
                head = tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
        }


        public String toString() {

            if (head == null) return "no element";

            String ans = "";
            for (Node p = head; p != null; p = p.next) {
                ans+= p.data+"->";
            }
            return  ans+="null";
        }

    }


    public static void main(String[] args) {
         Queue q = new Queue();
         q.push(12);
         q.push(13);
         q.push(14);
         q.push(15);
         q.pop();
         q.pop();
        System.out.println(q);

    }

}
