package BOJ.DP.n11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] cards;
    static int[] price;

    public static void Dp(int n){

        for(int i = 1; i<=n; i++){
           for(int j = 1; j<=i; j++){
               price[i] = Math.max(price[i], cards[j] + price[i-j]);
           }
        }
        System.out.println(price[n]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        cards = new int[n+1];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        price = new int[n+1];
        Dp(n);
    }
}
