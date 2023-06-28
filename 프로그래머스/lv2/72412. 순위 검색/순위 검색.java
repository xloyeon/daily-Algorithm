import java.util.*;

class Solution {
    String[] people;
    String[] temp;
    HashMap<String, List<Integer>> map = new HashMap<>();
    
    public void dfs(int k){
        if(k == 4){
            String s = String.join("", temp);
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(Integer.valueOf(people[k]));
            return;
        }
        
        temp[k] = people[k];
        dfs(k+1);
        temp[k] = "-";
        dfs(k+1);
    }
    
    public int binarySearch(List<Integer> scoreList, int minScore){
        int left = 0;
        int right = scoreList.size()-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(scoreList.get(mid)<minScore){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return scoreList.size() - left;
    }
    
    public int[] solution(String[] info, String[] query) {
        String[][] questions = new String[query.length][5]; //쿼리 정보
        int[] result = new int[query.length];
        
        for(int i = 0; i<info.length; i++){
            temp = new String[4];
            people = info[i].split(" ");
            dfs(0);
        }
        
        for(String key : map.keySet())
            Collections.sort(map.get(key));
        
        for(int i = 0; i<query.length; i++){
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");   //조건들, 점수
            int minScore = Integer.parseInt(q[1]);
            
            if(map.containsKey(q[0])){
                List<Integer> scoreList = map.get(q[0]);
                result[i] = binarySearch(scoreList, minScore);
            }else
                result[i] = 0;
        }
        
        return result;
    }
}