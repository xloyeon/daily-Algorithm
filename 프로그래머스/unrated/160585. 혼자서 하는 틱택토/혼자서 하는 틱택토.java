class Solution {
    
    public boolean checkWinner(String[] board, char c){
        for(int i = 0; i<board.length; i++){
            boolean isCol = true;
            boolean isRow = true;
            
            //가로 세로 확인
            for(int j = 0; j<board[i].length(); j++){
                
                //가로
                if(board[i].charAt(j) != c){
                    isRow = false;
                }
                
                //세로
                if(board[j].charAt(i) != c){
                    isCol = false;
                }
            }
            if(isCol || isRow ) return true;
        }
        
        
        //대각선 확인
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c){
            return true;
        }
        
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c){
            return true;
        }
        return false;
    }
    
    public int solution(String[] board) {

        int countO = 0;
        int countX = 0;
        boolean winnerO = checkWinner(board, 'O');
        boolean winnerX = checkWinner(board, 'X');
        
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length(); j++){
                if(board[i].charAt(j) =='O') countO++;
                else if(board[i].charAt(j) == 'X') countX++;
            }
        }
        
        //동시에 승리 불가능
        if(winnerO && winnerX) return 0;
        
        //O의 개수는 x보다 항상 1개 많거나(선공 후 종료), 아니면 X의 개수(후공 후 종료)와 같아야 한다.
        if(countO - countX >1 || countO <countX) return 0;
        
        //O가 승리라면 선공 후 종료이므로 x의 개수보다 1개 많아야 한다.
        if(winnerO && countO - countX != 1) return 0;
        
        //X가 승리라면 후공 후 종료이므로 O의 개수와 같아야 한다.
        if(winnerX && countO != countX) return 0;
        
        return 1;
    }
}