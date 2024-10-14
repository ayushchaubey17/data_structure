package queue;

public class JobSeequencingProblem {
    
    public static void main(String[] args) {
        char[] name = new char[]{'A','B','C','D'};
        int[] deadline = new int[]{4,1,1,1};
        int[] profit = new int[]{20,10,40,30};

        performJob(name,deadline,profit);
    }

    private static void performJob(char[] name, int[] deadline, int[] profit) {

    }

    static class Jobs {
        private  char jobname;
        private  int deadline;
        private int profit;

        public Jobs(char jobname, int deadline, int profit) {
            this.jobname = jobname;
            this.deadline = deadline;
            this.profit = profit;

        }
    }

}
