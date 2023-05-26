import java.util.*;

class Solution {
    public String[] words = new String[]{"A", "E", "I", "O", "U"};
    public List<String> dict = new ArrayList<>();
    
    public void dfs(int idx, String s){
        if(idx > 5) return;
        
        if(!dict.contains(s)) dict.add(s);
        
        for(int i = 0; i<words.length; i++){
            dfs(idx+1, s+words[i]);
        }
        
    }
    
    public int solution(String word) {
        
        dfs(0, "");
        
        return dict.indexOf(word);
    }
}