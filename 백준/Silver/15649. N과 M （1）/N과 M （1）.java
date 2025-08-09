import java.util.*;
import java.io.*;


public class Main {
    public static int N = 0;
    public static int M = 0;
    public static int[] nums;
    public static void pickNums(int idx, StringBuilder stringBuilder){
        if(idx == M+1){
            System.out.println(stringBuilder.toString());
            return;
        }

        for(int i = 1; i<=N; i++){
            if(nums[i] != 0)
                continue;

            nums[i] = idx;
            stringBuilder.append(i + " ");
            pickNums(idx+1, stringBuilder);
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

        pickNums(1, new StringBuilder());

    }
}