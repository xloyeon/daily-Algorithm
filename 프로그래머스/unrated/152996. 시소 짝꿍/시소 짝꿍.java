import java.util.*;

class Solution {
    public double[] d = {1.0, 2.0/3.0, 3.0/4.0, 2.0/4.0};
    
    public long solution(int[] weights) {
        //a의 무게*거리 = b의 무게*거리 일 때, 시소 짝꿍
        long count = 0L;    //시소 짝꿍 수
        
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i = 0; i<weights.length; i++){
            int a = weights[i];
            
            for(int j = 0; j<d.length; j++){
                if(map.containsKey(a*d[j])) count += map.get(a*d[j]);
            }
            map.put(a*1.0, map.getOrDefault(a*1.0, 0)+1);
        }
        
        return count;
    }
}