class Solution {
    
    public boolean isFit(int[][] lock, int[][] key, int n){
        int lenL = lock.length;
        int lenK = key.length;
        
        for(int i = 0; i<lenL-lenK+1; i++) {
            for(int j = 0; j<lenL-lenK+1; j++){
                
                int[][] temp = new int[lock.length][lock[0].length];
                
                for(int k = 0; k<lock.length; k++){
                    temp[k] = lock[k].clone();
                }
                
                //자물쇠에 키 값 더하기
                for(int k = 0; k<lenK; k++){
                    for(int l = 0; l<lenK; l++){
                        temp[i+k][j+l] += key[k][l];
                    }
                }
                
                boolean flag = true;
                
                for(int k = lenK-1; k<lenK+n-1; k++){
                    for(int l = lenK-1; l<lenK+n-1; l++){
                        if(temp[k][l] != 1){
                            flag = false;
                            break;
                        }
                    }
                    
                    if(!flag) break;
                }
                
                if(flag) return true;
                
            }
        }
        return false;
    }
    
    public int[][] rotate(int[][] arr){
        int[][] result = new int[arr.length][arr.length];
        
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[i].length; j++){
                result[i][j] = arr[j][arr.length-1-i];
            }
        }
        
        return result;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        //자물쇠의 홈과 열쇠의 돌기가 맞아야 함 -> 자물쇠에서 0인부분이 열쇠에서 무조건 다 1이 되어야 함
        //자물쇠 영역 벗어나면 영향 주지 않음 -> 확장시키고 맞는지 확인
        int lenL = lock.length;
        int lenK = key.length;
        
        int[][] rotated = key;

        for(int i = 0; i<4; i++){
            //새로운 자물쇠 배열
            int[][] map = new int[lenK*2 + lenL -2][lenK*2 + lenL -2];
            
            //실제 자물쇠 있는 자리에 채움
            for(int j = 0; j<lenL; j++){
                for(int k = 0; k<lenL; k++){
                    map[lenK+j-1][lenK+k-1] = lock[j][k];
                }
            }
            
            
            //이동하면서 맞는 자리 있는지 확인
            if(isFit(map, rotated, lock.length)) return true;
            
            //없으면 rotate
            rotated = rotate(rotated);
        }
        return false;
    }
}