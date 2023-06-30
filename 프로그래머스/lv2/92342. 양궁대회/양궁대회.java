import java.util.*;

class Game{
    int arrow;  //현재까지 사용한 화살 개수
    
    int idx;    //현재 확인할 과녁 점수
    
    int[] score;
    
    public Game(int arrow, int idx, int[] score){
        this.arrow = arrow;
        this.idx = idx;
        this.score = score;
    }
}

class Solution {
    public int max = 0;
    public List<int[]> wins = new ArrayList<>();
    
    public void getWinCases(int n, int[] info){
        Queue<Game> q = new LinkedList<>();
        
        q.add(new Game(0, 1, new int[11])); //라이언이 10점 0개 쏠 경우
        
        //라이언이 10점 어피치 +1개 쏠 경우
        int[] temp = new int[11];
            
        if(info[0]+1<=n){
            temp[0] = info[0]+1;
            q.add(new Game(temp[0], 1, temp));
        }
        q.add(new Game(0, 1, new int[11]));
        
        //반복
        while(!q.isEmpty()){
            Game game = q.poll();
            
            if(game.idx==10){
                game.score[10] += n- game.arrow;
                game.arrow = n;
            }
                
            if(game.arrow == n){
                int diff = check(info, game.score);
                if(diff>max){
                    wins = new ArrayList<>();
                    wins.add(game.score);
                    max = diff;
                }else if(diff == max && max != 0){
                    wins.add(game.score);
                }
                continue;
            }
            
            q.add(new Game(game.arrow, game.idx+1, game.score.clone()));   //0개 쏠 경우
            
            if(game.arrow + info[game.idx]+1 > n)
                continue;
            
            int[] clones = game.score.clone();
            clones[game.idx] = info[game.idx]+1;
            q.add(new Game(game.arrow+clones[game.idx], game.idx+1, clones)); //어피치보다 한 개 더 쏠 경우
        }
    }
    
    public int check(int[] info, int[] score){
        int lion = 0;
        int apeach = 0;
        
        for(int i = 0; i<info.length; i++){
            
            if(info[i] == score[i] && info[i] == 0)
                continue;
            
            if(info[i]>= score[i]){   //어피치가 점수 가져가는 경우
                apeach += (10-i);
            }else{
                lion += (10-i);
            }
        }
        
        if(lion>apeach)
            return lion - apeach;
        return 0;
    }
    
    public int[] checkArr(int[]a, int[] b) {

        for(int i = a.length-1; i >=0 ; i--) {
            if(a[i] == b[i]) continue;
            if(a[i] < b[i]) return b;
            break;
        }

        return a;
    }
    
    public int[] solution(int n, int[] info) {
        //라이언은 k점을 가져가려면 어피치가 k점을 쏜 개수보다 더 많은 개수를 k점에 쏴야만 함
        //라이언은 0, 또는 어피치 +1개
        
        getWinCases(n, info);
        
        if(wins.size() == 0){
            int[] lose = new int[]{-1};
            return lose;
        }
        
        
        if(wins.size() == 1){
            return wins.get(0);
        }
        
        int[] winner = wins.get(0);
        
        for(int i = 1; i<wins.size(); i++){
            winner = checkArr(winner, wins.get(i));
        }
        return winner;
        
    }
}