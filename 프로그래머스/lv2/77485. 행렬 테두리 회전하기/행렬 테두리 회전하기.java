class Solution {
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] result = new int[queries.length];
        
        int[][] boxes = new int[rows][columns];
        
        int idx = 1;
        
        for(int i = 0; i< boxes.length; i++){
            for(int j = 0; j< boxes[0].length; j++){
                boxes[i][j] = idx++;
            }
        }
        
        //오른쪽 방향, 아래 방향, 왼쪽 방향, 위쪽 방향 4번의 움직임
        
        
        int before = 0;   //이전에 있었던 수를 저장
        int temp = 0;
        int min = 0;
        
        for(int i = 0; i<queries.length; i++){
            int[] query = queries[i];
            
            before = boxes[query[0]-1][query[1]-1];
            min = rows*columns;
            
            //오른쪽 방향 회전
            for(int j = query[1]; j <query[3]; j++){
                temp = boxes[query[0]-1][j];
                boxes[query[0]-1][j] = before;
                min = Math.min(min, before);
                before = temp;
            }
            
            for(int j = query[0]; j<query[2]; j++){
                temp = boxes[j][query[3]-1];
                boxes[j][query[3]-1] = before;
                min = Math.min(min, before);
                before = temp;
            }
            
            for(int j = query[3]; j >query[1]; j--){
                temp = boxes[query[2]-1][j-2];
                boxes[query[2]-1][j-2] = before;
                min = Math.min(min, before);
                before = temp;
            }
            
            for(int j = query[2]; j>query[0]; j--){
                temp = boxes[j-2][query[1]-1];
                boxes[j-2][query[1]-1] = before;
                min = Math.min(min, before);
                before = temp;
            }
            
            result[i] = min;
        }
        return result;
    }
}