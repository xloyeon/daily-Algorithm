import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        int[] visited = new int[words.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(-1);
        
        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.println(temp);
            String word = "";
            
            if(temp == -1) 
                word = begin;
            else
                word = words[temp];
            
            if(word.equals(target)){
                return visited[temp];
            }
            
            for(int i = 0; i<words.length; i++){
                if(visited[i] == 0){
                    if(check(words[i], word)){
                        q.add(i);
                        
                        if(temp == -1){
                            visited[i] = 1;
                        } else{
                            visited[i] = visited[temp]+1;
                        }
                    }
                }
            }
                
        }
        return 0;
    }

    private boolean check(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int count = 0;
        
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}