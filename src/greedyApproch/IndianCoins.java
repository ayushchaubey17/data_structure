package greedyApproch;

public class IndianCoins {
    public static void main(String[] args) {
        int arrr[] = new int[]{1, 2, 5, 10, 20, 50, 100, 500};
        int v = 590;
        numberOfCurrency(arrr, v);
    }

    private static void numberOfCurrency(int[] arrr, int v) {


        int j= arrr.length-1;
        int currency = 0;

        while (v>0){
            if (v >= arrr[j]) {
                v-=arrr[j];
                currency++;
            }
            else j--;

        }
        System.out.println(currency);
    }
}
