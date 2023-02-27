package BOJ.n2503;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 123; i < 988; i++) {
            int countS = 0;
            int countB = 0;
            boolean isResult = true;

            String s = String.valueOf(i);
            int a = s.charAt(0) - '0';
            int b = s.charAt(1) - '0';
            int c = s.charAt(2) - '0';

            if (a == b || b == c || a == c || (a == 0 || b == 0 || c == 0)) continue;

            for (int j = 0; j < arr.length; j++) {
                countS = 0;
                countB = 0;
                isResult = true;

                String ss = String.valueOf(arr[j][0]);
                int aa = ss.charAt(0) - '0';
                int bb = ss.charAt(1) - '0';
                int cc = ss.charAt(2) - '0';

                if (a == aa) countS++;
                if (b == bb) countS++;
                if (c == cc) countS++;
                if (a == bb || a == cc) countB++;
                if (b == aa || b == cc) countB++;
                if (c == aa || c == bb) countB++;
                if (arr[j][1] != countS || arr[j][2] != countB) {
                    isResult = false;
                    break;
                }
            }
            if (isResult) result++;
        }
        System.out.println(result);
    }
}