import java.util.*;

class Solution {

    /*
     * 입력 값 : cacheSize(캐시 크기, 정수, 0<cacheSize<=30), cities(도시 이름 String 배열, 최대 ...)
     * 캐시 교체 알고리즘 : LRU(Least Recently Used)
     * cache hit일 경우 실행 시간 => 1, cache miss일 경우 실행 시간 => 5
     *
     * ex.
     * cacheSize = 3, cities = ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", ...]
     * 실행시간 = 50
     */

    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();

        int result = 0;

        for (String city : cities) {
            city = city.toUpperCase();

            //큐에 현재 요소 있는지 확인
            if (!q.isEmpty() && q.contains(city)) {
                //1. 있으면 제거하고 넣기
                q.remove(city);
                q.add(city);
                result += 1;
            } else {
                if(cacheSize == 0){
                    result += 5;
                } else if(q.size() == cacheSize) {
                    q.poll();
                    q.add(city);
                    result += 5;
                } else {
                    q.add(city);
                    result +=5;
                }
            }
        }

        return result;
    }
}