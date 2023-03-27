import java.util.*;

class Solution {
    public int[] result = new int[2];
    
    public void recursion(int i, int j, int length, int[][] arr){
        if(isAllSame(i, j, length, arr)){
            if(arr[i][j] == 0) result[0]++;
            else result[1]++;
            return;
        }
        
        length /=2;
        
        recursion(i, j, length, arr);
        recursion(i+length, j, length, arr);
        recursion(i, j+length, length, arr);
        recursion(i+length, j+length, length, arr);
    }
    
    public boolean isAllSame(int i, int j, int length, int[][] arr){
        int temp = arr[i][j];
        
        for(int m = i; m<i+length; m++){
            for(int n = j; n<j+length; n++){
                if(arr[m][n] != temp) return false;
            }
        }
        return true;
    }
    
    public int[] solution(int[][] arr) {
        recursion(0, 0, arr.length, arr);
        return result;
        
    }
}