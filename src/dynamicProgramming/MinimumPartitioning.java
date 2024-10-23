package dynamicProgramming;

public class MinimumPartitioning {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 11, 5, 6};
        int sum =0;
        int n = arr.length;
        for (int el: arr) sum += el;
        int s1 = usingTabulation(arr);
        int s2 = sum - s1;
        System.out.println(Math.abs(s1-s2));
    }

    private static int usingTabulation(int[] arr) {
        int sum =0;
        int n = arr.length;
        for (int el: arr) sum += el;
        int dp[][] = new int[n + 1][sum / 2+1];

        for (int i = 1; i < dp.length; i++) {
            int el = arr[i - 1];
            for (int j = 1; j < dp[0].length; j++) {
                if (el<=j){
                    dp[i][j] = Math.max(el + dp[i - 1][j - el], dp[i - 1][j]);

                } else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[arr.length][sum/2];
    }
}
