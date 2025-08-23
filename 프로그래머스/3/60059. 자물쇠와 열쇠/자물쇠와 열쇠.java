class Solution {

    public boolean isUnLock(int[][] map, int[][] key, int n){
        int lenM = map.length;
        int lenK = key.length;
        
        //키가 움직일 수 있는 최대 좌표는 키길이 + 자물쇠길이
        for(int i = 0; i<lenM-lenK+1; i++){
            for(int j = 0; j<lenM-lenK+1; j++){
                
                int[][] target = new int[map.length][map[0].length];
                
                //복사하기
                for(int k = 0; k<map.length; k++){
                    target[k] = map[k].clone();
                }
                
                //자물쇠에 키 합치기
                for(int k = 0; k<lenK; k++){
                    for(int l = 0; l<lenK; l++){
                        target[i+k][j+l] += key[k][l];
                    }
                }
                
                boolean flag = false;
                
                for(int k = lenK-1; k<lenK+n-1; k++){
                    for(int l = lenK-1; l<lenK+n-1; l++){
                        if(target[k][l] != 1){
                            flag = false;
                            break;
                        }
                        
                        flag = true;
                    }
                    
                    if(!flag)
                        break;
                }
                if(flag)
                    return true;
            }
        }
        
        return false;
    }
    
    public int[][] rotate(int[][] target){
        int[][] result = new int[target.length][target[0].length];
        
        for(int i = 0; i<target.length; i++){
            for(int j = 0; j<target[0].length; j++){
                result[i][j] = target[j][target.length -i-1];
            }
        }    
        return result;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        // 키와 자물쇠가 맞으려면? 
        // 1. 키의 특정 좌표를 lock의 한 부분에 맞춘다
        // 2. 돌리면서 + 이동하면서 자물쇠 영역의 좌표값들이 채워졌는지 확인한다
        // 3. 혹시 부딪히는 부분(좌표값 더 했을 때 1을 초과)이 있으면 실패
        
        for(int i = 0; i<4; i++){
            // 열쇠를 움직이면서 모든 값이 1이 되는 곳을 찾기 위해서 열쇠 + 자물쇠 + 열쇠 길이의 새 map이 필요
            // 자물쇠를 새 map의 중간에 놓는다
            int expanded = key.length*2 + lock.length;
            int[][] map = new int[expanded][expanded];
            
            for(int j = 0; j<lock.length; j++){
                for(int k = 0; k<lock.length; k++){
                    map[key.length+j-1][key.length+k-1] = lock[j][k];
                }
            }
            
            
            if(isUnLock(map, key, lock.length))
                return true;
            
            key = rotate(key);
        }
        
        return false;
    }
}