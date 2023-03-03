package Programmers.크레인인형뽑기게임;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> stacks = new ArrayList<>();
        Stack<Integer> basket = new Stack<>();
        int result = 0;

        //board를 stack 5개로 만듦
        for(int i = 0; i<board.length; i++){
            Stack<Integer> stack = new Stack<>();
            for(int j = board.length-1; j>=0; j--){
                if(board[j][i] != 0)
                    stack.push(board[j][i]);
            }
            stacks.add(stack);
        }

        for(int move : moves){
            //이동한 line의 인형들 stack 가져옴
            Stack<Integer> movedLine = stacks.get(move-1);

            if(movedLine.size()==0) continue;

            //이동한 line에서 맨 위 인형 뽑음
            int popDoll = movedLine.pop();

            if(basket.size() >0 && basket.peek() == popDoll) {
                result += 2;
                basket.pop();
            }else{
                basket.push(popDoll);
            }
        }

        return result;
    }
}