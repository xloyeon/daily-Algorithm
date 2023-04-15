import java.util.*;

class Solution {
    public int solution(int n) {
        //1로만 이루어진 이진수 -> 1 + 0 + (1이 현재 이진수의 자릿수 -1)
        //0이 있는 이진수 -> 01이 가장 먼저 등장하는 곳을 뒤집고 -> 그 뒷자리를 가장 작은 수로 바꾸기
        //0이 있는 이진수 중 01 등장하지 않는 수 -> 
        int count = Integer.bitCount(n);
        
        while(true){
            n++;
            if(Integer.bitCount(n) == count) return n;
        }
    }
    
}