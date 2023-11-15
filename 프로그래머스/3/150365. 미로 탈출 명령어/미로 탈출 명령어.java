import java.util.*;

class Solution {
    public int N, M, X, Y, R, C, K;
    public final String IMPOSSIBLE = "impossible";
    public String result = "";
    public StringBuilder sb = new StringBuilder();
    public String[] dir = {"d", "l", "r", "u"};
    public int[] dX = {1, 0, 0, -1};
    public int[] dY = {0, -1, 1, 0};    //아래, 왼, 오른 , 위;
    
    public int distance(int x, int y, int r, int c) {
        return Math.abs(x-r) + Math.abs(y-c);
    }
    
    public void escape(int x, int y, int k) {
        //k인 경로가 만들어졌을 때
        if(!result.equals("")) return;
        
        //이제까지의 거리 + 남은 거리가 k보다 클 때
        if(k + distance(x, y, R, C) > K) return;
        
        if(k == K){
            if(x == R && y == C){
                result = sb.toString();
            }
            return;
        }  
        
        for(int i = 0; i<4; i++){
            int movedX = x + dX[i];
            int movedY = y + dY[i];
            
            if(movedX < 0 || movedX >=N || movedY < 0 || movedY >=M){
                continue;
            }
            
            //문자열 추가
            sb.append(dir[i]);
            
            //다음 경로 확인
            escape(movedX, movedY, k+1);
            
            //문자열 삭제
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        //사전 순 : d, l, r, u (아래, 왼, 오른, 위)
        //k - (최단거리)가 짝수일 때만 k가능(왔다갔다 왕복)
        this.N = n;
        this.M = m;
        this.X = x-1;
        this.Y = y-1;
        this.R = r-1;
        this.C = c-1;
        this.K = k;
        
        int distance = distance(X, Y, R, C);
        if(distance > k || (k-distance)%2==1) return IMPOSSIBLE;
        
        escape(X, Y, 0);
        
        return result;
    }
}