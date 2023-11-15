import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static String[][] name;
    
    public static int binarySearch(int n) {
        int left = 0;
        int right = N-1;
        int mid = (left+right)/2;
        
        while(left<=right) {
            mid = (left+right)/2;
            
            int temp = Integer.parseInt(name[mid][1]);
                
            if(temp<n){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return left;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        name = new String[N][2];
        
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            name[i][0] = st.nextToken();
            name[i][1] = st.nextToken();
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<M; i++){
            int n = Integer.parseInt(br.readLine());
            int idx = binarySearch(n);
            sb.append(name[idx][0] + "\n");
            
        }
        
        System.out.println(sb.toString());
    }
}