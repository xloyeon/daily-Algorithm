package BOJ.DP.n1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] counts;

    public static void Dp(int n){
       for(int i = 1; i<=n; i++){
           if(i==1) {
               counts[i] = 0;
           }else{
               int temp = counts[i-1] + 1;
               if(i%3==0) temp = Math.min(temp, counts[i/3]+1);
               if(i%2 ==0) temp = Math.min(temp, counts[i/2] + 1);

               counts[i] = temp;
           }
       }
       System.out.println(counts[n]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        counts = new int[n+1];
        Dp(n);
    }
}
