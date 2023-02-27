package BOJ.BinarySearch.n1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void binarySearch(int[] lines, int n){
        long left = 1;
        long right = lines[lines.length-1];
        long mid;

        while(left<=right){
            mid = (left+right)/2;

            long count = 0;

            for(int i = 0; i<lines.length; i++){
                count += (lines[i]/mid);
            }

            if(count<n){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(right);


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lines = new int[k];

        for(int i = 0; i<k; i++){
            lines[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lines);

        binarySearch(lines, n);
    }
}
