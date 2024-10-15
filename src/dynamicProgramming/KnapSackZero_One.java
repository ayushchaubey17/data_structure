package dynamicProgramming;

import java.util.Arrays;


public class KnapSackZero_One {
    public static void main(String[] args) {
        int value[] = {15, 14, 10, 45, 30};
        int weight[] = {2, 5, 1, 3, 4};
        int maxWeight = 7;

//     int ans =   usingRecursion(value, weight, maxWeight, value.length);
//        System.out.println(ans);


        int dp[][] = new int[value.length+1][maxWeight+1];
        for(int arr[]:dp) Arrays.fill(arr, -1);
        System.out.println( usingMemoization(value, weight, maxWeight, value.length, dp));


        System.out.println(usingTabulation(value, weight, maxWeight));
    }

    private static int usingTabulation(int[] value, int[] weight, int maxWeight) {

        int dp[][] = new int[value.length + 1][maxWeight + 1];

        // make it first row and column is zero by default

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int price = value[i - 1];
                int w = weight[i-1];

                if (w<=j){
                    int include = price+dp[i-1][j-w];
                    int exclude = dp[i-1][j];

                    dp[i][j] = Math.max(include, exclude);

                }

                else{
                    dp[i][j] = dp[i-1][j];
                }


            }
        }


        for (var el:dp){
            for(int ele:el) System.out.print(ele+" ");
            System.out.println();
        }

return dp[value.length][maxWeight];



    }

    private static int usingRecursion(int[] value, int[] weight, int maxWeight, int i) {

        if (i== 0 || maxWeight==0) return 0;

        if (maxWeight>=weight[i-1]){
            //include
            int include = value[i-1]+usingRecursion(value, weight, maxWeight-weight[i-1], i-1);


            //exclude
            int exclude = usingRecursion(value, weight, maxWeight, i-1);

            return Math.max(include, exclude);

        }
        else {
            return usingRecursion(value, weight, maxWeight, i -1);
        }


    }

    private static int usingMemoization(int[] value,int[] weight,int maxWeight,int i ,int [][]dp){
        if (i==0 || maxWeight==0){
            dp[i][maxWeight] = 0;
            return dp[i][maxWeight];
        }

        //memoization
        if (dp[i][maxWeight] != -1)return dp[i][maxWeight];


        if (maxWeight>=weight[i-1]){
                int include = value[i-1]+usingMemoization(value, weight, maxWeight-weight[i-1], i-1, dp);
                int exclude = usingMemoization(value, weight, maxWeight, i-1, dp);

                int profit = Math.max(include,exclude);
                dp[i][maxWeight] = profit;
                return profit;
        }
        else {
            dp[i][maxWeight] = usingMemoization(value, weight, maxWeight, i-1, dp);
            return dp[i][maxWeight];
        }

    }




}
