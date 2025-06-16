import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        HashMap<String, String> names = new HashMap<>();
        List<String[]> resultList = new ArrayList<>();
        
        for(int i = 0; i<record.length; i++){
            String[] sArr = record[i].split(" ");
            
            if(sArr[0].equals("Leave")){
                resultList.add(new String[]{sArr[1], "님이 나갔습니다."});
            }else if(sArr[0].equals("Enter")){
                resultList.add(new String[]{sArr[1], "님이 들어왔습니다."});
                names.put(sArr[1], sArr[2]);
            }else{
                names.put(sArr[1], sArr[2]);
            }
        }
        
        String[] result = new String[resultList.size()];
        
        for(int i = 0; i<resultList.size(); i++){
            result[i] = names.get(resultList.get(i)[0]) + resultList.get(i)[1];
        }
        
        return result;
    }
}