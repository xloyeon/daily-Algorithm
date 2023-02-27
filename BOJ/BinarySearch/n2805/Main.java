package BOJ.BinarySearch.n2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void binarySearch(int[] trees, int m){
        long mid;
        long min = 0;
        long max = Arrays.stream(trees).max().getAsInt();

        while(min<=max){
            mid = (min+max)/2;

            long temp = 0;
            for(int tree: trees){
                if(tree>mid){
                    temp += (tree-mid);
                }
            }

            if(temp <m){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        binarySearch(trees, m);

    }
}
