
import java.util.Arrays;
import java.util.Scanner;




class ActivitySelection {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] activities = new int[n][2];
        for (int i = 0; i < n; i++) {
            activities[i][0] = sc.nextInt(); // start
            activities[i][1] = sc.nextInt(); // finish
        }
        selectActivities(activities, n);
    }

    
    static void selectActivities(int[][] activities, int n) {
    // Sort based on finish time
    Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
    int cnt = 1; // First activity is always selected
    int prevFinish = activities[0][1];

    System.out.println("Selected activity: " + activities[0][0] + " to " + activities[0][1]);

    for (int i = 1; i < n; i++) {
        if (activities[i][0] >= prevFinish) {
            cnt++;
            System.out.println("Selected activity: " + activities[i][0] + " to " + activities[i][1]);
            prevFinish = activities[i][1];
        }
    }
    System.out.println("Maximum number of activities: " + cnt);
}
}

/*

1. Sort the activities based on their finish times.
2. Select the first activity from the sorted list and add it to the result set.
3. Remove all activities that overlap with the selected activity.
4. Repeat steps 2 and 3 until all activities are processed.
 */
