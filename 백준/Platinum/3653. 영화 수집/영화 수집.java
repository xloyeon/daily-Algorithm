import java.util.*;
import java.io.*;

public class Main {
    //i번째 영화 찾으면 i~이후의 영화 개수 하나씩
    //N+M을 트리의 노드로
    public static int[] tree, input, index;
    
    public static void makeTree(int n){
        int h = (int) Math.ceil(Math.log(n)/Math.log(2));
        int size = (int) Math.pow(2,h+1);
        tree = new int[size];
    }
    
    public static int init(int node, int start, int end){
        if(start == end) {
            if(input[start]!=0) return tree[node] = 1;
            else return tree[node] = 0;
        }
        
        int mid = (start + end)/2;
        return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
    }
    
    public static int update(int node, int start, int end, int idx, int value){
        if(idx<start || end <idx) return tree[node];
        
        if(start == end) return tree[node] = value;
        
        int mid = (start + end)/2;
        return tree[node] = update(node*2, start, mid, idx, value) + update(node*2+1, mid+1, end, idx, value);
    }
    
    public static int sum(int node, int start, int end, int left, int right){
        if(right < start || end < left) return 0;
        
        if(left <= start && right >= end) return tree[node];
        
        int mid = (start + end)/2;
        return tree[node] = sum(node*2, start, mid, left, right) + sum(node*2+1, mid+1, end, left, right);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());    //테스트 케이스 개수
        
        for(int i = 0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            input = new int[N+M];
            index = new int[N+1];
            
            for(int j = 1; j<=N; j++){
                //앞에 m개 비워놓고 시작
                input[M+j-1] = 1;
                index[j] = j+M-1;
            }
            
            makeTree(N+M);
            init(1, 0, N+M-1);
            
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                int movie = Integer.parseInt(st.nextToken());
                
                //위에 있는 개수 -> sum
                 bw.write(sum(1, 0, N+M-1, 0, index[movie]-1) + " ");
                
                //movie를 가장 위로
                update(1, 0, N+M-1, index[movie], 0);
                index[movie] = M-j-1;
                update(1, 0, N+M-1, index[movie], 1);
            }
            bw.write("\n");
        }
        
        bw.flush();
    }
}