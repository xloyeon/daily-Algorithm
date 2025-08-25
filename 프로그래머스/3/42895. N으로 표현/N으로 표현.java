import java.util.*;

class Solution {
    public int number;
    public List<HashSet<Integer>> list;
    
    public int dp(int n){
        for(int i = 1; i<9; i++) {
            
            for(int j = 1; j<i; j++){
                //i-j와 i로 만드는 수의 조합
                for(int x: list.get(i-j)) {
                    for(int y : list.get(j)){
                        list.get(i).add(x+y);
                        list.get(i).add(x-y);
                        list.get(i).add(x*y);
                        if(y!=0) list.get(i).add(x/y);
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int k = 1; k<=i; k++)
                sb.append(n);
            
            list.get(i).add(Integer.parseInt(sb.toString()));
            
            if(list.get(i).contains(number))
                return i;
        }
        
        return -1;
    }
    
    public int solution(int N, int number) {
        this.number = number;
        list = new ArrayList<>();
        
        for(int i = 0; i<=8; i++){
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N); //1개로 만들 수 있는 방법은 자기자신 뿐이므로 
    
        return dp(N);
    }
}