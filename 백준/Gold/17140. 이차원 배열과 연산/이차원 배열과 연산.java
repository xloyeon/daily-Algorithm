import java.util.*;
import java.io.*;

class Nums implements Comparable<Nums> {
    int num;
    int count;
    
    public Nums(int num, int count){
        this.num = num;
        this.count = count;
    }
    
    public int compareTo(Nums o){
        //수의 등장횟수(count)가 커지는 순, 수(num)이 커지는 순
        if(this.count==o.count){
            return this.num-o.num;
        }
        return this.count-o.count;
    }
}

public class Main {
    public static int r, c, k;
    public static int row, col;
    public static int[][] A = new int[101][101];
    
    public static void R(int n){
        PriorityQueue<Nums> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();    //숫자, 등장횟수
    
        
        for(int i = 1; i<=col; i++){
            if(A[n][i] == 0) continue;
            
            if(map.containsKey(A[n][i])) 
                map.put(A[n][i], map.get(A[n][i])+1);
            else
                map.put(A[n][i], 1);
        }
        
        Set<Integer> keySet = map.keySet();
        
        for(Integer key : keySet){
            Nums nums = new Nums(key, map.get(key));
            pq.add(nums);
        }
        
        int idx = 1;
        while(!pq.isEmpty()){
            Nums nums = pq.poll();
            A[n][idx] = nums.num;
            A[n][idx+1] = nums.count;
            idx+=2;
        }
        
        col = Math.max(col, idx);
        
        //나머지 다시 0으로 채워야 함
        
        while(idx<=100){
            A[n][idx++] = 0;
        }
    }
    
    public static void C(int n){
        PriorityQueue<Nums> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();    //숫자, 등장횟수
    
        
        for(int i = 1; i<=row; i++){
            if(A[i][n] == 0) continue;
            
            if(map.containsKey(A[i][n])) 
                map.put(A[i][n], map.get(A[i][n])+1);
            else
                map.put(A[i][n], 1);
        }
        
        Set<Integer> keySet = map.keySet();
        
        for(Integer key : keySet){
            Nums nums = new Nums(key, map.get(key));
            pq.add(nums);
        }
        
        int idx = 1;
        while(!pq.isEmpty()){
            Nums nums = pq.poll();
            A[idx][n] = nums.num;
            A[idx+1][n] = nums.count;
            idx+=2;
        }
        
        row = Math.max(row, idx);
        
        //나머지 다시 0으로 채워야 함
        
        while(idx<=100){
            A[idx++][n] = 0;
        }
    }
    
   
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i<=3; i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j = 1; j<=3; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        row = 3;    //행의 개수
        col = 3;    //열의 개수
        
        for(int i= 0; i<=100; i++){
            if(A[r][c] == k){
                System.out.println(i);
                System.exit(0);
            }
            
            if(row>=col){
                for(int j = 1; j<=row; j++)
                    R(j);
            }else{
                for(int j = 1; j<=col; j++)
                    C(j);
            }
        }
        System.out.println(-1);
    }
}