package BOJ.DP.n11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] result = new long[n];

        //index는 n의 수
        //index = 1이면 1
        //index = 2이면 2(1+1)
        //index = 3이면 3(1+2)
        //index = 4이면 5(1+3+1)
        //index = 5이면 8(1+4+3)
        //index = 6이면 13(1+5+6+1)

        for(int i = 0; i<n; i++){
            if(i==0) result[i] = 1;
            else if(i==1) result[i] = 2;
            else{
               result[i] = (result[i-2] + result[i-1])%10007;
            }
        }
        System.out.println(result[n-1]);
        //20일때 939
    }
}
