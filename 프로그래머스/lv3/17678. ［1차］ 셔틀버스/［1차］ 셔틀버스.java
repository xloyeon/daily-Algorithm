import java.util.*;

class Solution {
    
    public int[] getNextTime(int[] start, int t){
        int hour = start[0];
        int minute = start[1];
        
        minute += t;
        
        while(minute>= 60){
            hour++;
            minute -= 60;
        }
        
        return new int[]{hour, minute};
    }
    
    
    public String getResult(int[] result, boolean flag){
        int hour = result[0];
        int minute = result[1];
        
        if(flag){
            minute--;
        
            if(minute<0){
                hour--;
                minute = 59;
            }
        }
        
        return getStringOfTime(hour, minute);
        
    }
    
    public String getStringOfTime(int hour, int minute){
        String hourS = String.valueOf(hour).length()<2 ? "0" + String.valueOf(hour) : String.valueOf(hour);
        String hourM = String.valueOf(minute).length()<2 ? "0" + String.valueOf(minute) : String.valueOf(minute);
        
        return hourS + ":" + hourM;
    }
    
    public boolean isEarlier(int[] time, int[] start){
        if(time[0] < start[0])  //시간이 더 일찍이면 time이 더 빠름
            return true;
        else{
            if(time[0] == start[0] && time[1] <=start[1])
                return true;
            return false;
                
        }                                              
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        //셔틀은 9시부터 n회 t분 간격으로 출발 -> 운행 시각은 정해져 있음
        
        //숫자를 시간,분으로 나눠서 큐에 오름차순 정렬로 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1]-o2[1];
            return o1[0] - o2[0];
        });
        
        for(int i=0; i<timetable.length; i++){
            int[] time = new int[2];
            time[0] = Integer.valueOf(timetable[i].substring(0,2));
            time[1] = Integer.valueOf(timetable[i].substring(3));
            pq.add(time);
        }
        
        
        int[] start = new int[]{9, 0}; //첫 셔틀버스 시간은 9:00
        List<int[]> busPeople = new ArrayList<>();
        
        while(n--> 0){
            int people = 0;
            busPeople = new ArrayList<>();
            
            while(!pq.isEmpty()){
                int[] time = pq.poll();
                
                if(isEarlier(time, start)) { //더 일찍이면
                    people++;
                    busPeople.add(time);
                    
                    if(people >=m)   {//셔틀에 탈 수 있는 최대 명수 채우먄
                        break;
                    }
                }else{  //최대 명수 못 채웠지만 운행 시간이 지나면 안 태우고 출발
                    pq.add(time);
                    people = 0;
                    break;
                }
            }
            
            if(n !=0)
                start = getNextTime(start, t);
                
        }
        
            
        if(busPeople.size()<m){
            return getResult(start, false);
        }else {
            return getResult(busPeople.get(busPeople.size()-1), true);
        }
        
    }
}