import java.util.*;

class Solution {
    public List<String> nums = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    public List<String> expressions = Arrays.asList("zero", "one", "two", "three", "four", 
                                         "five", "six", "seven", "eight", "nine");
    public int solution(String s) {
        int start = 0;
        int end = 1;
        StringBuilder sb = new StringBuilder();
        
        while(end<=s.length()){
            if(nums.contains(s.substring(start, end))){
                sb.append(s.substring(start, end));
                start++;
                end++;
                continue;
            }
            
            if(expressions.contains(s.substring(start, end))){
                sb.append(expressions.indexOf(s.substring(start, end)));
                start = end;
                end = end+1;
            }else{
                end++;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}