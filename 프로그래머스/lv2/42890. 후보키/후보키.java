import java.util.*;

class Solution {
    public List<Integer> keyList;
    
    public void checkMin(int i){
        for(Integer key : keyList){
            if((key & i) == key) return;
        }
        keyList.add(i);
    }
    
    public int solution(String[][] relation) {
        //조합의 길이 -> relation[0].length
        keyList = new ArrayList<>();
        int m = relation[0].length; //컬럼개수
        
        for(int i = 0; i<(1<<m); i++){
            Set<String> unique = new HashSet<>();
            
            for(int j = 0; j<relation.length; j++){
                StringBuilder sb = new StringBuilder();
                
                for(int k = 0; k<m; k++){
                    if((i & (1<<k)) >0)
                        sb.append(relation[j][k]);
                }
                unique.add(sb.toString());
            }
            
            if(unique.size()!= relation.length) continue;
            checkMin(i);
        }
        return keyList.size();
    }
}