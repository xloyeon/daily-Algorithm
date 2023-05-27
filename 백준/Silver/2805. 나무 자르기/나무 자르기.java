import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

/**
 * 구하는 값 - 절단기 설정 높이의 최댓값
 *
 * 주어진 나무 배열 돌면서 설정한 높이만큼 자름
 * -> 자르고 남은 길이를 다 더 했을 때 m이 되어야 함(찾음 !)
 *
 * 주의 : 절단기 높이가 더 높을 경우 잘라지지 않음
 *
 * 절단기 설정 높이는 0부터 나무 최대 높이까지 가능할 것
 */
public class Main {
    static long[] trees;

    public static void binarySearch(int m){
        long left = 0;
        long right = trees[trees.length-1];
        long mid = 0L;

        while(left<=right){
            mid = (left+right)/2;

            long sum = 0L;

            for(long tree : trees){
                if(tree>mid)
                    sum += tree-mid;
            }

            if(sum>=m){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        System.out.println(right);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        trees = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        binarySearch(m);
    }
}
