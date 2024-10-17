package dynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapSack {
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int capicity =7;

        System.out.println(usingRecursion(val,wt,capicity,val.length));





        //method 2
        int dp[][] = new int[val.length + 1][capicity + 1];

        for (var arr: dp) Arrays.fill(arr, -1);
        System.out.println(usingMemoization(val,wt,capicity, val.length,dp ));


        System.out.println(usingTabulation(val,wt,capicity));



    }

    private static int usingRecursion(int[] val, int[] wt, int capicity, int i) {
        if (i==0 || capicity==0)return 0;
        //include
        if (wt[i - 1] <= capicity) {
            int include = val[i-1]+usingRecursion(val,wt,capicity-wt[i-1],i);
            int exclude = usingRecursion(val,wt,capicity,i-1);
            return Math.max(include, exclude);

        }
        else {
         return    usingRecursion(val, wt, capicity,i - 1);
        }
    }

    private static int usingMemoization(int[] val, int[] wt, int capicity, int i, int[][] dp) {

        if (i==0 || capicity ==0) return 0;


        if (dp[i][capicity] != -1) return dp[i][capicity];

        if (capicity>= wt[i-1]){

            int include = val[i-1]+ usingMemoization(val, wt, capicity-wt[i-1], i, dp);
            int exclude =  usingMemoization(val, wt, capicity, i-1, dp);

            dp[i][capicity] =  Math.max(include, exclude);
        }
        else
          dp[i][capicity] =  usingMemoization(val, wt, capicity, i-1, dp);

        return dp[i][capicity];
    }


    private static int usingTabulation(int[] val, int[] wt, int capicity) {
        int dp[][] = new int[val.length + 1][capicity + 1];

        for (int i = 1; i < dp.length; i++) {
            int profit = val[i - 1];
            int weight = wt[i-1];
            for (int j = 1; j < dp[0].length; j++) {

                //include
                if (weight<= j){
                    int include = profit+ dp[i][j - weight];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);

                }

                else {
                    dp[i][j] =  dp[i - 1][j];
                }

            }
        }

        return dp[val.length][capicity];
    }
    
}
