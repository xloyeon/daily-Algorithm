import java.util.*;

class Solution {
    public int count = 0;
    public HashSet<Integer> set;
    public int[] visited;
    
    
    public void permute(String numbers, String cur){
        if(!cur.equals("")){
            // 현재까지를 숫자로 만들기(ex - 0011 => 11)
            int num = Integer.parseInt(cur);
            checkPrime(num);
        }
        
        for(int i = 0; i<numbers.length(); i++){
            if(visited[i]==0){
                visited[i] = 1;
                permute(numbers, cur + numbers.charAt(i));
                visited[i] = 0;
            }
        }
    }
    
    public void checkPrime(int num){
        // 이전에 있었는지 확인
        if(set.contains(num))
            return;
        
        // 소수 판별 시작
        if(num < 2) 
            return;
        
        for(int i = 2; i<num; i++){
            if(num %i == 0)
                return;
        }
    
        count++;
        set.add(num);
    }
    
    public int solution(String numbers) {
        visited = new int[numbers.length()];
        set = new HashSet<>();
        
        permute(numbers, "");
            
        return count;
    }
}