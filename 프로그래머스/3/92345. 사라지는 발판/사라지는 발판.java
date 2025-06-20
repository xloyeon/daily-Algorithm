import java.util.*;

class Solution {
    public int[][] board;
    public int[] moveR = {-1, 0, 0, 1};
    public int[] moveC = {0, -1, 1, 0};
    
    public boolean checkMovable(int r, int c){
        //이동하려는 위치가 보드를 벗어난 경우
        if(r<0 || c <0 || r>=board.length || c>=board[0].length)
            return false;
        
        //이동하려는 위치에 발판이 없는 경우
        if(board[r][c] == 0)
            return false;
        
        return true;
    }
    
    public int dfs(int r, int c, int nextR, int nextC){
        //누군가가 이동해서 현재 발판이 사라진 경우
        if(board[r][c] == 0)
            return 0;
        
        int result = 0;    //경우의 수 별 선택값 저장
        
        for(int i = 0; i<4; i++){
            int movedR = r + moveR[i];
            int movedC = c + moveC[i];
            
            if(!checkMovable(movedR, movedC))
                continue;
            
            //이동가능한 경우가 있을 때 이동
            board[r][c] = 0;
            
            int cnt = dfs(nextR, nextC, movedR, movedC) + 1; //이동했으므로 turn수 증가
            
            if(result%2 ==1 && cnt%2 ==1){  //이기는 수가 이미 있고 현재도 이기는 수라면
                result = Math.min(result, cnt);
            }else if(result%2 == 0 && cnt%2 == 1){    //처음으로 이기는 수일 때
                result = cnt;
            }else if(result%2 ==0 && cnt %2 == 0) {
                result = Math.max(result, cnt);
            }
            
            board[r][c] = 1; //발판 다시 생성
        }
        
        return result;
    }
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
}