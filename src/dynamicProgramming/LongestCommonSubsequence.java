package dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str2 = "ace";
        String str1 = "abcde";


        System.out.println(usingRecursion(str1, str2, str1.length(), str2.length()));
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (var arr: dp) Arrays.fill(arr, -1);

        System.out.println(usingMemo(str1, str2, str1.length(), str2.length(),dp));

        for (var ar : dp) {
            for (int el: ar) System.out.print(el+" ");
            System.out.println();
        }
        System.out.println(usingTabulation(str1,str2));

    }

    private static int usingMemo(String str1, String str2, int l1, int l2, int[][] dp) {
        if (l1==0 || l2==0) {
            dp[l1][l2] =0;
            return 0;
        }

        if (dp[l1][l2]!= -1) return dp[l1][l2];

        if (str1.charAt(l1-1)== str2.charAt(l2-1)){
            dp[l1][l2] = 1+ usingMemo(str1, str2, l1-1, l2-1, dp);
        }
        else {
            int firstOne = usingMemo(str1, str2, l1-1, l2, dp);
            int secondOne = usingMemo(str1, str2, l1, l2-1, dp);
            dp[l1][l2] = Math.max(secondOne, firstOne);
        }
        return  dp[l1][l2];
    }

    private static int usingRecursion(String str1, String str2, int l1, int l2) {
        if (l1==0 || l2==0) return 0;

        //case1
        if (str1.charAt(l1-1) == str2.charAt(l2-1)) return 1+usingRecursion(str1, str2, l1-1, l2-1);

        int forOne = usingRecursion(str1, str2, l1-1, l2);
        int forSecond = usingRecursion(str1, str2, l1, l2-1);

        return Math.max(forOne, forSecond);
    }

    private static int usingTabulation(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];


        for (int i = 1; i < dp.length; i++) {
            char ch = str1.charAt(i-1);
            for (int j = 1; j < dp[0].length ; j++) {

                //valid
            if (ch==str2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
            else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);


                //invalid

            }
        }
        for (var ar : dp) {
            for (int el: ar) System.out.print(el+" ");
            System.out.println();
        }

        return dp[str1.length()][str2.length()];

    }

}
