import java.util.*;
import java.io.*;

class Num {
    int x;
    int y;
    
    public Num(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int N, M, T;
    public static int[][] circle;
    public static HashSet<Num> set = new HashSet<>();
    
    public static void rotate(int d, int idx){
        if(d == 0){    //시계방향
            int temp = circle[idx][M];
            
            for(int j = M; j>1; j--){
                circle[idx][j] = circle[idx][j-1];
            }
            circle[idx][1] = temp;
        }else {    //반시계방향
            int temp = circle[idx][1];
            
            for(int j = 1; j<M; j++){
                circle[idx][j] = circle[idx][j+1];
                
            }
            circle[idx][M] = temp;
        }
    }
    
    public static void check(){
        set = new HashSet<>();
        
        //같은 원판 내에서 인접하는 것
        for(int i = 1; i<= N; i++){
            for(int j = 1; j<M; j++){
                
                
                if(circle[i][j] == 0){    //0이면 같은 수가 있을 수 없음(제거된 수)
                    continue;
                }
                
                if(j == 1){
                   if(circle[i][1] == circle[i][M]){
                       set.add(new Num(i, 1));
                       set.add(new Num(i, M));
                   }
            
                }
                
                if(circle[i][j] == circle[i][j+1]){
                    set.add(new Num(i, j));
                    set.add(new Num(i, j+1));
                }
            }
        }
        
        //다른 원판끼리 인접 찾기
        for(int i = 1; i<N; i++){
            for(int j = 1; j<=M; j++){
                if(circle[i][j] == 0)
                    continue;
                
                if(circle[i][j] == circle[i+1][j]){
                    set.add(new Num(i, j));
                    set.add(new Num(i+1, j));
                }
            }
        }
    }
    
    public static void changeNumber() {
        double sum = 0;
        double count = 0;
        
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                if(circle[i][j] != 0)  {  //수가 있으면
                    sum += circle[i][j];
                    count++;
                }
            }
        }
        
        if(count!=0){
            sum = sum/count;
        }
        
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                if(circle[i][j] == 0)  {  //수가 없으면
                    continue;
                }
                
                if(sum> circle[i][j])  {  //수가 평균보다 작으면
                    circle[i][j]++;
                }else if(sum < circle[i][j]) {   //수가 평균보다 크면
                    circle[i][j]--;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        circle = new int[N+1][M+1];    //원판의 수를 저장할 배열
        
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j<M; j++){
                circle[i+1][j+1] = Integer.parseInt(st.nextToken());
            }
        }
        
        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            //x의 배수인 원판 모두 k칸 회전
            for(int i = x; i<=N; i+= x){
                for(int j = 0; j <k; j++){
                    rotate(d, i);
                }
            }
            
            //원판에서 인접하면서 수가 같은것 찾고 지우기
            check();
            
            if(set.size() != 0)  {  //지울 수 있는 것 있음
                for(Num n : set){
                    circle[n.x][n.y] = 0;    //지움
                }
            }else {    //지울 수 있는 것 없음
                changeNumber();
            }
        }
        
        int result = 0;
        
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=M; j++){
                result += circle[i][j];
            }
        }
        
        System.out.println(result);
        
    }
}