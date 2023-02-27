package BOJ.n1427;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        int[] arr = new int[n.length()];

        for (int i = 0; i < n.length(); i++) {
            int a = n.charAt(i) - '0';
            arr[i] = a;
        }

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}