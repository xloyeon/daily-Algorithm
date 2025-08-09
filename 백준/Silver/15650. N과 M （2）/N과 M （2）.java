import java.util.*;
import java.io.*;


public class Main {
    public static int N = 0;
    public static int M = 0;
    public static int[] nums;
    public static void pickNums(int idx, int last, StringBuilder stringBuilder){
        if(idx == M+1){
            System.out.println(stringBuilder.toString());
            return;
        }

        // 이전에 뽑은 수가 가장 큰 수일 때
        if(last +1 > N)
            return;

        //이전에 뽑은 수부터 N 사이에 남은 수가 부족할 때
        if(N-last<M-idx+1)
            return;

        for(int i = last+1; i<=N; i++){
            if(nums[i] != 0)
                continue;

            nums[i] = idx;
            stringBuilder.append(i + " ");
            pickNums(idx+1, i, stringBuilder);
            stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
            nums[i] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1];

        pickNums(1, 0, new StringBuilder());

    }
}