import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //전체 지방 수
        
        //각 지방마다 배정해야 하는 예산 입력받고 저장
        int[] budgets = new int[N];
        
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        
        long total = Long.parseLong(br.readLine());    //총 예산
        
        //예산 오름차순 정렬
        Arrays.sort(budgets);
        
        long start = 0;
        long end = budgets[N-1];
        long mid = 0;
        
        while(start <= end) {
            mid = (start + end)/2;
            
            long tempTotal = 0;
            
            for(int i = 0; i<N; i++){
                if(mid > budgets[i])
                    tempTotal += budgets[i];
                else
                    tempTotal += mid;
            }
            
            if(tempTotal >total) {
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        
        System.out.println(end);
    }
}