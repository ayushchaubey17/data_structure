package dynamicProgramming;

import java.util.Arrays;

public class MinimumNumberOfJumps {

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 4};

        System.out.println("\n"+usingTabulation(arr));
    }

    private static int usingTabulation(int[] arr) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        dp[arr.length-1] =0;

        for (int i = dp.length - 2; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            for (int j = i + 1;j<arr.length && j <= (i + arr[i]); j++) {
               if (dp[j]!=-1) {
                   ans = Math.min(ans, 1 + dp[j]);
               }

            }

            if (ans != Integer.MAX_VALUE) dp[i]= ans;
        }
   for (int el:dp) System.out.print(el+" ");

        return dp[0];

    }
}
