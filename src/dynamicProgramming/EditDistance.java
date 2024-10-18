package dynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String... args) {
        String s1 = "intention" ;
        String s2 = "execution";

     int ans =   usingRecursion(s1, s2, s1.length(), s2.length());
        System.out.println(ans);


        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (var ar: dp) Arrays.fill(ar, -1);



        System.out.println(usingMemoization(s1, s2, s1.length(), s2.length(),dp));
    }

    private static int usingMemoization(String s1, String s2, int l1, int l2, int[][] dp) {
        if (l1==0)return l2;
        if (l2==0) return l1;
        if (dp[l1][l2]!=-1) return dp[l1][l2];

        if (s1.charAt(l1-1) == s2.charAt(l2-1)) {
          return   dp[l1][l2] = usingMemoization(s1, s2, l1-1, l2-1, dp);
        }
        else {

            //add
            int o1 =usingMemoization(s1, s2, l1, l2 - 1, dp);

            //delete
            int o2 = usingMemoization(s1, s2, l1-1, l2 , dp);

            //replace
            int o3 = usingMemoization(s1, s2, l1-1, l2-1 , dp);
            //add    insert     delete
            return dp[l1][l2] = 1+Math.min(o1,Math.min(o2,o3));
        }
    }

    private static int usingRecursion(String s1, String s2, int l1, int l2) {
        if (l1==0 ) return  l2;
        if (l2==0 ) return  l1;
        if (s1.charAt(l1-1)== s2.charAt(l2-1)) return usingRecursion(s1, s2, l1 - 1, l2 - 1);
        else {
            //delete
            int o1 = 1+usingRecursion(s1, s2, l1-1, l2);


            //add

            int o2 = 1+ usingRecursion(s1, s2, l1, l2-1);


            //replace

            int o3 = 1+usingRecursion(s1, s2, l1-1, l2-1);
            return Math.min(o1, Math.min(o2, o3));
        }
    }
}
