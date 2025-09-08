import java.util.*;

class Solution {
    public int[] aPicks; //a의 dice 저장
    public int[] bPicks; //b의 dice 저장
    public int[][] dice;
    public int result = 0;
    public int[] bestPicks;
    
    public void pickDice(int idx, int depth){
        if(depth == dice.length/2){
            //b의 dice 따로 저장
            int bIdx = 0;
            
            for(int i = 0; i<dice.length; i++){
                boolean flag = true;
                
                for(int j = 0; j<aPicks.length; j++){
                    if(aPicks[j] == i){
                        flag = false;
                        break;
                    }
                }
                
                if(flag)
                    bPicks[bIdx++] = i;
            }
            
            diffPicks();
            return;
        }
        
        for(int i = idx; i<dice.length; i++){
            aPicks[depth] = i;
            pickDice(i+1, depth+1);
        }
    }
    
    public void diffPicks(){
        List<Integer> aSums = sumDice(aPicks);
        List<Integer> bSums = sumDice(bPicks);
        
        Collections.sort(bSums);
        
        int winA = 0;
        
        for(int a : aSums){
            int count = binarySearch(bSums, a-1);
            winA += count;
        }
        
        if(winA>result){
            result= winA;
        
            for(int i = 0; i<aPicks.length; i++){
                bestPicks[i] = aPicks[i]+1;
            }
            
        }
    }
    
    public int binarySearch(List<Integer> searchList, int target){
        int left = 0;
        int right = searchList.size();
        
        while(left<right){
            int mid = (left+right)/2;
            
            if(searchList.get(mid)<=target){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        
        return left;
    }
    
    //선택한 주사위에서 구할 수 있는 모든 합 조합 구하기
    public List<Integer> sumDice(int[] picks){
        List<Integer> sumList = new ArrayList<>();
        sumList.add(0);
        
        for(int idx : picks){
            List<Integer> tempList = new ArrayList<>();
            
            for(int s : sumList){
                for(int p : dice[idx]){
                    tempList.add(s+p);
                }
            }
            sumList = tempList;
        }
        
        return sumList;
    }
    
    public int[] solution(int[][] dice) {  
        
        aPicks = new int[dice.length/2];
        bPicks = new int[dice.length/2];
        bestPicks = new int[dice.length/2];
        this.dice = dice;
        
        pickDice(0, 0);
        
        return bestPicks;
    }
}