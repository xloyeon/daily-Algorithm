class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        //행*열
        
        int[][] result = new int[arr1.length][arr2[0].length];
    
        for(int i = 0; i<result.length; i++){
            for(int j = 0; j<result[0].length; j++){
                int temp = 0;
                
                for(int k = 0; k<arr1[0].length; k++){
                    temp += arr1[i][k]* arr2[k][j];
                }
                result[i][j] = temp;
            }
        }
        return result;
    }
}