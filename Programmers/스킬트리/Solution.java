package Programmers.스킬트리;

import java.util.*;

public class Solution {
    public boolean isRightOrder(List<String> orderList, String[] skills){
        Queue<String> order = new LinkedList<>(orderList);

        for(String s : skills){
            if(order.isEmpty()) return true;

            if(order.contains(s) && !order.peek().equals(s))    //순서에 있지만 앞 순서가 존재하는 경우
                return false;
            else if(order.peek().equals(s))
                order.poll();
        }

        return true;
    }

    public int solution(String skill, String[] skill_trees) {
        List<String> orderList = Arrays.asList(skill.split(""));

        int result = 0;

        for(String tree : skill_trees){
            String[] skills = tree.split("");

            if(isRightOrder(orderList, skills)) result++;
        }

        return result;
    }
}
