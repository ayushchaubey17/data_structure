package greedyApproch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobSequencingProblem {
    public static void main(String[] args) {
        int jobInfo[][] = new int[][]{{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        findMaximumJobs(jobInfo);


    }

    private static void findMaximumJobs(int[][] jobInfo) {
        Jobs jobs[] = new Jobs[jobInfo.length];

        for (int i = 0; i < jobs.length; i++)  jobs[i] = new Jobs(i, jobInfo[i][0], jobInfo[i][1]);

        Arrays.sort(jobs, Comparator.comparingInt(o-> -o.profit));

        for (int i = 0; i < jobs.length; i++) {
            System.out.println(jobs[i]);
        }


int time =0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            Jobs current = jobs[i];
            if (current.deadline>time){
                list.add(current.id);
                time++;
            }

        }

        System.out.println(list);

    }

    private static class Jobs {
        private  int id;
        private  int deadline;
        private  int profit;

        public Jobs(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        public String toString() {
            return this.id+" "+this.deadline+" "+this.profit;
        }

    }

}
