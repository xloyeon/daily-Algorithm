import java.util.*;

class Solution {
    public int mod(int[] arr, int k){
        int result = 0;
        
        for(int i = 0; i<arr.length; i++){
            result += arr[i]%k;
        }
        return result;
    }
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col-1] == o2[col-1])
                return o2[0]-o1[0];
            return o1[col-1]-o2[col-1];
        });
        
        int before = mod(data[row_begin-1], row_begin);
        
        for(int i = row_begin; i<row_end; i++){
            int temp = mod(data[i], i+1);
            before = before ^temp;
        }
        
        return before;
    }
}