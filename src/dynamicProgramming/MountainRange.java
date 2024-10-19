package dynamicProgramming;

public class MountainRange {
    public static void main(String[] args) {
        int pairs = 3;
      int ans =  usingTabu(pairs);
        System.out.println(ans);
    }

    private static int usingTabu(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;


        for (int i = 2; i <= n; i++) {
            int j=0;
            while (j < i) {
                int inside = dp[j];
                int outside = dp[i - 1 - j];
                dp[i] += inside * outside;
                j++;
            }

        }
        return dp[n];
    }
}
