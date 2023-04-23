import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int count = 0;
        
        //큐에 넣기
        Queue<Integer> q = new LinkedList<>();
        for(int priority : priorities){
            q.add(priority);
        }
        
        //우선순위 높은 수 있는지 확인할 리스트 만들기
        List<Integer> list = new ArrayList<>();
        Arrays.sort(priorities);
        
        for(int priority : priorities){
            list.add(priority);
        }
        
        
        
        while(true){
            if(location == 0 && list.get(list.size()-1) == q.peek()){
                count++;
                break;
            }else if(location == 0){
                int temp = q.poll();
                q.add(temp);
                location = q.size()-1;
            }else if(q.peek() == list.get(list.size()-1)){
                q.poll();
                list.remove(list.size()-1);
                location--;
                count++;
            }else{
                int temp = q.poll();
                q.add(temp);
                location--;
            }
        }
        
        return count;
    }
}