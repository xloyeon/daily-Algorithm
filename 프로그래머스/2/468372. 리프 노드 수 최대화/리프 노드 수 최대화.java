import java.util.*;

class Solution {
    public int result = 0;
    
    public void dfs(long cur, long dist, long split, long leaf, int dist_limit, int split_limit) {
        if(dist > dist_limit)
            return;
        
        result = (int) Math.max(leaf+cur, result);
        
        for(int child = 2; child<=3; child++){
            long nextSplit = split * child;
            
            if(nextSplit>split_limit)
                continue;
            
            long nextNodes = cur * child;
            
            long remain = dist_limit - dist;
            
            long nextCur = Math.min(nextNodes, remain);
            
            long nextLeaf = leaf + (nextNodes - nextCur);
            
            dfs(nextCur, dist + nextCur, nextSplit, nextLeaf, dist_limit, split_limit);
        }
    }
    public int solution(int dist_limit, int split_limit) {
        result = 1; //루트 노드의 자식 노드 1개는 가능하므로
        
        dfs(1, 1, 1, 0, dist_limit, split_limit);
        
        return result;
    }
}