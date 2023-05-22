import java.util.*;

class Solution {
    public String[][] map;
    public int[][] visited;
    public int[] moveX = {-1, 1, 0, 0};
    public int[] moveY = {0, 0, 1, -1};
    
    //a가 x, b가 y좌표
    public int bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        visited[b][a] = 1;
        int count = Integer.valueOf(map[b][a]);
        
        while(!q.isEmpty()){
            int[] temp = q.poll();
            
            for(int i = 0; i<4; i++){
                int movedX = temp[0] + moveX[i];
                int movedY = temp[1] + moveY[i];
                
                if(movedX>=0 && movedX<map[0].length && movedY>=0 && movedY<map.length){
                    if(!map[movedY][movedX].equals("X") && visited[movedY][movedX] == 0){
                        visited[movedY][movedX] = 1;
                        System.out.println(map[movedY][movedX]);
                        count+= Integer.valueOf(map[movedY][movedX]);
                        System.out.println(count);
                        q.add(new int[]{movedX, movedY});
                    }
                }
            }
        }
        
        return count;
    }
    
    
    public int[] solution(String[] maps) {
        List<Integer> resultList = new ArrayList<>();
        
        map = new String[maps.length][maps[0].length()];
        visited = new int[maps.length][maps[0].length()];
        
        for(int i = 0; i<maps.length; i++){
            map[i] = maps[i].split("");
        }
        
        for(int i = 0; i<map.length; i++){
            for(int j = 0; j<map[0].length; j++){
                if(!map[i][j].equals("X") && visited[i][j] == 0) {
                    resultList.add(bfs(j, i));
                }
            }
        }
        
        if(resultList.size() == 0) resultList.add(-1);
        
        int[] result = new int[resultList.size()];
        
        for(int i = 0; i<resultList.size(); i++){
            result[i] = resultList.get(i);
        }
        
        Arrays.sort(result);
        return result;
        
        
    }
}