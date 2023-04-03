import java.util.*;

class Solution {
    public String[] priority = {"*+-","*-+","+-*","+*-","-*+","-+*"};
    
    public long solution(String expression) {
        long max = 0L;
        
        //operation 분리해서 넣기
        List<String> operations = new ArrayList<>();
        
        for(int i = 0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c<'0' || c>'9'){
                operations.add(String.valueOf(c));
            }
        }
        
        String[] tempArr = expression.split("\\+|\\-|\\*");
        List<Long> nums = new ArrayList<>();
        
        for(String s : tempArr){
            nums.add(Long.parseLong(s));
        }
        
        for(String pri : priority){
            List<Long> temp = new ArrayList<>(nums);
            List<String> tempOper = new ArrayList<>(operations);
            
            for(char c : pri.toCharArray()){
                for(int i = 0; i < tempOper.size();){
                    String op = tempOper.get(i);
                    String s = String.valueOf(c);
                    if(!op.equals(s)) {i++; continue;}
                    if(s.equals("*")) temp.set(i, temp.get(i) * temp.get(i + 1));    
                    else if(s.equals("-")) temp.set(i, temp.get(i) - temp.get(i + 1)) ;
                    else if(s.equals("+")) temp.set(i, temp.get(i) + temp.get(i + 1)) ;

                    temp.remove(i + 1);
                    tempOper.remove(i);
                }
            }
        
            
            if(Math.abs(temp.get(0))>max) max = Math.abs(temp.get(0));       
        }
        
        return max;
        
    }
    
}