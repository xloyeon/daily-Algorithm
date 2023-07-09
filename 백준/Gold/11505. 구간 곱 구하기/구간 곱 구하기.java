import java.util.*;
import java.io.*;

public class Main {
    public static final int MOD = 1000000007;
    public static long[] tree, input;
    
    public static void makeTree(int n){
        int h = (int) Math.ceil(Math.log(n)/Math.log(2)) ;
        int size = (int) Math.pow(2, h+1);
        tree = new long[size];
    }
    
    public static long init(int node, int start, int end) {
        if(start == end) return tree[node] = input[start];
        
        int mid = (start + end)/2;
        return tree[node] = (init(node*2, start, mid) * init(node*2+1, mid+1, end))%MOD;
    }
    
    public static long update(int node, int start, int end, int idx, int value) {
        if(idx < start || idx > end) return tree[node];
        
        if(start == end) return tree[node] = value;
        
        int mid = (start + end)/2;
        return tree[node] = (update(node*2, start, mid, idx, value) * update(node*2+1, mid+1, end, idx, value))%MOD;
    }
    
    public static long mul(int node, int start, int end, int left, int right) {
        if (left > end || right < start)
			return 1;
        
        if (left <= start && end <= right) 
			return tree[node];
        
        int mid = (start + end) / 2;
		return (mul(node*2, start, mid, left, right) * mul(node*2+1, mid + 1, end, left, right)) % MOD;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        
        input = new long[N+1];
        
        for(int i = 1; i<=N; i++){
            input[i] = Long.parseLong(br.readLine());
        }
        
        makeTree(N);
        init(1, 1, N);
        
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            if(a == 1){
                update(1, 1, N, b, (int)c);
                input[b] = c;
            }else if(a == 2) {
                System.out.println(mul(1, 1, N, b, (int)c));
            }
        }
    }
}