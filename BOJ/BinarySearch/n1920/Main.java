package BOJ.BinarySearch.n1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;

    public static void binarySearch(int target){
        int min = 0;
        int max = nums.length-1;
        int mid;

        while(min<=max){
            mid = (min+max)/2;

            if(target==nums[mid]) {
                System.out.println(1);
                return;
            }else if(target<nums[mid]) {
                max = mid - 1;
            }else{
                min = mid+1;
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] find = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            find[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        for(int i : find){
            binarySearch(i);
        }
    }
}
