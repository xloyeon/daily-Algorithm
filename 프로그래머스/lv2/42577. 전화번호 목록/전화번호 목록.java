import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        //한 번호가 다른 번호의 접두어이려면 -> 길이순 정렬?
        Arrays.sort(phone_book);
        
        for(int i = 0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])) 
                    return false;
        }
        return true;
    }
}