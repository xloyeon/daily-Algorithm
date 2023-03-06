package Programmers.이진변환반복하기;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] result = new int[2];
        List<String> splits = new ArrayList<>(Arrays.asList(s.split("")));


        while(!(splits.size()==1 && splits.get(0).equals("1"))){

            while(splits.remove("0"))
                result[1]++;


            int x = s.length();

            s= Integer.toBinaryString(x);
            result[0]++;
        }

        return result;
    }
}