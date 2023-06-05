import java.util.*;

class Solution {
    public List<Integer> keyList;
    
    public void checkMin(int i){
        for(Integer key : keyList){
            //이미 후보키인 키와 부분집합인 집합이 있으면 최소성 위반
            if((key & i) == key) return;
        }
        keyList.add(i);
    }
    
    public int solution(String[][] relation) {
        //조합의 길이 -> relation[0].length
        keyList = new ArrayList<>();
        int m = relation[0].length; //컬럼개수
        
        for(int i = 0; i<(1<<m); i++){  //모든 컬럼의 부분집합 탐색
            Set<String> unique = new HashSet<>();
            
            for(int j = 0; j<relation.length; j++){
                StringBuilder sb = new StringBuilder();
                
                for(int k = 0; k<m; k++){
                    if((i & (1<<k)) >0)
                        sb.append(relation[j][k]);
                }
                unique.add(sb.toString());
            }
            
            //개수 같지 않으면 중복 있으므로 유일성 위반
            if(unique.size()!= relation.length) continue;
            //최소성 확인
            checkMin(i);
        }
        return keyList.size();
    }
}