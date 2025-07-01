import java.util.Arrays;
import java.util.Scanner;

class JobSequencing {

    static class Job {
        int id, deadline, profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            int id = i + 1;
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            jobs[i] = new Job(id, deadline, profit);
        }
        jobSequencing(jobs, n);
    }

    static void jobSequencing(Job[] jobs, int n) {
        // Sort jobs by descending profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find the maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Time slots for jobs
        int[] slots = new int[maxDeadline + 1]; // 1-based indexing
        Arrays.fill(slots, -1);

        int totalProfit = 0, count = 0;
        for (Job job : jobs) {
            // Find a free slot for this job (starting from its deadline)
            for (int j = job.deadline; j > 0; j--) {
                if (slots[j] == -1) {
                    slots[j] = job.id;
                    totalProfit += job.profit;
                    count++;
                    System.out.println("Scheduled job " + job.id + " with profit " + job.profit + " at time slot " + j);
                    break;
                }
            }
        }
        System.out.println("Maximum number of jobs: " + count);
        System.out.println("Total profit: " + totalProfit);
    }
}