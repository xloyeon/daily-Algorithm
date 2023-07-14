import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i<operations.length; i++){
            String[] temp = operations[i].split("\\s");
            
            if(temp[0].equals("I")){
                int target = Integer.parseInt(temp[1]);
                System.out.println("min 큐에 " + target + "넣기");
                min.add(target);
                System.out.println("max 큐에 " + target + "넣기");
                max.add(target);
            }else if(temp[1].equals("1") && !max.isEmpty()){
                int a = max.poll();
                System.out.println("max 큐에서 " + a + "빼기");
                min.remove(Integer.valueOf(a));
            }else if(temp[1].equals("-1") && !min.isEmpty()){
                int a = min.poll();
                System.out.println("min 큐에서 " + a + "빼기");
                max.remove(Integer.valueOf(a));
            }
        }
        
        if(min.isEmpty()){
            return new int[]{0, 0};
        }else{
            return new int[]{max.poll(), min.poll()};
        }
    }
}