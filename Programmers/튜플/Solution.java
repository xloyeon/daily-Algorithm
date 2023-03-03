package Programmers.튜플;

import java.util.*;

public class Solution {
    static List<List<String>> expressions = new ArrayList<>();

    public int[] solution(String s) {
        String[] sets = s.split("}");

        for(int i = 0; i<sets.length; i++){
            StringTokenizer st = new StringTokenizer(sets[i], "{|,");
            List<String> expression = new ArrayList<>();

            while(st.hasMoreTokens()){
                expression.add(st.nextToken());
            }
            expressions.add(expression);
        }

        Collections.sort(expressions, (o1, o2) -> o1.size() - o2.size());

        List<Integer> resultList = new ArrayList<>();

        for(List<String> expression : expressions){
            for(String element : expression){
                Integer elementValue = Integer.parseInt(element);
                if(!resultList.contains(elementValue)){
                    resultList.add(elementValue);
                }
            }
        }

        int[] result = new int[resultList.size()];

        for(int i = 0; i<resultList.size(); i++){
            result[i] = resultList.get(i);
        }

        return result;
    }

}