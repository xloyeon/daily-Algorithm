import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        //greedy하게 -> 개수가 큰 것부터 넣기 ..?
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<tangerine.length; i++){
            if(!map.containsKey(tangerine[i])){
                map.put(tangerine[i], 1);
            }else{
                map.put(tangerine[i], map.get(tangerine[i])+1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (o1, o2) -> (o1.getValue().compareTo(o2.getValue())));
        
        int cur = 0;
        int result = 0;
        
        for(int i = entryList.size()-1; i>=0; i--){
            cur += entryList.get(i).getValue();
            result++;
            if(cur>=k) return result;
        }
        return result;
    }
}