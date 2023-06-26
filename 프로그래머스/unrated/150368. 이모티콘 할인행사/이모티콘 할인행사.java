import java.util.*;

class Solution {
    public int[] rate = {10, 20, 30, 40};   //적용 가능 할인율
    public int[][] users;
    public int[] emoticons;
    public int[] discounts;
    public List<int[]> resultList = new ArrayList<>();  //결과 리스트
    
    public void dfs(int idx){
        if(idx == emoticons.length){
            checkPurchase();
            return;
        }
        
        for(int i = 0; i<rate.length; i++){
            discounts[idx] = rate[i];
            dfs(idx+1);
        }
    }
    
    public void checkPurchase(){
        int count = 0;  //이모티콘 플러스 가입 고객
        int total = 0;  //이모티콘 판매액
        
        for(int[] user : users){
            int purchase = 0;   //사용자의 구매금액
            
            for(int i = 0; i<discounts.length; i++){
                //할인율이 사용자가 구매하려는 할인율 이상이면 구매
                if(discounts[i] >= user[0]){
                    purchase += emoticons[i]*(100-discounts[i])/100;
                }
            }
            
            if(purchase >= user[1])
                count++;
            else
                total += purchase;
        }
        
        resultList.add(new int[]{count, total});
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        
        discounts = new int[emoticons.length];
        dfs(0);
        Collections.sort(resultList, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o2[1]-o1[1];
            return o2[0]-o1[0];
        });
        
        return resultList.get(0);
    }
}