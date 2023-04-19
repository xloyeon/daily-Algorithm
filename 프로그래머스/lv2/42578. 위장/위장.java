import java.util.*;

class Solution {
    
    /* 상의 2개, 하의 3개, 신발 2개로 조합
    * 2*3*2 -> 12(단, 이 경우 상의, 하의, 신발 중 한 가지씩 입음)
    * 없는 경우까지 포함하면 3*4*3 -> 36(단, 이 경우 모두 안 입은 경우도 포함됨)
    * 따라서, 상의, 하의, 신발을 하나 이상 걸쳐서 입는 조합의 수는 -> 36-1 = 35
    */
    
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] arr : clothes){
            if(!map.containsKey(arr[1])){
                map.put(arr[1], 1);
            }else{
                map.put(arr[1], map.get(arr[1]) + 1);
            }
        }
        
        List<Integer> valueList = new ArrayList<>(map.values());
        int result = 1;
        
        for(int i : valueList){
            result *= (i+1);
        }
        
        return result-1;
        
    }
}