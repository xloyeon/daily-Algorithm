import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        int[] visitors = new int[N];
        st = new StringTokenizer(br.readLine());
        
        visitors[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i<N; i++){
            visitors[i] = Integer.parseInt(st.nextToken()) + visitors[i-1];
        }
        
        int max = visitors[X-1];
        int idx = 1;
        
        for(int i = X; i<N; i++){
            int temp = visitors[i] - visitors[i-X];
            
            if(temp > max){
                max = temp;
                idx = 1;
            }else if(temp == max) {
                idx++;
            }
        }
        
        if(max == 0)
            System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(idx);
        }
    }
}