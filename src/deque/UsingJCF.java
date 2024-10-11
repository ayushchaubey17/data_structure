package deque;

import java.util.*;

public class UsingJCF {
    public static void main(String ...args) throws NumberFormatException {
        TreeSet<Integer> hs = new TreeSet<>();
        try {
            String a = "1a23";
            int b = Integer.parseInt(a);
        } catch (NumberFormatException e) {
            System.out.println("handled");
        }
    }
}
