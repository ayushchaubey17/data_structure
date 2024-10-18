package dynamicProgramming;

public class WildCartmatching {
    public static void main(String[] args) {
        String string = "baaaabab";
        String pattern = "***ba***?b";

        boolean p = usingTabulation(string, pattern);
        System.out.println(p);


    }

    private static boolean usingTabulation(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
//        for (int i=1;i<=s.length();i++)dp[i][0] = false;
        for (int i=1;i<=p.length();i++) if (p.charAt(i-1)=='*') dp[0][i] = dp[0][i - 1];


        for (int i = 1; i < dp.length; i++) {  //s.length() = dp.length
            char a= s.charAt(i-1);
            for (int j = 1; j < dp[0].length; j++) {    //p.length() = dp[0].length
                char b = p.charAt(j - 1);
                if (a==b || b=='?') dp[i][j] = dp[i - 1][j - 1];
                else if(b=='*') dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else dp[i][j] = false;

            }
        }

        print(dp);
        return dp[s.length()][p.length()];
    }

    private static void print(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }
}

