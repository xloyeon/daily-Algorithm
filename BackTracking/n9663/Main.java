package BackTracking.n9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static int count = 0;
    static List<Integer> board = new ArrayList<>();

    public static void backTracking(int idx){
        if(idx==n){
            count++;
            return;
        }

        //현재 열의 모든 행 확인
        for(int i = 0; i<n; i++){
            if(!checkAttackable(i, idx)){
                board.add(i);
                backTracking(idx+1);
                board.remove(board.size()-1);
            }
        }
    }

    public static boolean checkAttackable(int k, int idx){
        //0번째 col이면 이전에 퀸이 없으므로 항상 공격 받지 않음
        if(idx==0) return false;

        //만약 이전에 퀸이 존재하고, 같은 행이면 공격받음
        if(board.contains(k)) return true;

        //대각선 상에 퀸이 있는지를 확인함
        for(int i = 0; i<board.size(); i++){
            int rowGap = Math.abs(k-board.get(i));
            int colGap = Math.abs(idx-i);
            if(rowGap==colGap) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        backTracking(0);
        System.out.println(count);
    }
}
