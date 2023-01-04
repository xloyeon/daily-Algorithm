package n9012;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            int countA = 0, countB = 0;
            char[] arr = s.toCharArray();

            for (char c : arr) {
                if (c == '(') {
                    countA += 1;
                } else {
                    countB += 1;
                }

                if (countA < countB)
                    break;
            }

            if (countA == countB)
                sb.append("YES\n");
            else
                sb.append("NO\n");

        }
        System.out.println(sb);
    }
}