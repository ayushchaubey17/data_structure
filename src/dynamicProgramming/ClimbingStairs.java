package dynamicProgramming;

public class ClimbingStairs

{
    public static void main(String[] args) {
        int n = 4;
     int ans =    usingRecursion(n);
        System.out.println(ans);


        int dp[] = new int[n+1];
       int ans1 = usingMemoization(n, dp);
        System.out.println(ans1);
    }

    private static int usingMemoization(int n, int[] dp) {
        if (n==0 || n==1){
            dp[n] = 1;
            return dp[n];
        }

        if (dp[n] != 0) return dp[n];

        dp[n] = usingMemoization(n - 1, dp) + usingMemoization(n - 2, dp);

        return dp[n];
    }

    private static int usingRecursion(int n) {
        if (n==0 || n==1) return 1;
        return usingRecursion(n - 1) + usingRecursion(n - 2);
    }
}
