import java.util.Scanner;

public class InversionCount {

    static int merge(int[] arr, int s, int m, int e) {
        int an = m - s + 1;
        int bn = e - m;

        int[] a = new int[an];
        int[] b = new int[bn];

        for (int i = 0; i < an; i++) {
            a[i] = arr[s + i];
        }

        for (int j = 0; j < bn; j++) {
            b[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = s;
        int cnt = 0;

        while (i < an && j < bn) {
            if (a[i] <= b[j]) {
                arr[k++] = a[i++];
            } else {
                arr[k++] = b[j++];
                cnt += (an - i); // Count inversions
            }
        }

        while (i < an) arr[k++] = a[i++];
        while (j < bn) arr[k++] = b[j++];

        return cnt;
    }

    static int mergeSort(int[] arr, int start, int end) {
        if (start >= end) return 0;

        int mid = start + (end - start) / 2;
        int count = 0;

        count += mergeSort(arr, start, mid);
        count += mergeSort(arr, mid + 1, end);
        count += merge(arr, start, mid, end);

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        int count = mergeSort(arr, 0, n - 1);
        System.out.println(count);
    }
}
