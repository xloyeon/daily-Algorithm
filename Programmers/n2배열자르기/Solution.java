package Programmers.n2배열자르기;

import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {

        int size =Long.valueOf(right-left+1).intValue();
        int[] result = new int[size];

        int startLow = Long.valueOf(left/n).intValue();
        int endLow = Long.valueOf(right/n).intValue();
        int startCol = Long.valueOf(left%n).intValue();
        int endCol = Long.valueOf(right%n).intValue();

        int idx = 0;

        for(int i = startLow; i<=endLow; i++){
            for(int j = 0; j<n; j++){
                if(i==startLow && j<startCol) continue;

                if(j<=i) result[idx++] = i+1;
                else result[idx++] = j+1;

                if(i==endLow && j == endCol)
                    return result;

            }
        }

        return result;

    }
}