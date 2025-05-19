class Solution {
    public int solution(int[] numbers) {
        // 0부터 9까지의 숫자를 합친 수에 찾은 수들을 제외
        
        int answer = 0;
        
        for(int i = 0; i<=9; i++){
            answer +=i;
        }
        
        for(int i = 0; i<numbers.length; i++){
            answer -= numbers[i];
        }
        
        return answer;
    }
}