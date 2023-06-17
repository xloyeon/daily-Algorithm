import java.util.*;

class Solution {
    public String[][] relation;
    public Set<String> set = new HashSet<>();
    
    public void dfs(int k, int max, StringBuilder sb){
        if(sb.length() == max){
            if(checkMinimal(sb)){
                System.out.println(sb.toString() +"이 최소성 검사 통과");
                if(checkUnique(sb)){
                    set.add(sb.toString());
                    System.out.println(sb.toString() +"이 유일성 검사 통과");
                }
            }
            return;
        }
        
        if(k>=relation[0].length) return;
        
        sb.append(k);
        dfs(k+1, max, sb);
        
        sb.deleteCharAt(sb.length()-1);
        dfs(k+1, max, sb);
    }
    
    public boolean checkUnique(StringBuilder sb){
        List<String> uniqueList = new ArrayList<>();
        for(int i = 0; i<relation.length; i++){
            String temp = "";
            
            for(int j = 0; j<sb.length(); j++){
                int idx = Integer.valueOf(sb.substring(j, j+1));
                temp += relation[i][idx];
            }
            
            if(uniqueList.contains(temp)) return false;
            uniqueList.add(temp);
        }
        return true;
    }
    
    public boolean checkMinimal(StringBuilder sb){
        String target = sb.toString();
        
        for(String s : set){
            boolean flag = true;
            
            for(int i = 0; i<s.length(); i++){
                if(!target.contains(String.valueOf(s.charAt(i)))){
                    flag = false;
                    break;
                }
            }
            
            if(flag)
                return false;
        }
        return true;
    }
    
    public int solution(String[][] relation) {
        this.relation = relation;
        
        for(int i = 1; i<=relation[0].length; i++){
            StringBuilder sb = new StringBuilder();
            System.out.println(i + "개 뽑아서 확인");
            dfs(0, i, sb);
        }
        return set.size();
    }
}