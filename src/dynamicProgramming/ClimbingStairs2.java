package dynamicProgramming;

public class ClimbingStairs2 {
    public static void main(String[] args) {
        int n  = 5;
       int ans =  usingRecursion(n);

        int ways[] = new int[n + 1];
       int ans2 =  usingMemoization(n, ways);
        System.out.println(ans);
        System.out.println(ans2);
        System.out.println(usingTabulation(5));
    }

    private static int usingRecursion(int n) {
        if (n==0) return 1;
       if (n<3)return n;
       return usingRecursion(n-1)+usingRecursion(n-2)+usingRecursion(n-3);
    }


    private static int usingMemoization(int n,int []ways) {
        if (n==0) ways[n] =1;

       else if (n<3) ways[n] = n;


        if (ways[n]!=0) return ways[n];

        ways[n] = usingMemoization(n - 1, ways) + usingMemoization(n - 2, ways) + usingMemoization(n - 3, ways);
        return ways[n];
    }


    private static int usingTabulation(int n) {
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }



        return dp[n];

    }
}
