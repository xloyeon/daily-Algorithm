import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] result = new int[2];  //시작번호, 끝 번호 담을 것임
        
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> gemSet = new HashSet<>();
        
        for(String gem : gems)
            gemSet.add(gem);
        
        Queue<String> q = new LinkedList<>();
        
        //범위 값
        int range = Integer.MAX_VALUE;
        
        int start = 0;
        int end = 0;
        
        for(int i = 0; i<gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            q.add(gems[i]);
            
            while(map.get(q.peek()) >1){
                map.put(q.peek(), map.get(q.poll())-1);
                end++;
            }
            
            if(map.size() == gemSet.size() && range > (i-end)){
                range = i-end;
                start = end +1;
            }
        }
        
        result[0] = start;
        result[1] = start + range;
        
        return result;
        
    }
}