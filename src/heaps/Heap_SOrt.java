package heaps;

import java.util.Arrays;

public class Heap_SOrt {
    static   int arr[] = new int[]{3, 5, 2, 1, 6, 2, 5, 2, 4, 9, 7};
    public static void main(String[] args) {


        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2; i >= 0; i--) heapify(i, n);

        for (int i = n-1; i >0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i]= temp;

            heapify(0,i);
        }


    }

    private static void heapify(int i, int n) {
        int maxIdx = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if (left<n && arr[left]>arr[maxIdx])maxIdx = left;
        if (right<n && arr[right]>arr[maxIdx])maxIdx = right;

        if (maxIdx != i){

            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;

            heapify(maxIdx,n);
        }
    }
}
