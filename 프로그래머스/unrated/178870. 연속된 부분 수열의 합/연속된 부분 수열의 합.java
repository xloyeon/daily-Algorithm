import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        //dp? 투포인터?
        int sum = sequence[0];  //현재 부분수열 합
        
        int start = 0;  //시작 포인터
        int end = 0;    //끝 포인터
        int count = Integer.MAX_VALUE;
        int[] result = {0, Integer.MAX_VALUE};
        
        while(true){
            if(sum == k){
                //현재 count 값과 비교
                if(end-start+1<count){
                    count = end-start+1;
                    result[0] = start;
                    result[1] = end;
                }else if(end-start+1 == count && start<result[0]){
                    result[0] = start;
                    result[1] = end;
                }
            }
            
            //둘 다 끝에 도달하면 끝내기
            if(start == sequence.length && end == sequence.length) break;
            
            //작으면 sum 증가, 크면 sum 감소
            if(sum<=k && end<sequence.length){
                end++;
                if(end<sequence.length) sum+= sequence[end];
            }else{
                if(start<sequence.length) sum-=sequence[start];
                start++;
            }
            
        }
        
        
        return result;
    }
}