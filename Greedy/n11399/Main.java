package Greedy.n11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> times = new ArrayList<>();

        for(int i = 0; i<n; i++){
            times.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(times);

        for(int i = 1; i<n; i++){
            times.set(i, times.get(i-1) + times.get(i));
        }

        int result = 0;
        for(int time : times){
            result += time;
        }
        System.out.println(result);
    }
}
