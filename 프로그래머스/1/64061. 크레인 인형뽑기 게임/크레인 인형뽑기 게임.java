
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        //인형의 최상단 위치를 저장
        int[] idx = new int[board.length];
        
        for(int i = board.length-1; i>=0; i--){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] != 0){
                    idx[j] = i;
                }
            }
        }
        
        Stack<Integer> stack = new Stack<>();
        int answer = 0;     //없어진 인형 개수
        
        for(int i = 0; i<moves.length; i++){
            //현재 인형을 뽑을 위치(행)
            int k = idx[moves[i]-1];
            
            if(board[k][moves[i]-1] == 0){  //모두 빈 열일 때
                continue;
            }
            
            if(!stack.isEmpty() && board[k][moves[i]-1] == stack.peek()){
                stack.pop();
                answer +=2;
            }else{
                stack.push(board[k][moves[i]-1]);
            }
            
            board[k][moves[i]-1] = 0;
            if(k!= board.length-1) 
                idx[moves[i]-1] +=1;
        }
        
        return answer;
    }
}