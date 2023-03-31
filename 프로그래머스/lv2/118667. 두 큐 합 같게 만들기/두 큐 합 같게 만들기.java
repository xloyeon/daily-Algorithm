import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        //두 가지 선택지가 있음 ->  1에서 추출해서 2에 넣기 or 2에서 추출해서 1에 넣기
        //(3,2,7,2) = 14, (4,6,5,1) = 16 -> 2에서 뽑아서 1에 넣기
        //(3,2,7,2,4) = 18, (6,5,1) = 12 -> 1에서 뽑아서 2에 넣기
        //(2,7,2,4) = 15, (6,5,1,3) = 15
        int count = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i : queue1) q1.add(i);
        for(int i : queue2) q2.add(i);
        
        int limit = q1.size()*3;
            
        long sum1 = sum(q1);
        long sum2 = sum(q2);
        
        while(sum1 != sum2){
            
            if(sum1>sum2){
                int pop = q1.poll();
                q2.add(pop);
                sum1 -= pop;
                sum2 += pop;
            }else{
                int pop = q2.poll();
                q1.add(pop);
                sum2-=pop;
                sum1+=pop;
            }
            
            count++;
        
            if(count==limit) return -1;
            if(q1.size() == 0 || q2.size() == 0) return -1;
        }
        return count;
    }
              
//     public boolean check(List<Integer> q, List<Integer> temp){
//         if(q.size()!= temp.size()) return false;
        
//         List<Integer> checkList = new ArrayList<>(temp);
        
//         for(Integer i : q){
//             if(checkList.contains(i)){
//                 checkList.remove(i);
//             }else{
//                 return false;
//             }
//         }
        
//         return true;
//     }
    
    public long sum(Queue<Integer> q){
        long sum = 0L;
        
        for(Integer i : q){
            sum += i;
        }
        
        return sum;
    }
}