import java.util.*;

class Solution {
    public int answer = 0;
    
    //일단 5개 조합 만들기
    public void combination(int n, int[][] q, int[] ans, int idx, List<Integer> list){
        if(list.size() == 5){
            if(decipherCode(q, ans, list))
                answer++;
            return;
        }
        
        for(int i = idx; i<n; i++){
            list.add(i+1);
            combination(n, q, ans, i+1, list);
            list.remove(list.size()-1);
        }
    }
    
    //조합이 ans 개수를 통과하는지 검증
    public boolean decipherCode(int[][] q, int[] ans, List<Integer> list){
        for(int i = 0; i<q.length; i++){
            int cnt = 0;
            
            for(int j = 0; j<q[i].length; j++){
                for(int k = 0; k<list.size(); k++){
                    if(q[i][j] == list.get(k)){
                        cnt++;
                        break;
                    }
                }
            }
            
            if(cnt != ans[i]) return false;
        }
        
        return true;
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        //조합 구하고 >> 확인하기 ..
        combination(n, q, ans, 0, new ArrayList<>());
        return answer;
    }
}