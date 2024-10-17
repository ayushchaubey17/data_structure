package dynamicProgramming;

public class KnapSack_Zero_One {
    public static void main(String[] args) {
        int value[] = {12, 10, 20, 15};
        int weight[] = {2, 1, 3, 2};
        int capicity = 5;

        System.out.println(usingRecursion(value, weight, capicity, value.length));

        int[][] dp = new int[value.length + 1][capicity + 1];
        System.out.println(usingMemoization(value, weight, capicity, value.length,dp));


        System.out.println(usingTabulation(value, weight, capicity));
    }

    private static int usingTabulation(int[] value, int[] weight, int capicity) {
        int dp[][] = new int[value.length + 1][capicity + 1];


        for (int i = 1; i < dp.length; i++) {
            int profit = value[i - 1];
            int itemWeight = weight[i - 1];
            for (int j = 1; j <= capicity; j++) {

                if (itemWeight <= j) {
                    int include = profit + dp[i - 1][j- itemWeight];

                    int exclude  = dp[i-1][j];

                    dp[i][j] = Math.max(include, exclude);

                }
                else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[value.length][capicity];
    }

    private static int usingMemoization(int[] value, int[] weight, int capicity, int i, int[][] dp) {

        if (i==0 || capicity==0) return 0;


        if (capicity>= weight[i-1]){
            int include = value[i-1]+ usingMemoization(value, weight, capicity-weight[i-1], i-1, dp);
            int exclude = usingMemoization(value, weight, capicity, i-1, dp);

            dp[i][capicity] = Math.max(include, exclude);
        }
        else {

            dp[i][capicity] =usingMemoization(value, weight, capicity, i-1, dp);
        }
        return dp[i][capicity];


    }

    private static int usingRecursion(int[] value, int[] weight, int capicity, int i) {
        if (i==0 || capicity==0) return 0;
         return (weight[i-1]<=capicity)? Math.max(value[i-1]+usingRecursion(value, weight, capicity-weight[i-1], i-1),
                 usingRecursion(value, weight, capicity, i-1) ):
                 usingRecursion(value, weight, capicity, i-1);
    }
}