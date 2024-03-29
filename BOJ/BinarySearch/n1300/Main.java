package BOJ.BinarySearch.n1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = k;
        int mid;
        int result = 0;

        while(left<=right){
            mid = (left+right)/2;
            int count=0;

            for(int i = 1; i<=n; i++){
                count += Math.min(mid/i, n);
            }

            if(count>=k){
                result = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        System.out.println(result);
    }
}
