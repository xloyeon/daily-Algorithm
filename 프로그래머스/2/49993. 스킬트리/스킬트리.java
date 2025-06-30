import java.util.*;

class Solution {
    
    public boolean isPossibleSkillTree(int[] indexes){
        boolean finder = false;  //후행skill이 있을 경우 true
        
        for(int i = indexes.length-1; i>=0; i--){
            if(indexes[i] !=-1)    //선행 skill이 필요한 skill이면 다음에 찾도록 함
                finder = true;
            
            if(finder == true && indexes[i] == -1)
                return false;
            
            if(finder == true && i!=0){
                if(indexes[i]<indexes[i-1])
                    return false;
            }
        }
        return true;
    }
    
    
    public int solution(String skill, String[] skill_trees) {
        int result = 0;
        
        //후 원소가 먼저 나오면 무조건 탈락 >> 뒤 부터 보는게 가장 좋나?
        
        String[] sArr = skill.split("");
        /*
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : sArr){
            map.put(s, -1);
        }
        */
        
        for(String tree : skill_trees){
            List<String> target = Arrays.asList(tree.split(""));
            int[] indexes = new int[sArr.length];
            
            for(int i = 0; i<sArr.length; i++){
                indexes[i] = target.indexOf(sArr[i]);
            }
            //map에서 하나씩 찾아서 index value로 넣으려고 했는데 .. stream 쓰기 귀찮아서 ..
            
            if(isPossibleSkillTree(indexes))
                result++;
        }
        
        return result;
    }
}