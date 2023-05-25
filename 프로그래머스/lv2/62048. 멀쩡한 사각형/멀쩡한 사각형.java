import java.math.*;

class Solution {
    public long solution(int w, int h) {
        //전체 박스 개수
        long boxes = 0L;
        
        //현재까지의 h
        for(int i = 1; i<w; i++){
            long n = (long)((double)h * i)/w;
            boxes+=n;
        }
        return boxes*2;
    }
}