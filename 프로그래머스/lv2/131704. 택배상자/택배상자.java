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
            if(!q.isEmpty() && q.peek() == order[i]){   //컨테이너벨트의 다음 순서가 실어야 하는 상자와 같으면
                q.poll();
                count++;
                continue;
            }else if(!stack.isEmpty() && stack.peek() == order[i]){ //보조 컨테이너벨트의 상단이 실어야 하는 상자와 같으면
                stack.pop();
                count++;
                continue;
            }else if(q.isEmpty()){  //보조에서만 꺼낼 수 있는데 순서가 맞지 않으므로 꺼낼 수 없음
                break;
            }
            
            //컨테이너벨트에서 꺼내야 하는 상자를 꺼내기 위해 앞의 상자들 전부 보조로 옮김
            if(!q.isEmpty()){
                stack.add(q.poll());
                i--;
            }
        }
    
        
        return count;
    }
}