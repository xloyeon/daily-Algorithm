class Solution {
    int[] map;
    int count = 0;
    
    public void dfs(int k){
        //모든 줄에 다 둘 수 있으면
        if(k == map.length){
            count++;
            return;
        }
        
        for(int i = 0; i<map.length; i++){
            if(check(k, i)){
                map[k] = i;
                dfs(k+1);
            }
        }
    }
    
    public boolean check(int k, int a){
        for(int i = 0; i<k; i++){
            //세로 확인
            if(map[i] == a) return false;    
            
            //대각선 확인
            if(Math.abs(k-i) == Math.abs(a-map[i]))
                return false;
        }
        
        return true;
    }
    
    public int solution(int n) {
        //k번째 줄에 두고 .. 안되면 돌아옴
        map = new int[n];
        
        dfs(0);
        return count;
    }
}