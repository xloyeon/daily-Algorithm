package BOJ.BackTracking.n15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Integer> result = new ArrayList<>();

    public static void backTracking(int start, int k){
        //리스트가 모두 채워지면(길이가 m이 되면)
        if(k==m){
            for(int i : result){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i<=n; i++){
            if(!result.contains(i)){
                result.add(i);
                backTracking(i+1, k+1);
                result.remove(result.size()-1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        backTracking(1, 0);
    }
}
