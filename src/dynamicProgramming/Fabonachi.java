package dynamicProgramming;

import java.util.Arrays;

public class Fabonachi {
    public static void main(String[] args) {
        int n = 100;

//        long t1 = System.currentTimeMillis();
//     int x =    fabonachiWithoutDP(n);
//
//        long t2 = System.currentTimeMillis();
//        System.out.println(t2-t1);




        //with dynamic conccept
//        int dp[] = new int[n + 1];
//        Arrays.fill(dp,-1);
//
//        long t1 = System.currentTimeMillis();
//        int x =    fabonachiWithDP(n,dp);
//
//        long t2 = System.currentTimeMillis();
//        System.out.println(t2-t1);

//       int y = fabonachiWithDP(n, dp);
//        System.out.println(y);


        System.out.println(iteration(20));
    }

    private static int fabonachiUsingTabulation(int n) {
        int dp[] = new int[n + 1];

        dp[1]=1;

        for (int i = 2; i <= n; i++) {
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];

    }

    private static int fabonachiWithDP(int n, int[] dp) {
        if (n==0 || n==1){
            dp[n]= n;
            return dp[n];
        }

        if (dp[n] !=-1) return dp[n];

        dp[n] = fabonachiWithDP(n - 1, dp) + fabonachiWithDP(n - 2, dp);
        return dp[n];
    }

    private static int fabonachiWithoutDP(int n) {
        if (n == 0 || n == 1) return n;
        return fabonachiWithoutDP(n - 1) + fabonachiWithoutDP(n - 2);
    }


    private static int iteration(int n) {
        if (n==0 || n==1) return n;
        int first = 0;
        int second = 1;
        int ans =0;

        for (int i=2;i<=n;i++){
            ans = second+first;
            first = second;
            second = ans;
        }
        return  ans;





    }
}
