package segmenttree;

public class MaximumElementInARange {

    private static  int tree[];

    public static void main(String[] args) {
        int arr[] = {1, 12, 3, 42, 5, 16,  8, 9};
        int n = arr.length;
        build(n);
        buildMax(arr, 0, 0, arr.length - 1);
        printST();

       int ans = maxInRange(arr, 2, 3);

        System.out.println();
        System.out.println(ans);


        update(arr, 2, 80);
    }

    private static void update(int[] arr, int ind, int value) {
        update(0,0,arr.length-1,ind,value);
    }

    private static void update(int i, int si, int sj, int ind, int value) {
        if (ind <si || ind>sj) return;
        tree[i] = Math.max(tree[i], value);
        if (si != sj) {
            int mid = (si+sj)/2;
            update(2*i+1, si, mid, ind, value);
            update(2*i+1, mid+1, sj, ind, value);
        }

    }

    private static int maxInRange(int[] arr, int qi, int qj) {

        return maxInRange(0,0,arr.length-1, qi, qj);
    }

    private static int maxInRange(int i, int si , int sj, int qi, int qj) {
        //not include
        if(qj<si || qi>sj) return Integer.MIN_VALUE;

        else if (si >= qi && sj <= qj) {
            return tree[i];
        }


        else {
            int mid= (si+sj)/2;
            int left = maxInRange(2*i+1, si, mid, qi, qj);
            int right = maxInRange(2*i+2, mid+1, sj, qi, qj);
            return Math.max(left, right);
        }

    }

    private static void build(int n) {
        tree = new int[2 * n-1];
    }


    private static int buildMax(int arr[], int i, int start, int end) {
        if (start==end){
            tree[i] = arr[start];
            return tree[i];
        }
        int mid = (start + end) / 2;
        buildMax(arr, 2 * i + 1, start, mid);
        buildMax(arr, 2 * i + 2, mid + 1, end);
        return tree[i] = Math.max(tree[2*i+1],tree[2*i+2] );
    }


    public static void printST() {
        for (int el:tree) System.out.print(el+" ");
    }



}
