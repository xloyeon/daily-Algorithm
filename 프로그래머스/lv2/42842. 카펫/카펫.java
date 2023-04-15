class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 0;
        int y = 0;
        
        for(int i = 1; i<=brown/2; i++){
            x = i;
            y = (brown-2*(x+2))/2;
            
            if(x*y == yellow && x>=y) break;
            else if(x*y == yellow){
                int temp = x;
                x = y;
                y = temp;
                break;
            }
        }
        return new int[]{x+2, y+2};
    }
}