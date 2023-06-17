import java.util.*;

class Solution {
    List<Double> area;
    
    public void makeGraph(int k){
        int idx = 0;
        int before = k; //이전 지점 y 크기
        
        while(k !=1){
            if(k%2==0)
                k/=2;
            else 
                k = k*3 +1;
            area.add((before+k)/2.0);
            before = k;
        }
        
    }
    
    public double sumArea(int[] arr){
        int a = area.size()+arr[1]; //끝 구간 가로
        if(a<arr[0]) return -1;
        
        double sum = 0.0;
        
        for(int i = arr[0]; i<a; i++){
            sum += area.get(i);
        }
        return sum;
    }
    
    public double[] solution(int k, int[][] ranges) {
        //먼저 구간 1씩에 대한 넓이 리스트 만들기
        area = new ArrayList<>();
        makeGraph(k);
        
        //결과 배열
        double[] result = new double[ranges.length];
        
        //정적분 구하기
        for(int i = 0; i<ranges.length; i++){
            result[i] = sumArea(ranges[i]);
        }
        
        return result;
    }
}