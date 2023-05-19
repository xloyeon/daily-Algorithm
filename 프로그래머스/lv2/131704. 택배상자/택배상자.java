import java.util.*;

class Solution {
    public int solution(int[] order) {
        //컨테이너 벨트 -> 큐
        //보조 컨테이너 벨트 -> 스택
        //4, 3, 1, 2, 5
        //1,2,3을 보조에 둠
        //4번째 넣고
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        
        for(int i = 0; i<order.length; i++){
            q.add(i+1);
        }
        
        for(int i = 0; i<order.length;i++){
            if(!q.isEmpty() && q.peek() == order[i]){
                q.poll();
                count++;
                continue;
            }else if(!stack.isEmpty() && stack.peek() == order[i]){
                stack.pop();
                count++;
                continue;
            }else if(q.isEmpty()){
                break;
            }
            
            if(!q.isEmpty()){
                stack.add(q.poll());
                i--;
            }
        }
    
        
        return count;
    }
}