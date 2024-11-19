package heaps;

import java.util.PriorityQueue;

class K_Weakest_Soldier {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Soldier> pq = new PriorityQueue<>();
    
        for(int i=0;i<mat.length;i++){
            int count =0;
            for(int j=0;j<mat[0].length;j++){
                count+= (mat[i][j]==1)?1:0;
            }
            pq.add(new Soldier(count,i));

        }
        int ans[] = new int[k];
        int i=0;
        for(int j=0;j<k;j++)ans[i++] = pq.poll().idx;

        return ans;
    }

    static class Soldier implements Comparable<Soldier>{
        private int count,idx;

     public   Soldier(int count,int idx){
            this.count = count;
            this.idx  = idx;
        }

        public int compareTo(Soldier s2){
            return (this.count== s2.count)?(this.idx-s2.idx):this.count-s2.count;
        }


    }


}