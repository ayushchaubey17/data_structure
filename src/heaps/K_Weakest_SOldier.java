package heaps;

import java.util.Arrays;

public class K_Weakest_SOldier {
    public static void main(String[] args) {
        int mat[][] = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        int k = 2;

        int rank[][] = new int[mat.length][2];
        for (int i = 0; i < mat.length ; i++) {
            rank[i] = new int[]{i,getCount(mat[i])};
        }

        Arrays.sort(rank,(a,b)->a[1]-b[1]==0?a[0]-b[0]:a[1]-b[1]);

        for (int i=0;i<k;i++){
            System.out.println(rank[i][0]);
        }
    }

    public static int getCount(int[] arr) {
        int count =0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]==1)count++;

        }

        return count;
    }
}
