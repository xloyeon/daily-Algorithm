import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        int cnt = nums.length/2;    //고를 수 있는 포켓몬의 개수
        
        //포켓몬의 종류 개수? 
        //key 종류 수가 고를 수 있는 개수보다 더 많으면 고를 수 있는 개수가 최대
        //key 종류 수가 고를 수 있는 개수보다 더 적으면 key 종류 수가 최대
        if(map.keySet().size()<cnt){
            return map.keySet().size();
        }
        return cnt;
    }
}