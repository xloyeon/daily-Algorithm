import java.util.*;
import java.io.*;

class Bead {
    int rX;
    int rY;
    int bX;
    int bY;
    int count;
    
    public Bead(int rX, int rY, int bX, int bY, int count) {
        this.rX = rX;
        this.rY = rY;
        this.bX = bX;
        this.bY = bY;
        this.count = count;
    }
}

public class Main {
    public static int n, m;
    public static int[] moveX = {1, -1, 0, 0};
    public static int[] moveY = {0, 0, 1, -1};
    public static char[][] map;
    
    public static int bfs(Bead bead) {
        Queue<Bead> q = new LinkedList<>();
        q.add(bead);
        
        while(!q.isEmpty()) {
            Bead temp = q.poll();
            
            if(temp.count == 10)    //10번 이하만 가능
                continue;
            
            for(int i = 0; i<4; i++) {
                int rX = temp.rX;
                int rY = temp.rY;
                int bX = temp.bX;
                int bY = temp.bY;
                
                boolean isRed = false;
                boolean isBlue = false;
                
                //빨간 구슬부터 벽에 부딪힐 때까지 이동
                while(true) {
                    int rXX = rX + moveX[i];
                    int rYY = rY + moveY[i];
                    
                    if(map[rXX][rYY] == '#')
                        break;
                    
                    if(map[rXX][rYY] == 'O'){
                        isRed = true;
                        break;
                    }
                    
                    rX = rXX;
                    rY = rYY;
                }
                
                
                //파란 구슬을 벽에 부딪힐 때까지 이동
                while(true) {
                    int bXX = bX + moveX[i];
                    int bYY = bY + moveY[i];
                    
                    if(map[bXX][bYY] == '#')
                        break;
                    
                    if(map[bXX][bYY] == 'O'){
                        isBlue = true;
                        break;
                    }
                    
                    bX = bXX;
                    bY = bYY;
                }
                
                if(isBlue)    //파란공 먼저 확인해야 함
                    continue;
                else if(isRed)
                    return temp.count + 1;
                
                if(rX == bX && rY == bY) {     //둘의 좌표가 같으면 조정해주기
                    if(i == 0){
                        if(temp.rX < temp.bX)
                            rX--;
                        else
                            bX--;
                    }else if(i == 1) {
                        if(temp.rX<temp.bX)
                            bX++;
                        else
                            rX++;
                    }else if(i == 2) {
                        if(temp.rY < temp.bY) 
                            rY--;
                        else
                            bY--;
                    }else {
                        if(temp.rY < temp.bY)
                            bY++;
                        else
                            rY++;
                    }
                }
                q.add(new Bead(rX, rY, bX, bY, temp.count+1 ));
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());    //세로
        m = Integer.parseInt(st.nextToken());    //가로
        
        //0의 위치는 변할 수 없고 b와 r만 변함
        //b와 r의 위치가 변하면 기존의 위치는 .으로 변함
        
        map = new char[n][m];
        Bead bead = new Bead(0, 0, 0, 0, 0);    //임시로 만들어두기
        
        for(int i = 0; i<n; i++) {
            map[i] = br.readLine().toCharArray();
            
            for(int j = 0; j<map[i].length; j++){
                if(map[i][j] == 'R'){
                    bead.rX = i;
                    bead.rY = j;
                    map[i][j] = '.';
                }
                
                if(map[i][j] == 'B'){
                    bead.bX = i;
                    bead.bY = j;
                    map[i][j] = '.';
                }
            }
        }
        
        System.out.println(bfs(bead));
    }
}