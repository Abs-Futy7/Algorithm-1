import java.util.*;

class ActivitySelection {
    int N;
    int[] start;
    int[] finish;

    // Constructor
    public ActivitySelection(int N, int[] start, int[] finish) {
        this.N = N;
        this.start = start;
        this.finish = finish;
    }

    // Method to perform activity selection using greedy algorithm
    public ArrayList<Integer> maxMeetings() {
        ArrayList<Integer> ans = new ArrayList<>();
        int[][] a = new int[N][3];

        for (int i = 0; i < N; i++) {
            a[i][0] = i + 1; // Meeting number
            a[i][1] = start[i];  // Start time
            a[i][2] = finish[i]; // Finish time
        }

        Arrays.sort(a, Comparator.comparingInt(o -> o[2]));

        int r = a[0][2]; // Finish time of the first meeting
        ans.add(a[0][0]);

        for (int i = 1; i < a.length; i++) {
            if (a[i][1] > r) {
                ans.add(a[i][0]);
                r = a[i][2];
            }
        }

        Collections.sort(ans); // Optional: return sorted meeting indices
        return ans;
    }

    // Main method to test the class
    public static void main(String[] args) {
        int[] start = {1, 3, 0 , 5, 3, 5, 6, 8 , 8, 2, 12};
        int[] finish = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int N = start.length;

        ActivitySelection selector = new ActivitySelection(N, start, finish);
        ArrayList<Integer> selectedMeetings = selector.maxMeetings();

        System.out.println("Selected meetings: " + selectedMeetings);
    }
}

/*

1. Sort the activities based on their finish times.
2. Select the first activity from the sorted list and add it to the result set.
3. Remove all activities that overlap with the selected activity.
4. Repeat steps 2 and 3 until all activities are processed.
 */
