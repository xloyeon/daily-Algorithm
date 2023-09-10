import java.io.*;
import java.util.*;

class Tree implements Comparable<Tree> {
    int x;
    int y;
    int age;
    
    public Tree(int x, int y, int age){
        this.x = x;
        this.y = y;
        this.age = age;
    }
    
    public int compareTo(Tree t){
        return this.age - t.age;
    }
}

public class Main {
    public static int N, M, K;
    public static int[][] A;    //커지는 양분
    public static int[][] ground;    //현재
    public static PriorityQueue<Tree> trees;
    public static int[] dX = { -1, -1, -1, 0, 0, 1, 1, 1 };
    public static int[] dY = { -1, 0, 1, -1, 1, -1, 0, 1 };
    
    public static void growTree(){
        Queue<Tree> dead = new LinkedList<>();
        
        int size = trees.size();
        //봄
        
        PriorityQueue<Tree> tempTrees = new PriorityQueue<>();
        
        for(int i = 0; i<size; i++){
            Tree tree = trees.poll();
            
            if(ground[tree.x][tree.y]>=tree.age){
                ground[tree.x][tree.y] -= tree.age;    //양분빼기
                tree.age++;    //나무 나이 먹기
                tempTrees.add(tree);
            }else{
                dead.add(tree);
            }
        }
        
        trees = tempTrees;
        
        //여름 -> 죽은 나무가 양분됨
        while(!dead.isEmpty()){
            Tree tree = dead.poll();
            ground[tree.x][tree.y] += tree.age/2;
        }
        
        //가을
        Queue<Tree> fall = new LinkedList<>();
        
        for(Tree tree : trees){
            if(tree.age %5 == 0)
                fall.add(tree);
        }
        
        while(!fall.isEmpty()){
            Tree tree = fall.poll();
            
            for(int i = 0; i<8; i++){
                int movedX = tree.x + dX[i];
                int movedY = tree.y + dY[i];
                
                if(movedX>=1 && movedX<=N && movedY>=1 && movedY<=N){
                    trees.add(new Tree(movedX, movedY, 1));
                }
            }
        }
        
        //겨울
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                ground[i][j] += A[i][j];
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        A = new int[N+1][N+1];   
        ground = new int[N+1][N+1];
        trees = new PriorityQueue<>();
        
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                ground[i][j] = 5;    //초기에는 모두 5
            }
        }
        
        
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
        }
        
        for(int i = 0; i<K; i++){
            growTree();
        }
        
        System.out.println(trees.size());
    }
}