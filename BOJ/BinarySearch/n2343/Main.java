package BOJ.BinarySearch.n2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void binarySearch(int[] lectures, int m){
        long left = Arrays.stream(lectures).max().getAsInt();;
        long right =Arrays.stream(lectures).sum();
        long mid;
        long result = 0;

        while(left<=right){
            mid = (left+right)/2;

            int count = 0;
            int temp = 0;
            for(int lecture:lectures){
                if(temp + lecture>mid){
                    temp = 0;
                    count++;
                }
                temp += lecture;
            }

            if(count>=m){
                left = mid+1;
            }else{
                result = mid;
                right = mid-1;
            }
        }
        System.out.println(result);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lectures = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<n; i++){
            lectures[i] = Integer.parseInt(st.nextToken());
        }

        binarySearch(lectures, m);
    }
}
