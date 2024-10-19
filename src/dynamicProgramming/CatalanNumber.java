package dynamicProgramming;

import java.util.Arrays;

public class CatalanNumber {
    public static void main(String[] args) {

        int n=150;
        long l1 = System.currentTimeMillis();
//        usingArray(n);
        System.out.println(System.currentTimeMillis()-l1);
//
        int ans = usingRecursion(4);
        System.out.println(ans);




        int n2 =4;

        int dp[] = new int[n2 + 1];
        System.out.println(usingMemo(n2,dp));
    }


    private static int usingMemo(int n, int[] dp) {
        if (n==0 || n==1 ) return 1;
        
        if (dp[n]!= 0) return dp[n];

        for (int i = 0; i < n; i++) {
            dp[n] +=( usingMemo(i, dp) * usingMemo(n - 1 - i, dp));
        }
        return dp[n];

    }

    private static int usingRecursion(int n) {


        if (n==0 || n==1) return 1;
        int ans =0;

        for (int i = 0; i <= n - 1; i++) {
            ans += usingRecursion(i) * usingRecursion(n - i - 1);
        }
        return ans;
    }

    private static void usingArray(int n) {
        int arr[] = new int[n ];
        arr[0] = arr[1]=1;
        int sum =0;

        for (int i=2;i<n;i++)
            for (int j = 0; j < i; j++)
                arr[i] += arr[j] * arr[i - j - 1];


        System.out.println(Arrays.toString(arr));
    }




}
