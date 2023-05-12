import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        //가장 큰 수가 되려면 앞의 수가 큰 수여야 함
        //306
        //3061
        //3062
        String[] nums = new String[numbers.length];
        
        for(int i = 0; i<numbers.length; i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        
        
        Arrays.sort(nums, new Comparator<String>(){
            
            public int compare(String o1, String o2){
                if(o1.charAt(0) == o2.charAt(0)){
                    if(o1.length() == o2.length()){
                        return o1.compareTo(o2);
                    }
                    return (o1+o2).compareTo(o2+o1);
                }
                return o1.compareTo(o2);
            }
        });
        
        String result = "";
        
        for(int i = nums.length-1; i>=0; i--){
            result += nums[i];
        }
        
        
        if(result.charAt(0) == '0') return "0";
        return result;
    }
}