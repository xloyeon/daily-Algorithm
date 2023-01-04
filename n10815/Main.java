package n10815;

import java.io.*;
import java.util.*;

public class Main {
    public static int binarySearch(int[] arr, int n, int num) {
        int start = 0;
        int end = n - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] == num) return 1;

            if (arr[mid] < num) start = mid + 1;
            else end = mid - 1;

        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st2.nextToken());
            sb.append(binarySearch(arr, n, num) + " ");
        }

        System.out.print(sb);

    }
}