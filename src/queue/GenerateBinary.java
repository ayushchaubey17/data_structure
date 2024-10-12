package queue;

import java.util.LinkedList;
import java.util.Queue;


public class GenerateBinary {
    public static void main(String[] args) {
        int n = 10;
        generate(n);
    }

    private static void generate(int n) {

        Queue<String> q = new LinkedList<>();

        q.offer("1");

        while (n-- > 0) {
            String s = q.poll();
            System.out.print(s+" ");

            q.offer(s + "0");
            q.offer(s + "1");
        }


    }


}

