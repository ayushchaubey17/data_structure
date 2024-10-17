package dynamicProgramming;

import java.util.Arrays;

public class RodCuting {
    public static void main(String[] args) {
        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};

        int rodLength = 8;

        System.out.println(usingTabulation(length,price,rodLength));
        System.out.println(usingTabulation2(length,price,rodLength));
        System.out.println(usingRecursion(length,price,rodLength,length.length));
        int dp[][] = new int[length.length + 1][rodLength + 1];
        for (var arr: dp) Arrays.fill(arr, -1);
        System.out.println(usingMemoization(length,price,rodLength,length.length,dp));


    }

    private static int usingTabulation2(int[] len, int[] price, int rodLength) {
        int dp[][] = new int[len.length + 1][rodLength + 1];

        for (int i = 1; i < dp.length ; i++)
            for (int j = 1; j < dp[0].length; j++)
            dp[i][j] = (len[i - 1]<=j)? Math.max(price[i - 1]+dp[i][j-len[i - 1]],dp[i-1][j]) : dp[i-1][j] ;


        return dp[len.length][rodLength];



    }

    private static int usingTabulation(int[] len, int[] price, int rodLength) {

        int dp[][] = new int[len.length + 1][rodLength + 1];

        for (int i = 1; i < dp.length ; i++) {
            int cost = price[i - 1];
            int l = len[i - 1];
            for (int j = 1; j < dp[0].length; j++) {

                if (l<=j){
                    int include = cost + dp[i][j - l];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                }
                else dp[i][j] = dp[i-1][j];



            }

        }


        return dp[len.length][rodLength];





    }


    private static int usingRecursion(int[] len, int[] price, int rodLength, int i) {
        if (i==0 || rodLength ==0) return 0;


        if (rodLength >= len[i - 1]) {
            int include = price[i-1]+usingRecursion(len, price, rodLength-len[i - 1], i);
            int exclude = usingRecursion(len, price, rodLength, i-1);

            return Math.max(include, exclude);
        }

        else return  usingRecursion(len, price, rodLength, i-1);
    }


    private  static  int usingMemoization(int []len,int []price, int rodLength, int i,int[][]dp){
        if (i==0 || rodLength==0) return 0;
        if (dp[i][rodLength] != -1) return dp[i][rodLength];

        if (rodLength >= len[i - 1]) {

            int include = price[i - 1] + usingMemoization(len, price, rodLength - len[i - 1], i, dp);
            int exclude = usingMemoization(len, price, rodLength, i-1, dp);
         return    dp[i][rodLength] = Math.max(include,exclude);
        }
        else {
           return dp[i][rodLength] =   usingMemoization(len, price, rodLength, i-1, dp);
        }


    }


}
