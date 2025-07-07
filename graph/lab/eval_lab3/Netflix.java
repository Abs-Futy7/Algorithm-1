import java.util.*;

public class Netflix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] activities = new int[n][2];  //2d array nilam save korar jonno str r end

        for (int i = 0; i < n; i++) {

            String day1 = scanner.next();

            int startTime = scanner.nextInt();

            String day2 = scanner.next();

            int endTime = scanner.nextInt();

            int start = -1;
            int end = -1;

            if (day1.equals("fri")) {
                start = 0 + startTime; 
            }else if (day1.equals("sat")) {
                start = 1 * 100 + startTime;  // choto theke boro sajaisi as mile na
             }else if (day1.equals("sun")) {
                start = 2 * 200 + startTime;  // pure my method - gpt te paba na(3 ta test case mile :/)
             }else if (day1.equals("mon")) {
                start = 3 * 300 + startTime;  // 1st e 1 then 10 then 100 hoy na
             }// subgulay e 100 diya jog
            else if (day1.equals("tue")) {
                start = 4 * 400 + startTime;  // start r endtime jog korar por ans milse
             }else if (day1.equals("wed")) {
                start = 5 * 500 + startTime; 
            }else {
                start = 6 * 600 + startTime;
            }

            if (day2.equals("fri")) {
                end = 0 + endTime; 
            }else if (day2.equals("sat")) {
                end = 1 * 100 + endTime; 
            }else if (day2.equals("sun")) {
                end = 2 * 200 + endTime; 
            }else if (day2.equals("mon")) {
                end = 3 * 300 + endTime; 
            }else if (day2.equals("tue")) {
                end = 4 * 400 + endTime; 
            }else if (day2.equals("wed")) {
                end = 5 * 500 + endTime; 
            }else {
                end = 6 * 600 + endTime;
            }

            activities[i][0] = start;

            activities[i][1] = end;

        }

        // Sort korlam by end time
        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;  // -2  diye try korsilam lmao

        int lastEnd = -1;

        for (int i = 0; i < n; i++) {

            if (activities[i][0] >= lastEnd) {

                count++;

                lastEnd = activities[i][1];

            }

        }

        System.out.println(count);

    }

}
