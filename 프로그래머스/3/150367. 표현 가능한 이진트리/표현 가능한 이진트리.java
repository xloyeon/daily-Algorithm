import java.util.*;

class Solution {
    public String makePerfectBinaryTree(String num){
        //2의 제곱인지 확인
        long len = num.length();
        
        long tmp = 2;
        
        while(tmp -1 < len){    //루트 크기 빼고 생각해 줌
            tmp *= 2;
        }
        
        long filled = tmp - 1 - len;
        StringBuilder perfectNum = new StringBuilder();
        //filled 만큼 앞에 더하기
        for(int i = 0; i<filled; i++){
            perfectNum.append("0");
        }
        return perfectNum.toString() + num;
    }
    
    public boolean checkBinaryTree(String num){
        if(num.length() == 0) return true;
        
        int mid = num.length()/2;
        
        String left = num.substring(0, mid);
        String right = num.substring(mid+1);
        
        if(num.charAt(mid) == '0'){
            //왼쪽, 오른쪽 자식 노드들이 모두 0이어야 함
            return checkZeroTree(left) && checkZeroTree(right);
        }
        
        return checkBinaryTree(left) && checkBinaryTree(right);
    }
    
    public boolean checkZeroTree(String num){
        if(num.length() == 0) return true;
        
        int mid = num.length()/2;
        
        String left = num.substring(0, mid);
        String right = num.substring(mid+1);
        
        if(num.charAt(mid) == '1')
            return false;
        
        return checkZeroTree(left) && checkZeroTree(right);
    }
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i<numbers.length; i++){
            String num = Long.toBinaryString(numbers[i]);
            String perfectNum = makePerfectBinaryTree(num);
            
            int root = perfectNum.length()/2;
            
            if(perfectNum.charAt(root) == '0')
                continue;   //루트가 0이면 무조건 포화이진트리 불가
            
            String left = perfectNum.substring(0, root);    //왼쪽 자식 트리
            String right = perfectNum.substring(root+1);    //오른쪽 자식 트리
            
            if(checkBinaryTree(left) && checkBinaryTree(right))
                answer[i] = 1;
        }
        
        //포화 이진트리 -> 0이면 임시노드, 1이면 진짜 노드 
        //따라서 자식이 1이면 그 부모는 무조건 1이어야만 함
        
        return answer;
    }
}