package BOJ.n11866;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        StringBuffer sb1 = new StringBuffer();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int index = 0;
        StringBuffer sb = new StringBuffer();
        sb.append("<");

        while (!q.isEmpty()) {
            index++;
            if (index == k) {
                sb.append(q.poll() + ", ");
                index = 0;
            } else {
                q.offer(q.poll());
            }
        }
        String s = sb.substring(0, sb.length() - 2);
        s += ">";

        System.out.println(s);
    }
}