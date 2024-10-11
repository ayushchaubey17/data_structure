package queue;
import java.util.LinkedList;
import  java.util.Queue;
import java.util.ArrayDeque;

public class UsingJCF {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque();
        Queue<Integer> q2 = new LinkedList<>();


        q.add(112);
        q.add(12);
        System.out.println(q);
    }
}
