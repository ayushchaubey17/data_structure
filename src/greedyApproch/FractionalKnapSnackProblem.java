package greedyApproch;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSnackProblem {
    public static void main(String[] args) {
        int item[] = {10,20,30};
        int profit[] = {60,100, 120};

        int mWeight = 50;

        System.out.println(solution(item,profit,mWeight));
    }

    private static double solution(int[] item, int[] profit, int mWeight) {
        Knapsack[] arr = new Knapsack[item.length];
        for (int i = 0; i < item.length; i++) {
            arr[i] = new Knapsack(item[i], profit[i]);
        }


        Arrays.sort(arr, Comparator.comparingDouble(el->-el.ratio));


        for (Knapsack el:arr) System.out.println(el);

double profits =0;
        for (int i = 0; i < arr.length; i++) {
            if (mWeight>=arr[i].item){
               profits+=arr[i].profit;
               mWeight-=arr[i].item;
            }
            else{
                profits+= (arr[i].ratio)*mWeight;
                break;
            }
        }

        return profits;
    }

    static class Knapsack {
        private double ratio;
        private int item;
        private  int profit;

        public Knapsack( int item, int profit) {
            this.ratio = (double) profit/(double) item;
            this.item = item;

            this.profit = profit;
        }


        public String toString() {
            return this.ratio+","+this.profit+","+this.item;
        }
    }

}
