/*
Time & Space Complexity

--> Sorting jobs by profit	O(n log n)
--> Scheduling jobs (Greedy)	O(n × d) (where d is the max deadline)
--> Total Complexity	O(n log n + n × d)

Space Complexity: O(d) for the slot array.
 */


import java.util.*;

public class JobSequencing {
    int[][] jobs; // Array to store job details [ID, Deadline, Profit]
    int n; // Number of jobs


    JobSequencing(int n) {
        this.n = n;
        jobs = new int[n][3]; // Each job has ID, Deadline, and Profit
    }

 
    void addJob(int index, int id, int deadline, int profit) {
        jobs[index][0] = id;
        jobs[index][1] = deadline;
        jobs[index][2] = profit;
    }

 
    void getMaxProfit() {
        // Step 1: Sort jobs by profit in descending order
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[2], a[2]));

        // Step 2: Find the maximum deadline to determine the number of slots
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);
        }

        // Step 3: Create an array to track scheduled jobs
        int[] slot = new int[maxDeadline + 1]; // Slot array (0-based)
        Arrays.fill(slot, -1); // -1 indicates an empty slot

        int totalProfit = 0;
        List<Integer> selectedJobs = new ArrayList<>();

        // Step 4: Iterate over each job
        for (int i = 0; i < n; i++) {
            int id = jobs[i][0];
            int deadline = jobs[i][1];
            int profit = jobs[i][2];

            // Step 5: Find an available slot from deadline to start
            for (int j = deadline; j > 0; j--) {
                if (slot[j] == -1) {   // If the slot is free
                    slot[j] = id;       // Assign job to this slot
                    selectedJobs.add(id);
                    totalProfit += profit;
                    break;
                }
            }
        }

        // Step 6: Print the scheduled jobs and maximum profit
        System.out.println("Scheduled Jobs: " + selectedJobs);
        System.out.println("Maximum Profit: " + totalProfit);
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        JobSequencing scheduler = new JobSequencing(n);

        
        System.out.println("Enter Job ID, Deadline, and Profit:");
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            scheduler.addJob(i, id, deadline, profit);
        }

        scheduler.getMaxProfit();

        sc.close();
    }
}

