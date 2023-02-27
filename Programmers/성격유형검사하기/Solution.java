package Programmers.성격유형검사하기;

import java.util.*;

public class Solution {
    static Map<String, Integer> score = new HashMap<String, Integer>();
    static int[] disagree = {3, 2, 1, 0};
    static int[] agree = {1, 2, 3};

    public String checkCharacter(){
        List<String> result = new ArrayList<>();

        checkNullCharacter();

        if(score.get("R")>=score.get("T")) result.add("R");
        else result.add("T");

        if(score.get("C")>=score.get("F")) result.add("C");
        else result.add("F");

        if(score.get("J") >= score.get("M")) result.add("J");
        else result.add("M");

        if(score.get("A") >= score.get("N")) result.add("A");
        else result.add("N");

        return String.join("", result);

    }

    public void checkNullCharacter(){
        String[] characters = {"R", "T", "C", "F", "J", "M", "A", "N"};

        for(String character : characters){
            if(!score.containsKey(character)){
                score.put(character, 0);
            }
        }
    }

    public String solution(String[] survey, int[] choices) {

        for(int i = 0; i<survey.length; i++){
            String type = "";
            int point = 0;

            if(choices[i]<=4){
                type = String.valueOf(survey[i].charAt(0));
                point = disagree[choices[i]-1];
            }else{
                type = String.valueOf(survey[i].charAt(1));
                point = agree[choices[i]-5];
            }

            if(!score.containsKey(type)){
                score.put(type, point);
            }else{
                score.put(type, score.get(type) + point);
            }
        }

        return checkCharacter();
    }
}
