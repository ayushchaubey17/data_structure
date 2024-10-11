package queue;

import java.util.LinkedList;
import java.util.Queue;

public class NonRepeatingLetterInAAtream {
    public static void main(String[] args) {
        String str = "aabccxb";
      String ans =   solution(str);
        System.out.println(ans);
    }

   static String solution(String str) {
       Queue<Character> q = new LinkedList<>();
       String ans ="";

       // frequency array
       int arr[] = new int[26];

       for (char ch : str.toCharArray()) {
                q.offer(ch);
                arr[ch-97]++;

           while (!q.isEmpty() && arr[q.peek() - 97] > 1) {
               q.poll();

           }

           ans+= q.isEmpty()?"-1":q.peek();


       }
       return ans;


   }
}
