import java.util.*;
import java.io.*;

public class Main {
    public static long[] solution;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        solution = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<n; i++){
            solution[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(solution);    //투포인터 이용하므로 정렬
        
        long min = Long.MAX_VALUE;
        
        long[] result = new long[3];
        
        for(int i = 0; i<n-2; i++){
            int first = i;    //i에 대해 확인
            
            int second = i+1;
            int third = n-1;
            
            long sum = solution[first] + solution[second] + solution[third];
            
            while(second<third){
                if(Math.abs(sum)<min){
                    min = Math.abs(sum);
                    result[0] = solution[first];
                    result[1] = solution[second];
                    result[2] = solution[third];
                }
                
                if(sum >=0){    //0보다 크면 right을 줄임
                    sum -= solution[third];
                    third--;
                    sum += solution[third];
                }else {
                    sum -= solution[second];
                    second++;
                    sum += solution[second];
                }
            }
        }
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}