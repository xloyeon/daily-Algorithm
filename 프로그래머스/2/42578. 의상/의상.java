import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        //의상 이름, 의상 종류가 들어있는 배열 -> 의상 종류가 key
        
        HashMap<String, Integer> cMap = new HashMap<>();
        
        for(int i = 0; i<clothes.length; i++){
            cMap.put(clothes[i][1], cMap.getOrDefault(clothes[i][1], 0)+1);
        }
        
        int answer = 1;
        
        for(String k : cMap.keySet()){
            answer *= (cMap.get(k)) + 1;
        }
        return answer-1;
    }
}