package Programmers.압축;

import java.util.*;

public class Solution {

    public int[] solution(String msg) {
        List<String> dict = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        //사전 초기화
        for(char c = 'a'; c<='z'; c++){
            dict.add(String.valueOf(c));
        }


        StringBuilder w = new StringBuilder(msg.toLowerCase());


        String find = "";

        while(w.length()>0){   //모든 글자를 처리할 때까지 반복
            for(int i = w.length(); i>0; i--){ //사전의 최대의 값까지만 가능
                if(dict.contains(w.substring(0, i))){
                    find = w.substring(0, i);
                    w.delete(0, i);
                    break;
                }
            }

            resultList.add(dict.indexOf(find)+1);

            if(w.length()>0){
                String temp = find + w.substring(0, 1);
                if(!dict.contains(temp))
                    dict.add(temp);
            }

        }

        int[] result = new int[resultList.size()];

        for(int i = 0; i<resultList.size(); i++){
            result[i] = resultList.get(i).intValue();
        }
        return result;

    }
}
