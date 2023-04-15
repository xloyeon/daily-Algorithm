import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        //몸무게 적은 사람이랑 몸무게 큰 사람 중에 태울 수 있는 사람 태워야 할 듯
        List<Integer> peopleList = new ArrayList<>();
        Arrays.sort(people);
        
        for(int person : people){
            peopleList.add(person);
        }
        
        int count = 0;
        
        while(peopleList.size()>0){
            int last = peopleList.size()-1;
            
            if(peopleList.size()!=1 && peopleList.get(last) <= limit-peopleList.get(0)){
                peopleList.remove(last);
                peopleList.remove(0);
            }else{
                peopleList.remove(last);
            }
            count++;
        }
        
        
        return count;
    }
}