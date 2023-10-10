import java.util.*;

class Solution {
    
    public int solution(int[][] board, int[][] skill) {
        /*
        * 누적합 -> 2차원 배열 만들어서 더하기
        * 시작점과 끝점에 더하고 왼-> 오, 위-> 아래 점에 빼기
        */
        
        int result = 0; //파괴되지 않은 건물
        
        int[][] sum = new int[board.length + 1][board[0].length +1];    //누적합 배열
        
        for(int[] s : skill){
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            if(type == 1)   //낮춘다 = 뺌
                degree *= -1;
            
            sum[r1][c1] += degree; 
            sum[r2+1][c1] -= degree;
            sum[r1][c2+1] -= degree;
            sum[r2+1][c2+1] += degree;
        }
        
        //위 -> 아래 누적합
        for(int i = 0; i<sum[0].length; i++){
            for(int j = 0; j<board.length; j++){
                sum[j+1][i] += sum[j][i];
            }
        }
        
        //왼 -> 오 누적합
        for(int i = 0; i<sum.length; i++){
            for(int j = 0; j<board[0].length; j++){
                sum[i][j+1] += sum[i][j];
            }
        }
        
        //원래의 배열과 더하기
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                board[i][j] += sum[i][j];
                
                if(board[i][j] > 0) result++;
            }
        }
        
        return result;
    }
}