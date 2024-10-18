package dynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;

public class LongestIncreasingSubsequence {


    public static void main(String[] args) {
        int arr1[] = {50, 3, 10, 7, 40, 80};
        //if repetation will be there then use hashset and all element of hashset in arr2

//        int arr2[]= arr1.clone();
//        Arrays.sort(arr1);
        //if repetation will be there then use hashset and all element of hashset in arr2

        HashSet<Integer> hashSet = new HashSet<>();
        for (int el:arr1) hashSet.add(el);

        int arr2[] = new int[hashSet.size()];
        int i=0;
        for (int el:hashSet)arr2[i++] =el;

        int n = usingTabulation(arr1, arr2);
        System.out.println(n);

        System.out.println(usingRecursion(arr1,arr2,arr1.length,arr2.length));



        //usingMemo
        int dp[][] = new int[arr1.length+1][arr2.length+1];
        for(var arr: dp) Arrays.fill(arr, -1);

        System.out.println(usingMemoization(arr1,arr2,arr1.length,arr2.length,dp));
    }

    private static int usingMemoization(int[] arr1, int[] arr2, int l1, int l2, int[][] dp) {
        if (l1==0 || l2==0) return 0;

        if (dp[l1][l2]!= -1) return  dp[l1][l2];

        if (arr1[l1-1]== arr2[l2-1]) {
          return   dp[l1][l2] = 1 + usingMemoization(arr1, arr2, l1-1, l2-1, dp);

        }
        else {
            return dp[l1][l2] = Math.max(usingMemoization(arr1, arr2, l1-1, l2, dp),usingMemoization(arr1, arr2, l1, l2-1, dp));
        }
    }

    private static int usingRecursion(int[] arr1, int[] arr2, int l1, int l2) {
        if (l1==0 || l2==0) return 0;
        if (arr1[l1-1]==arr2[l2-1]) return 1 + usingRecursion(arr1, arr2, l1 - 1, l2 - 1);
        else {
         return    Math.max(usingRecursion(arr1, arr2, l1-1, l2),usingRecursion(arr1, arr2, l1, l2-1));
        }
    }

    private static int usingTabulation(int[] arr1, int[] arr2) {
        int dp[][] = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 1; i < dp.length; i++) {
            int el = arr1[i-1];
            for (int j = 1; j < dp[0].length; j++) {
                if (arr2[j-1]==el){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[arr1.length][arr2.length];



    }


}
