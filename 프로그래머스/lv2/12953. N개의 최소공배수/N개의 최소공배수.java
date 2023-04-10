class Solution {
    public int gdc(int a, int b){
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        
        while(b>0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public int lcm(int a, int b){
        return a*b/gdc(a, b);
    }
    
    public int solution(int[] arr) {
        //2와 6의 공배수 -> 6
        //6과 8의 공배수 -> 24
        //14와 24의 공배수 -> 2^3*3*7 = 168
        int cur = arr[0];
        
        for(int i = 1; i<arr.length; i++){
            cur= lcm(cur, arr[i]);
        }
        
        return cur;
    }
}