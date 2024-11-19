package dynamicProgramming;

public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {5,6,2, 3};
        int sum = 10;

      int ans =  usingRecursion(coins, sum, coins.length);
        System.out.println(ans);
    }

    private static int usingRecursion(int[] coins, int sum, int length) {
        if (length==0)return sum==0?1:0;

        if (sum==0)return 1;
        if (sum<0 ) return 0;
        //valid

            int inc = usingRecursion(coins, sum - coins[length - 1], length);
            int exc = usingRecursion(coins, sum , length-1);
            return (inc+ exc);


        //invalid
    }
}
