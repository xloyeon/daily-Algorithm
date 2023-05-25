import java.math.*;

class Solution {
    public long solution(int w, int h) {
        //전체 박스 개수
        long boxes = 0L;
        
        for(int i = 1; i<w; i++){
            //h/w는 일차함수 기울기
            //i를 곱하면 y값 구함 -> y값보다 작은 개수만큼 정사각형
            long n = (long)((double)h * i)/w;
            boxes+=n;
        }
        return boxes*2;
    }
}