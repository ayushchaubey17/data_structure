package segmenttree;

public class Creation {
    private static int tree[];

    public static void build(int n) {
        tree = new int[n * 4];
    }


    public static int buildSegmentTree(int arr[], int i, int start, int end) {
        if (start == end) {
            return  tree[i] = arr[start];
        }



        int mid = (start+end)/2;
      int l =   buildSegmentTree(arr, 2*i+1, start, mid);
     int r = buildSegmentTree(arr, 2*i+2, mid+1, end);
     return tree[i]=(l+r);

    }

    public static void main(String[] args) {

        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;

        build(n);
        buildSegmentTree(arr, 0, 0, n - 1);
        printST();


        int ans = getSum(arr, 2, 5);
        System.out.println("\n"+ans);
        change(arr,2, 2);

        printST();
    }

    private static void change(int[] arr, int i, int newValue) {

        int diff = newValue - arr[i];
        arr[i] = newValue;
        update(0, 0, arr.length - 1, i, diff);
    }

    private static void update(int i, int si, int sj, int ind, int diff) {
        if (ind <si || ind>sj) return;
        tree[i]+=diff;
        if (si != sj) {
            int mid = (si+sj)/2;
            update(2*i+1, si, mid, ind, diff);
            update(2*i+2, mid+1, sj, ind, diff);
        }

    }

    private static int getSum(int ar[] ,int qi, int qj) {
        return getSum(0,0, ar.length -1, qi, qj);
    }

    private static int getSum(int i, int si, int sj,  int qi, int qj) {
        //zero overlap
        if (qj<=si || qi>=sj) return 0;

        //complete overlap
        else if (si>=qi && sj<=qj ) return tree[i];

        else {
            int mid = (si + sj) / 2;
            int left = getSum(2 * i + 1, si, mid, qi, qj);
            int right = getSum(2 * i + 2, mid+1, sj, qi, qj);

            return left+right;
        }
    }

    public static void printST() {
        for (int el:tree) System.out.print(el+" ");
    }
}
