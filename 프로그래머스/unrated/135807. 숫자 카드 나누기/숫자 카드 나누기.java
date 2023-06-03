import java.util.*;

class Solution {
    public int gcd(int a, int b){
        if(a%b == 0){
            return b;
        }
        return gcd(b, a%b);
    }
    
    public List<Integer> divisor(int a){
        List<Integer> result = new ArrayList<>();
        
        for(int i = a; i>=2; i--){
            if(a%i == 0) result.add(i);
        }
        return result;
    }
    
    public int calA(int[] arrayA, int[] arrayB){
        int before = arrayA[0]; //arrayA에서의 최대공약수
        
        for(int i = 0; i<arrayA.length; i++){
            before = gcd(before, arrayA[i]);
        }
        
        List<Integer> divisors = divisor(before);   //최대공약수의 약수 리스트
        
        for(int i = 0; i<divisors.size(); i++){
            int temp = divisors.get(i);
            
            for(int j = 0; j<arrayB.length; j++){
                if(arrayB[j]%temp==0) break;
                else if(j == arrayB.length-1) return temp;
            }
        }
        
        return 0;
    }
    
    
    public int solution(int[] arrayA, int[] arrayB) {
        //arrayA, arrayB를 정렬했을 때, 1의 경우 a의 최대공약수
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int beforeA = calA(arrayA, arrayB);
        int beforeB = calA(arrayB, arrayA);
        
        
        return Math.max(beforeA, beforeB);
    }
}