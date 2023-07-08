import java.util.*;
import java.io.*;

public class Main{
    public static int[] tree;
    
    public static void update(int node, int start, int end, int idx, int diff){
        if(idx < start || idx > end) return;
        
        tree[node] = Math.max(tree[node], diff);
        
        if(start != end){
            int mid = (start + end)/2;
            update(node*2, start, mid, idx, diff);
            update(node*2+1, mid+1, end, idx, diff);
        }
    }
    
    public static int sum(int node, int start, int end, int left, int right){
        if(left>end || right < start) return -1;
        
        if(left<=start && end<=right) return tree[node];
        
        int mid = (start + end)/2;
        return Math.max(sum(node*2, start, mid, left, right), sum(node*2+1, mid+1, end, left, right));
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        //세그먼트 트리 만들기
        int h = (int)Math.ceil(Math.log(N)/Math.log(2));
        int size = (int) Math.pow(2, h+1);
        tree = new int[size];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0] - o2[0];
        });
        
        for(int i = 0; i<N; i++){
            int idx = arr[i][1];
            int temp = sum(1, 0, N-1, 0, idx);
            update(1, 0, N-1, idx, temp + 1);
        }
        
        System.out.println(N - tree[1]);
        
    }
}