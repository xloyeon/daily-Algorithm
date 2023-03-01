package Programmers.개인정보수집유효기간;

import java.util.*;

public class Solution {
    static int[] current = new int[3];
    static List<String[]> targets = new ArrayList<>();
    static Map<String, Integer> types = new HashMap<>();
    static List<Integer[]> limits = new ArrayList<>();
    static List<Integer> result = new ArrayList<>();

    public static void checkLimit(){
        for(String[] target : targets){
            String type = target[3];
            int term = types.get(type);

            int year = Integer.parseInt(target[0]);
            int month = Integer.parseInt(target[1]);
            int day = Integer.parseInt(target[2]);

            month+= term;
            if(day == 1){
                day = 28;
                month --;
            }else{
                day--;
            }

            while(month>12){
                month -= 12;
                year++;
            }

            limits.add(new Integer[]{year, month, day});
        }
    }

    public static void putResult(){
        for(int i = 0; i<limits.size(); i++){
            Integer[] limit = limits.get(i);


            // result.add(limit[0].intValue());
            // result.add(limit[1].intValue());
            // result.add(limit[2].intValue());

            if(limit[0]< current[0]){
                result.add(i+1);
                continue;
            }else if(limit[0] == current[0] && limit[1]<current[1]){
                result.add(i+1);
                continue;
            }else if(limit[0] == current[0] && limit[1] ==current[1] && limit[2]<current[2]){
                result.add(i+1);
                continue;
            }

        }
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        //현재 날짜를 연도, 월, 일로 분리해 배열에 저장
        String[] currentString = today.split("\\.");
        for(int i = 0; i<3; i++){
            current[i] = Integer.parseInt(currentString[i]);
        }


        //약관의 종류와 기간을 map에 저장
        for(String term : terms){
            String[] temp = term.split(" ");
            types.put(temp[0], Integer.parseInt(temp[1]));
        }


        for(int i = 0; i<privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            StringTokenizer st = new StringTokenizer(temp[0], ".");
            String[] target = new String[4];

            for(int j = 0; j<3; j++){
                target[j] = st.nextToken();
            }
            target[3] = temp[1];
            targets.add(target);
        }

        checkLimit();
        putResult();

        System.out.println(result.toString());

        int[] resultArr = new int[result.size()];

        for(int i = 0; i<result.size(); i++){
            resultArr[i] = result.get(i).intValue();
        }
        return resultArr;
    }
}
