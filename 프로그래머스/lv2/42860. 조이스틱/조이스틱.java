import java.util.*;

class Solution {
    public int solution(String name) {
        //알파벳을 바꾸는 수는 항상 같음
        //따라서 최소가 되려면 커서 이동 수를 줄여야 함
        //만약 똑같이 a라면 이동하지 않고 다음 알파벳을 생각합
        char[] c = name.toCharArray();
        int[] visited = new int[c.length];
        
        int count = 0;  //알파벳 바꾸는 조작수
        int move = c.length -1;   //바꿀 알파벳 위치로 이동하는 조작수
        
        
        for(int i = 0; i<c.length; i++){
            count += Math.min(c[i]-'A', 'Z'-c[i]+1);
            
            //다음 바꿀 알파벳 위치 확인
            int idx = i+1;
            
            while(idx<c.length && c[idx] == 'A'){
                idx++;
            }
            
            //현재 이동한 위치에서 다시 돌아가 뒤에서부터 이동해 도달하는 횟수
            move = Math.min(move, i * 2 + c.length - idx);
            
            //처음부터 뒤로 돌아갔다가 다시 정순으로
            move = Math.min(move, (c.length - idx) * 2 + i);
        }
        
        return count + move;
    }
}