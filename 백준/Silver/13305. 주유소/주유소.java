import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] distance = new long[n-1];
        long[] price = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0L;
        long min = price[0];

        for(int i =0; i<n-1; i++){
            if(price[i]<min){
                min = price[i];
            }

            result += min*distance[i];
        }
        System.out.println(result);
    }
}
