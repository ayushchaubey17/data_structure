package dynamicProgramming;

import java.util.Arrays;

public class StringConversion {
    public static void main(String[] args) {

        String a = "peer";

        String b = "sea";
        System.out.println(usingRecursion(a,b,a.length(),b.length()));


        int dp[][] = new int[a.length() + 1][b.length() + 1];
        for (var arr: dp) Arrays.fill(arr,-1);
        System.out.println(usingMemoization(a,b,a.length(),b.length(),dp));
        System.out.println(usingTabulation(a, b));

    }

    private static int usingRecursion(String a, String b, int l1, int l2) {
        if (l1==0 || l2==0) return (l1==0)?l2:l1;
        if (a.charAt(l1-1)== b.charAt(l2-1)) return usingRecursion(a, b, l1-1, l2-1);
        return 1+Math.min(usingRecursion(a, b, l1, l2-1), usingRecursion(a, b, l1-1, l2));


    }

    private static int usingMemoization(String a, String b, int l1, int l2,int [][]dp) {
        if (l1==0 || l2==0) return (l1==0)?l2:l1;

        if (dp[l1][l2]!= -1) return dp[l1][l2];
        if (a.charAt(l1-1)== b.charAt(l2-1)) return  dp[l1][l2] = usingMemoization(a, b, l1-1, l2-1,dp);
        return dp[l1][l2] = 1+Math.min(usingMemoization(a, b, l1, l2-1,dp), usingMemoization(a, b, l1-1, l2,dp));


    }

    private static int usingTabulation(String a, String b) {
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < dp.length; i++)dp[i][0]=i;
        for (int i = 1; i < dp[0].length; i++)dp[0][i]=i;


        for(int i=1;i< dp.length;i++)
            for (int j = 1; j <dp[0].length ; j++)
                dp[i][j] = (a.charAt(i-1)==b.charAt(j-1))? dp[i-1][j-1] : 1+Math.min(dp[i-1][j],dp[i][j-1]);


        return dp[a.length()][b.length()];
    }

    private static void print(int[][] dp) {
        for (int[] arr : dp) {
            for (int el: arr) System.out.print(el+" ");
            System.out.println();
        }
    }


}
