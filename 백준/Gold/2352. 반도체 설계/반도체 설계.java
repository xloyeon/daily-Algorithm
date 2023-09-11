import java.io.*;
import java.util.*;

public class Main {
    //포트 번호가 증가해야 함 -> 최장증가부분수열
    //마지막 값보다 크면 추가
    //마지막 값보다 작으면 -> 값을 추가할 위치 찾음
    public static int n;
    public static int[] port, arr;
    
    public static void binarySearch(int idx, int p){
        int start = 0;
        int end = idx;
        
        while(end>=start){
            int mid = (start+end)/2;
            
            if(arr[mid]<p)
                start = mid+1;
            else
                end = mid-1;
        }
        
        arr[start] = p;    //값 바꿔줌
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        port = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i<n; i++){
            port[i] = Integer.parseInt(st.nextToken());
        }
        
        arr = new int[n];
        int idx = 0;
        arr[0] = port[0];    //첫번째 시작
        
        for(int i = 1; i<n; i++){
            if(port[i]>arr[idx]) {   //크면 그냥 추가
                idx++;
                arr[idx] = port[i];
            }else {    //작으면 위치 찾아서 추가
                binarySearch(idx, port[i]);
            }
        }
        
        System.out.println(idx+1);
    }
}