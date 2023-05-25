import java.util.*;

class Solution {
    
    public int solution(int [][]board) {
        //정사각형을 구하는 방법 -> (i, j)에서 가로 n, 세로 n까지 모두 1
        //(i, j)에서 가로 1, 세로 1만큼의 정사각형 이내 좌표 "모두" 1인지 확인
        //모두 1이 아니면 -> 넘어감
        //모두 1이면 -> 일단 현재 경로 visited 체크 -> 가로1, 세로1만큼의 정사각형 좌표들에서 1, 1만큼 또 확인
        //모두 1이면 넘어감 -> ...반복
        boolean isAllZero = true;
        
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 1) {
                    isAllZero = false;
                    break;
                }
            }
        }
        
        if(isAllZero) return 0;    //모두 0이면 정사각형 넓이 0
        
        int max = 1;
        
        for(int i = 1; i<board.length; i++){
            for(int j = 1; j<board[0].length; j++){
                if(board[i][j] == 0) continue;
                board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1])+1;
                max = Math.max(max, board[i][j]);
            }
        }
        
        return max*max;
    }
}