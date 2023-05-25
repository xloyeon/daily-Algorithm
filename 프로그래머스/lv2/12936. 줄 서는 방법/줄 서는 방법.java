import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        
        long[] factorials = new long[n+1]; //factorials[n-1] = n-1!
        
		List<Integer> nums = new ArrayList<>(); //사람들 숫자 1~n
        int[] result = new int[n];  //결과 배열
        
        factorials[0] = 1L;
        
		for(int i=1 ; i<=n ; i++) {
            nums.add(i);
			factorials[i] = factorials[i-1]*i;
		}
        
        k--;
        
        for(int i = n-1; i>=0; i--){
        	int temp = (int)(k/factorials[i]);
        	result[n-i-1] = nums.get(temp);
        	nums.remove(temp);
        	k %= factorials[i];
        }
        
        return result;
    }
}