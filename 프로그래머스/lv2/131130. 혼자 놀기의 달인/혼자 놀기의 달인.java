import java.util.*;

class Solution {
    public int solution(int[] cards) {
        //cards의 상자 수를 2개 그룹으로 나누어 그 그룹의 개수 두 개 곱한 것이 점수
        
        List<Integer> result = new ArrayList<>();
        int[] visited = new int[cards.length];
        int n = cards.length;
        int k = 0;  //오픈할 상자의 index
         
        while(k<cards.length && n>0){
            int cnt = 0;
            
            if(k == cards[k]-1){    //상자번호와 카드 번호 같을 때
                visited[k] = 1;
                cnt = 1;
            }else{
                int i = k;
                
                while(visited[i] == 0){
                    visited[i] = 1;
                    i = cards[i]-1;
                    cnt++;
                }
            }
            
            n-=cnt;
            result.add(cnt);
            k++;
        }
        
        Collections.sort(result, Collections.reverseOrder());
        
        if(result.size()<=1) return 0;
        return result.get(0)*result.get(1);
    }
}