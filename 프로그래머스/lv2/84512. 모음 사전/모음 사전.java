import java.util.*;

class Solution {
    public List<String> list = new ArrayList<>();
    public String[] alphabets = {"A", "E", "I", "O", "U"};
    
    public void dfs(int idx, String s){
        if(idx==5){
            return;
        }
        
        for(int i = 0; i<alphabets.length; i++){
            list.add(s + alphabets[i]);
            dfs(idx+1, s + alphabets[i]);
        }
    }
    
    public int solution(String word) {
        dfs(0, "");
        
        int count = 0;
        
        Collections.sort(list);
        
        for(String l : list){
            count++;
            if(l.equals(word))
                return count;
        }
        return count;
    }
}