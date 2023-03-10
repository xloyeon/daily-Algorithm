package Programmers.영어끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Stack<String> answers = new Stack<>();

        int idx= n;

        for(String word : words){
            if(answers.size()!=0){
                String last = answers.peek();
                char end = last.charAt(last.length()-1);
                char start = word.charAt(0);
                if((end !=start) || answers.contains(word)){
                    return new int[]{idx%n+1, idx/n};
                }
            }
            idx++;
            answers.add(word);
        }

        return new int[]{0, 0};
    }
}