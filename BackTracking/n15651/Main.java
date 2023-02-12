package BackTracking.n15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void backTracking(int k){
        //최종 깊이에 도달하면 멈춤
        if(k == m){
            //일반적인 입출력 사용시 시간초과(StringBuilder 또는 BufferedWriter 사용할 것)
            for(int i : result){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        //다른 가지로 이동
        for(int i = 1; i<=n; i++){
            result[k] = i;
            backTracking(k+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];
        backTracking(0);
        System.out.println(sb);
    }
}
