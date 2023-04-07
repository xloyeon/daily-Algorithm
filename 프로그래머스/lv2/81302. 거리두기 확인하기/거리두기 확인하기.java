import java.util.*;
class Solution {

    int getDistance(Pair p1, Pair p2) {
        return Math.abs(p1.row - p2.row) + Math.abs(p1.col - p2.col);        
    }

    int solve(char[][] board, ArrayList<Pair> people) {
        for(int i = 0 ; i < people.size();i++) {
            Pair p1 = people.get(i);
            for(int j = i + 1; j < people.size(); j++) {                
                Pair p2 = people.get(j);
                int distance = getDistance(p1, p2);
                if(distance < 2) return 0;
                if(distance == 2) {
                    if(p1.row == p2.row) {
                        if(board[p1.row][(p1.col + p2.col) / 2] == 'O') return 0;
                    }
                    else if(p1.col == p2.col) {
                        if(board[(p1.row + p2.row)/2][p1.col] == 'O') return 0;
                    }
                    else if(Math.abs(p1.row - p2.row) == 1 && Math.abs(p1.col - p2.col) == 1) {
                        if(board[p1.row][p2.col] != 'X' || board[p2.row][p1.col] != 'X') return 0;
                    }                    
                }
            }
        }
        return 1;
    }

    public int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[places.length];

        for(int i = 0 ; i < places.length; i++) {
            char[][] board = new char[5][5];
            ArrayList<Pair> people = new ArrayList();
            for(int r = 0; r < 5; r++) {
                for(int c = 0; c < 5; c++) {
                    board[r][c] = places[i][r].charAt(c);
                    if(board[r][c] == 'P') {
                        people.add(new Pair(r,c));
                    }
                }
            }
            answer[i] = solve(board, people);
        }        
        return answer;
    }
    class Pair {
        int row, col;
        Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
}