import java.util.*;
import java.io.*;

/*
** 놀이기구에 몇 명 탑승했는지 -> (분)/(놀이기구 운행 시간)
** 마지막 놀이기구 -> (분)%(운행시간) == 0인 곳
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] rides = new int[M];
        
        st = new StringTokenizer(br.readLine());
        int max = 0;
        
        for(int i = 0; i<M; i++){
            rides[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, rides[i]);
        }
        
        if(N<=M){
            System.out.println(N);
            return;
        }
        
        long start = 0;
        long end = max * (N/M);
        long mid = (start + end)/2;
       
        while(start<=end){
            mid = (start + end)/2;
            
            long mins = M;
            
            for(int i = 0; i<M; i++){
                mins += mid/rides[i];
            }
            
            if(mins<N){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        long before = M;
        
        for(int i = 0; i<rides.length; i++){
            before += (start-1)/rides[i];
        }
        
        for(int i = 0; i<M; i++){
            if(start%rides[i] == 0){
                before++;
            }
            
            if(before == N){
                System.out.println(i+1);
                return;
            }
        }
    }
}