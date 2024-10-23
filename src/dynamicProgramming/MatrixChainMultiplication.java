package dynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int arrr[] = {1, 2, 3, 4, 3};

        int cost = usingRecursion(arrr, 1, arrr.length - 1);
        System.out.println(cost);


        int dp[][] = new int[arrr.length][arrr.length];
        for (var arr: dp) Arrays.fill(arr,-1);
    int ans =    usingMemo(arrr, 1, arrr.length - 1, dp);
        System.out.println(ans);


        System.out.println(usingTabulation(arrr));
    }

    private static int usingRecursion(int[] arrr, int i, int j) {

        if (i == j) return 0;
        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int cost1 = usingRecursion(arrr, i, k);
            int cost2 = usingRecursion(arrr, k + 1, j);
            int cost3 = arrr[i - 1] * arrr[k] * arrr[j];
            ans = Math.min(ans, (cost1 + cost2 + cost3));
        }
        return ans;

    }


    private static int usingMemo(int[] arrr, int i, int j, int [][] dp) {
        if (i==j)return 0;

        if (dp[i][j]!=-1) return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int cost1 = usingMemo(arrr, i, k, dp);
            int cost2 = usingMemo(arrr, k+1, j, dp);
            int cost3 = arrr[i - 1] * arrr[k] * arrr[j];
            dp[i][j] = Math.min(ans, (cost1 + cost2 + cost3));
        }
        return dp[i][j];
    }

    private static int usingTabulation(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[arr.length][arr.length];
        
       // all diagonals to zero

        for (int len= 2;len<n;len++){
            for (int i = 1; i <= (n - len); i++) {
                int j = (len+i-1);
                dp[i][j] = Integer.MAX_VALUE;

                for (int k=i;k<j;k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];

                    dp[i][j] = Math.min(dp[i][j], (cost1 + cost2 + cost3));

                }
            }
        }

        printDp(dp);

        return dp[1][n-1];

    }

    private static void printDp(int[][] arr) {
        for (var arrr:arr) {
            for (int el:arrr) System.out.print(el+" ");
            System.out.println();
        }
    }
}
