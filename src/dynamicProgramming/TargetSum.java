package dynamicProgramming;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int numbers[] = new int[]{4, 2, 7, 1, 3};
        int sum = 10;

        System.out.println(usingRecursion(numbers,sum,numbers.length));


        int dp[][] = new int[numbers.length + 1][sum + 1];
        for (var arr:dp) Arrays.fill(arr,-1);
        for (int i = 0; i < dp.length ; i++) dp[i][0]=  1;
        for (int i = 0; i <=sum ; i++)dp[0][i] = 0;


       int ans =  usingMemoization(numbers, sum, dp,numbers.length);
        System.out.println(ans);
//        for (var arr: dp)
//        { for (int el:arr) System.out.print(el+" ");
//        System.out.println();}


        System.out.println(usingTabulation(numbers,sum));
    }

    private static int usingMemoization(int[] numbers, int sum, int[][] dp, int i) {
        if (i==0) return sum==0?1:0;


        if (dp[i][sum]!= -1) return dp[i][sum];

        int include =0;
        if (numbers[i-1]<=sum){
            include = usingMemoization(numbers,sum-numbers[i-1],dp,i-1);
        }
       int exclude = usingMemoization(numbers,sum,dp,i-1);

        dp[i][sum] = include+exclude;
        return dp[i][sum];
    }

    private static int usingRecursion(int[] numbers, int sum, int i) {
        if (i==0 ) return sum==0?1:0;
        if (sum==0) return 1;
        if(sum<0) return 0;

        int include = usingRecursion(numbers,sum-numbers[i-1],i-1);
        int exclude = usingRecursion(numbers,sum,i-1);
        return include+exclude;
    }

    private static int usingTabulation(int[] numbers, int sum) {
        int dp[][] = new int[numbers.length + 1][sum + 1];
        for(int i=0;i< dp.length;i++)dp[i][0]=1;
        for (int i = 1; i < dp.length; i++) {
            int el = numbers[i-1];
            for (int j = 1; j < dp[0].length; j++) {
                //exclude
                int exclude = dp[i-1][j];

                //include
                int include =0;
                if(el<=j){
                    include = dp[i-1][j-el];
                }
              dp[i][j] = include+exclude;

            }
        }

        for (var arr: dp)
        { for (int el:arr) System.out.print(el+" ");
            System.out.println();}

        return dp[numbers.length][sum];
    }
}
