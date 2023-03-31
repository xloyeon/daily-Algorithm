import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        //원소 넣을 리스트들의 리스트 만들기
        List<List<Integer>> triangle = new ArrayList<>();
        
        //총 원소 개수 = n!
        int size = 0;
        
        //각 행별로 원소 담을 리스트 만들기, 총 원소 개수 계산
        for(int i = 0; i<n; i++){
            triangle.add(new ArrayList<>());
            size += i+1;
        }
        
        
        //넣을 원소
        int idx = 1;
        
        while(idx<=size){
            
            //아래로 내려가는 원소
            for(int i = 0; i<n; i++){
                //채워지지 않은 행에서만 넣음
                if(triangle.get(i).size()<i+1){
                    int position = triangle.get(i).size()/2;
                    triangle.get(i).add(position, idx++);
                }
            }
            
            //다 채워지면 그만 채우기
            if(idx>size) break;
            
            //마지막 행은 전부 채우기
            for(int i = n-1; i>=0; i--){
                if(triangle.get(i).size()<i+1){
                    //몇 개의 원소를 채울건지 계산
                    int limit = i+1-triangle.get(i).size();
                    
                    //넣을 위치 계산
                    int position = (triangle.get(i).size() + 1)/2;
                    
                    //차례대로 원소 넣기
                    for(int j = 0; j<limit; j++){
                        triangle.get(i).add(position++, idx++);
                    }
                    break;
                }
            }
            
            //다 채워지면 그만 채우기
            if(idx>size) break;
            
            //위로 올라가는 원소
            for(int i = n-1; i>=0; i--){
                int position = (triangle.get(i).size() + 1)/2;
                if(triangle.get(i).size()<i+1){
                    triangle.get(i).add(position, idx++);
                }
            }
            
        }
        
        //결과값 배열
        int[] result = new int[size];
        int k = 0;
        
        for(List<Integer> list : triangle){
            for(int i = 0; i<list.size(); i++){
                result[k++] = list.get(i);
            }
        }
        
        return result;
    }
}