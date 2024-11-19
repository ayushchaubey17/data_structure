package dynamicProgramming;

import java.util.Arrays;

public class BionomialCoefficient {
    public static void main(String[] args) {
        int n = 15;
        int c = 15;
        find(n, c);
    }

    private static void find(int n, int k) {
        int dp[][] = new int[n+1][k+1];
        

        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <= Math.min(i,k); j++) {
                if ( j==0 || i==j )dp[i][j]=1;
                else dp[i][j]= dp[i-1][j-1]+dp[i-1][j];
            }
        }


        for (int[] arr:dp)
        System.out.println(Arrays.toString(arr));
    }
}
