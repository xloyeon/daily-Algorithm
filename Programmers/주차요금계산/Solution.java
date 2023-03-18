package Programmers.주차요금계산;

import java.util.*;

public class Solution {
    final int LAST = 23*60+59;

    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> map = new HashMap<>(); //총 시간 저장
        Map<String, Integer> parkingNums = new HashMap<>();

        for(String record : records){
            String[] carRecord = record.split(" ");
            String[] times = carRecord[0].split(":");
            int time = Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);

            if(map.containsKey(carRecord[1])){
                parkingNums.put(carRecord[1], parkingNums.get(carRecord[1])+1);
                if(parkingNums.get(carRecord[1])%2==0){ //입차 횟수가 짝수면, 현재 out
                    map.put(carRecord[1], map.get(carRecord[1])+time);
                }else{
                    map.put(carRecord[1], map.get(carRecord[1])-time);
                }
            }else{
                parkingNums.put(carRecord[1], 1);
                map.put(carRecord[1], -time);
            }
        }

        for(String car : parkingNums.keySet()){
            if(parkingNums.get(car)%2!=0)
                map.put(car, map.get(car)+LAST);
        }

        List<String> cars = new ArrayList<>(map.keySet());
        int[] result = new int[cars.size()];
        Collections.sort(cars);

        int index = 0;
        for(String car : cars){
            int time = map.get(car);

            if(time>fees[0]){
                time -= fees[0];

                if(time%fees[2] == 0){
                    time /=fees[2];
                }else{
                    time/=fees[2];
                    time++;
                }
                result[index] = fees[1] + time*fees[3];
            }else{
                result[index] = fees[1];
            }
            index++;
        }
        return result;

    }
}