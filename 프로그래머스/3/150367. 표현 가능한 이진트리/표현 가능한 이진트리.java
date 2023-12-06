import java.util.*;

class Solution {
    
    //2의 제곱인지 확인하고 아니면 차이를 리턴
    public long powerOfTwo(long num){
        long powered = 2;
        
        while(powered-1 <num){
            powered = powered*2;
        }
        return powered-1-num;
    }
    
    public String fillBinaryTree(String binaryString) {
        long power = powerOfTwo(binaryString.length());
            
        if(power != 0){   //2의 제곱이 아니면 0을 앞에 차이만큼 붙여줌
                
            StringBuffer sb = new StringBuffer();
                
            for(int j = 0; j<power; j++){
                sb.append("0");
            }
            binaryString = sb.toString() + binaryString;
        }
        return binaryString;
    }
    
    public boolean checkBinary(String binaryString){
        if(binaryString.length() == 0) return true;
        
        int mid = binaryString.length()/2;
        
        String left = binaryString.substring(0, mid);
        String right = binaryString.substring(mid+1);
        
        if(binaryString.charAt(mid) =='0')
            return isAllZero(right) && isAllZero(left);
       
        return checkBinary(left) && checkBinary(right);
    }
    
    private boolean isAllZero(String binaryString){
        if(binaryString.length() == 0) return true;
        
        int mid = binaryString.length()/2;
        
        String left = binaryString.substring(0, mid);
        String right = binaryString.substring(mid+1);
        
        if(binaryString.charAt(mid) =='1')
            return false;
        
        return isAllZero(left) && isAllZero(right);
    }
    
    public int[] solution(long[] numbers) {
        //트리 이진 포화면 -> 1,3,7,15, ..(2의 제곱 -1)
        //주어진 수를 2진수로 변환 : 7-> 111 -
        //42-> 101010 -> 앞쪽에 더미노드 하나 더 있는것:0101010 
        //5 -> 101
        //63 -> 0111111  
        //111 -> 0101111
        //95 -> 1010101
        //자식이 1이면 그 루트들이 모두 1이어야 함
        int[] result = new int[numbers.length]; //결과 값 담을 배열
        
        for(int i = 0; i<numbers.length; i++) {
            String binaryString = Long.toBinaryString(numbers[i]);
            String filled = fillBinaryTree(binaryString);
            
            int mid = filled.length()/2;
            
            if(filled.charAt(mid) == '0') {
                continue;
            }
                
            
            String left = filled.substring(0, mid);
            String right = filled.substring(mid+1); 
            
            if(checkBinary(left) && checkBinary(right))
                result[i] = 1;
            
        }
        
        return result;
    }
}