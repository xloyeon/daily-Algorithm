import java.io.*;
import java.util.*;

public class Main {
    public static int[] input, tree;
    
    public static void makeTree(int n){
        int h = (int) Math.ceil(Math.log(n)/Math.log(2));
        int size = (int) Math.pow(2, h+1);
        tree = new int[size];
    }
    
    public static int init(int node, int start, int end) {
        if(start == end) return tree[node] = input[start];
        
        int mid = (start + end)/2;
        return tree[node] = (init(node*2, start, mid) * init(node*2+1, mid+1, end));
    }
    
    public static int update(int node, int start, int end, int idx, int value){
        if(idx< start || idx > end) return tree[node];
        
        if(start == end) return tree[node] = value;
        
        int mid = (start + end)/2;
        return tree[node] = update(node*2, start, mid, idx, value)*update(node*2+1, mid+1, end, idx, value);        
    }
    
    public static int mul(int node, int start, int end, int left, int right) {
        if (left > end || right < start)
			return 1;
        
        if (left <= start && end <= right)
			return tree[node];
        
        int mid = (start + end) / 2;
		return mul(node*2, start, mid, left, right) * mul(node*2+1, mid + 1, end, left, right);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        
        while((s = br.readLine())!= null) {
            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
        
            input = new int[N+1];
        
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i<=N; i++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 0){
                    input[i] = 0;
                }else if(temp > 0){
                    input[i] = 1;
                }else {
                    input[i] = -1;
                }
            }
        
            makeTree(N);
            init(1, 1, N);
        
            for(int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                
                if(op.equals("C")){
                    int val = 0;
                    if(v > 0) val = 1;
                    else if(v<0) val = -1;
                    
                    update(1, 1, N, a, val);
                }else if(op.equals("P")){
                    long temp = mul(1, 1, N, a, v);
                    if(temp<0){
                        System.out.print("-");
                    }else if(temp == 0){
                        System.out.print("0");
                    }else{
                        System.out.print("+");
                    }
                }
            }
            System.out.println();
        }
            
    }
}