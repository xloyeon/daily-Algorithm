import java.util.*;

class Solution {
    
    public long toDecimal(String binarys){
        long result = 0L;
        
        for(int i = 0; i<binarys.length(); i++){
            int idx = binarys.length()-i-1;
            String s = binarys.substring(idx, idx+1);
            if(s.equals("1")){
                result += Long.parseLong(s)*Math.pow(2, i);
            }
        }
        return result;
    }
    
    public long[] solution(long[] numbers) {
        //1로만 있으면 -> 다음 큰 수는 현재 첫자리만 0인 것
        //0이 있으면 -> 0의 마지막이 1로 바뀐 것
        long[] result = new long[numbers.length];
        int position = 0;
        
        for(long number : numbers){
            
            String binarys = Long.toBinaryString(number);  
            
            //짝수일 때
            if(number%2==0){
                result[position++] = toDecimal(binarys.substring(0, binarys.length()-1) + "1");
                continue;
            }
            
            //홀수일 때  
            
            if(!binarys.contains("0")){  //1로만 구성된 숫자면
                binarys = "10" + binarys.substring(1, binarys.length());
            }else{
                int idx = binarys.lastIndexOf("0");
                binarys = binarys.substring(0, idx) + "10" + binarys.substring(idx+2, binarys.length());
            }
            
            result[position++] = toDecimal(binarys);
        }
        
        return result;
    }
}