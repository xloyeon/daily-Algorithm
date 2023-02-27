package BOJ.DP.n11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] permutation;
    static int[] result;

    public static void dp(){
        //i번째 자리 숫자를 포함하는 가장 긴 증가하는 부분 수열의 길이 탐색
        for(int i = 0; i<n; i++){
            result[i] = 1;  //부분 수열의 길이는 최소 1

            //i번째 이전 숫자 중 i번째 수보다 작고 최장 부분 수열의 길이를 찾음
            for(int j = 0; j<i; j++){
                if(permutation[j]<permutation[i])
                    result[i] = Math.max(result[i], result[j] + 1);
            }
        }

        //가장 긴 길이를 가진 부분 수열을 찾아 출력
        printMax();
    }

    public static void printMax(){
        int max = 1;
        for(int i : result){
            max = Math.max(max, i);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        permutation = new int[n];
        result = new int[n];

        for(int i = 0; i<n; i++)
            permutation[i] = Integer.parseInt(st.nextToken());

        dp();
    }
}
