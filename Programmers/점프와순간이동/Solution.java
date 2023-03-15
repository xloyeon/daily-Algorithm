package Programmers.점프와순간이동;

import java.util.*;

/*
 ** 점프 - 한 번에 K칸 앞으로
 ** 순간이동 - 현재까지 온 거리 *2 (건전지 사용량 측면에서 더 효율적)
 ** 총 이동해야 하는 거리 - N
 ** 점프를 최소한으로 해서 이동할 것(이 때의 건전지 사용량)
 */

public class Solution {

    public int solution(int n) {
        int result = 0;

        while(n>1){
            if(n%2==0){
                n/=2;
            }else{
                result++;
                n--;
            }
        }
        result++;

        return result;
    }
}