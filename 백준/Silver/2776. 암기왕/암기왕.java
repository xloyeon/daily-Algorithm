import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static int[] nums1, nums2;
    public static StringBuilder sb;
    
    public static boolean binarySearch(int target){
        int start = 0;
        int end = N-1;
        int mid = (start+end)/2;
        
        while(start<=end){
            mid = (start+end)/2;
            
            if(target==nums1[mid]){
                return true;
            }else if(target<nums1[mid]){
                end = mid-1;
            }else if(target>nums1[mid]){
                start = mid+1;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            nums1 = new int[N];
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j<N; j++){
                nums1[j] = Integer.parseInt(st.nextToken());
            }
            
            M = Integer.parseInt(br.readLine());
            nums2 = new int[M];
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j<M; j++){
                nums2[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(nums1);
            sb = new StringBuilder();
            
            for(int j = 0; j<M; j++){
                if(binarySearch(nums2[j]))
                    sb.append(1 + "\n");
                else
                    sb.append(0 + "\n");
                    
            }
            System.out.print(sb.toString());
        }
    }
}