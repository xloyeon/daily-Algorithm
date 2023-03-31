import java.util.*;

class Solution {
    public int n = 0;
    public Map<String, Integer> map = new HashMap<>();  //course 개수별로 확인하기 위한 map
    public List<String> selected = new ArrayList<>();
    
    public void countSet(String order, int pos){
        if(pos == 0) {
            StringBuilder sb = new StringBuilder();
            
            for(String s : selected)
                sb.append(s);
            
            if(map.containsKey(sb.toString()))
                map.put(sb.toString(), map.get(sb.toString())+1);
            else
                map.put(sb.toString(), 1);
            return;
        }
        
        
        for(int i = 0; i<order.length(); i++){
            selected.add(order.substring(i, i+1));
            countSet(order.substring(i+1), pos-1);
            selected.remove(selected.size()-1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        List<String> resultList = new ArrayList<>();
        
        for(int num : course){
            //num 개수에 맞는 조합 만들기
            map = new HashMap<>();
            
            for(String order : orders){
                if(order.length()>=num){
                    char[] c = order.toCharArray();
                    Arrays.sort(c);
                    order = new String(c);
                    countSet(order, num);
                }
            }
            
            Set<Map.Entry<String, Integer>> sets = map.entrySet();
            
            int max = 1;
            List<String> maxCourse = new ArrayList<>();
            
            for(Map.Entry<String, Integer> entry : sets){
                
                if(entry.getValue()>max){
                    maxCourse = new ArrayList<>();
                    maxCourse.add(entry.getKey());
                    max = entry.getValue();
                }else if(entry.getValue() == max){  //max는 여러 개 가능
                    maxCourse.add(entry.getKey());
                }
            }
            
            if(max>=2){ //2번 이상 주문 못 받으면 코스로 만들지 않음
                for(String s : maxCourse){
                    resultList.add(s);
                }
            }
        }
        
        
        Collections.sort(resultList);
    
        String[] result = new String[resultList.size()];
        
        for(int i = 0; i<result.length; i++){
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}