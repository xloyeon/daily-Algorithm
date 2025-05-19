class Solution {
    /*
    ** n을 x로 나눈 나머지가 1이 되려면 ..
    ** (n-1)의 가장 작은 약수
    */
    
    public int solution(int n) {
        
        int k = n-1;
        int answer = k;
        
        //k의 가장 작은 약수를 구한다
        for(int i = 2; i<=k; i++){
            if(k%i == 0){
                answer = i;
                break;
            }
        } 
        return answer;
    }
}