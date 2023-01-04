package n14467;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());

        int[][] cow = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            cow[i][0] = Integer.parseInt(st2.nextToken());
            cow[i][1] = Integer.parseInt(st2.nextToken());
        }

        int temp = 0;
        int count = 0;

        for (int i = 0; i < cow.length; i++) {
            temp = 0;

            if (cow[i][0] != 0) {
                temp = cow[i][1];

                for (int j = i + 1; j < cow.length; j++) {
                    if (cow[j][0] == cow[i][0]) {
                        if (cow[j][1] != temp)
                            count++;
                        temp = cow[j][1];
                        cow[j][0] = 0;
                    }
                }

            }
        }
        System.out.println(count);
    }
}