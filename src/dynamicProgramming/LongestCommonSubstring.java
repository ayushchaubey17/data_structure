package dynamicProgramming;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1= "ABCDE";
        String s2 = "ABGCE";

        System.out.println(usingTabulation(s1,s2));
    }

    private static int usingTabulation(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        int ans =0;
        // 1st row and 1st col =0
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else dp[i][j]=0;
            }
        }
        return ans;

    }


}
