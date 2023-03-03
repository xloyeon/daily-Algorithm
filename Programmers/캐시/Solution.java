package Programmers.캐시;

import java.util.*;

public class Solution {
    static int result = 0;
    static Queue<String> cache = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        // 1번째 - 5 *10 = 50
        // 2번째 - 5 + 5 + 5(제주, 판교, 서울) + 1 + 1 + 1 + 1 + 1 + 1(이후로 같음) = 21
        // 3번째 - 5 + 5 + 5 + 5 + 5 + 5 + 5 + 5+ 5 + 5 + 5 + 5 = 60
        // 4번째 - 5 + 5 + 5 + 5 + 5 + 5 + 1 + 5 + 5 + 5 + 5 + 1 =  52
        // 5번째 - 5 + 5 + 5 + 1 = 16(대소문자 구분 없음)
        //6번째 - 5 + 5 + 5 + 5 + 5 = 25

        int idx = 1;

        for(String city : cities){
            //대소문자 구분없이 하기 위해 소문자로만 생각
            city = city.toLowerCase();

            if(cacheSize == 0){
                result +=5;
                continue;
            }

            if(cache.contains(city)){   //캐시에 현재 도시가 있으면
                cache.remove(city);
                cache.add(city);
                result++;
            }else if(cache.size()<cacheSize){   //캐시에 현재 도시가 없고 캐시가 안 차 있으면
                cache.add(city);
                result+=5;
            }else {                     //캐시에 현재 도시가 없고 캐시가 다 차 있으면
                cache.poll();
                cache.add(city);
                result+=5;
            }
        }
        return result;
    }
}