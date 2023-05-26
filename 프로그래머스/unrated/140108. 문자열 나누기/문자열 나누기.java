class Solution {
    public int solution(String s) {
        int equal = 0;
        int diff = 0;
        String x = "";
        int count = 0;
        
        for(int i = 0; i<s.length(); i++){
            String temp = s.substring(i, i+1);
            
            if(x.equals("")) {
                x = temp;
                equal = 1;
                continue;
            }
            
            if(temp.equals(x)) {
                equal++;
            }else {
                diff++;
            }
            
            if(equal == diff) {
                x = "";
                equal = 0;
                diff = 0;
                count++;
            }
        }
        
        if(equal>0 || diff>0) count++;
        return count;
    }
}