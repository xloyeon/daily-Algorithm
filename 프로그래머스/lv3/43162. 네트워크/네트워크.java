import java.util.*;

class Solution {
    public int count;
    public int[] networks;
    
    public void union(int a, int b){
        a = find(a);
        b = find(b);
        
        if(a != b){
            networks[a] = b;
            count--;
        }
    }
    
    public int find(int a){
        if(networks[a] == a){
            return a;
        }
        return find(networks[a]);
    }
    
    public int solution(int n, int[][] computers) {
        count = n;
        networks = new int[n];
        
        for(int i = 0; i<networks.length; i++)
            networks[i] = i;
        
        for(int i=0; i<computers.length; i++){
            for(int j = 0; j<computers[0].length; j++){
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        return count;
    }
    
}