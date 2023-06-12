import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        //한 번 쓴 곡괭이는 5개 연속 사용
        int sum = picks[0] + picks[1] + picks[2];
        int[][] groups = new int[minerals.length/5+1][3];
        int i, j;
        
        for(i= 0; i<minerals.length && sum>0; i++){
            if(minerals[i].equals("diamond")){
                groups[i/5][0] += 1;
                groups[i/5][1] += 5;
                groups[i/5][2] += 25;
            }else if(minerals[i].equals("iron")){
                groups[i/5][0] += 1;
                groups[i/5][1] += 1;
                groups[i/5][2] += 5;
            }else{
                groups[i/5][0] +=1;
                groups[i/5][1] += 1;
                groups[i/5][2] += 1;
            }
            
            if(i%5==4) sum--;
        }
       
        Arrays.sort(groups, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] < o2[2]) 
                    return 1;
                else 
                    return -1;
            }
        });
        
        
        int result = 0;
        
        for(i = 0, j = 0; i<groups.length; i++){
            while(j<3 && picks[j] == 0) j++;
            if(j == 3) break;
            
            picks[j]--;
            result += groups[i][j];
        }
        
            
        return result;
         
    }
}