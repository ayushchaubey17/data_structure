package greedyApproch;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int arr1[] = {4,1,8,7};
        int arr2[] = {2, 3, 6,5};

        minDiff(arr1, arr2);
    }

    private static void minDiff(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int diff = 0;
        for (int i=0;i<arr1.length;i++) diff+= Math.abs(arr1[i]-arr2[i]);

        System.out.println(diff);
    }
}
