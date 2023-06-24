import java.util.*;

class Mission implements Comparable<Mission> {
    private String name;
    private int start;
    private int time;
    
    public Mission(String name, int start, int time){
        this.name = name;
        this.start = start;
        this.time = time;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getStart(){
        return this.start;
    }
    
    public int getTime(){
        return this.time;
    }
    
    public void setTime(int time){
        this.time = time;
    }
    
    public int compareTo(Mission m){
        return this.start - m.getStart();
    }
}

class Solution {
    
    public int convertToMinutes(String time){
        String[] times = time.split(":");
        return Integer.valueOf(times[0])*60 + Integer.valueOf(times[1]);
    }
    
    public String[] solution(String[][] plans) {
        
        String[] result = new String[plans.length]; //결과 배열
        int idx = 0;    //결과 배열 인덱스
        
        PriorityQueue<Mission> pq = new PriorityQueue<>();  //과제 시작 시간 순서대로
        List<Mission> stop = new ArrayList<>(); //잠시 멈춘 과제
        
        for(String[] plan : plans){
            int startTime = convertToMinutes(plan[1]);
            Mission mission = new Mission(plan[0], startTime, Integer.valueOf(plan[2]));
            pq.add(mission);
        }
        
        
        //이전에 시작한 과제
        Mission before = pq.poll();
        
        while(!pq.isEmpty()){
            //다음에 시작하는 과제
            Mission current = pq.poll();
            
            //다음에 시작하는 과제이전에 수행할 수 있는 시간
            int gap = current.getStart() - before.getStart();
            
            
            //현재 시작 과제를 다음 시작 과제 전에 끝낼 수 없다면
            if(before.getTime()> gap){
                before.setTime(before.getTime()-gap);   //할 수 있는 만큼 수행하고
                stop.add(before);   //잠시 멈춤
            }
            
            //끝낼 수 있다면
            else{
                gap -= before.getTime();
                result[idx++] = before.getName();   //현재 시작 과제 끝냄
                
                //가장 최근에 멈춘 과제부터 하나씩 끝내기
                while(stop.size()>0 && gap>0){
                    Mission temp = stop.get(stop.size()-1);
                    
                    if(temp.getTime()>gap){
                        temp.setTime(temp.getTime()-gap);
                        stop.set(stop.size()-1, temp);
                        break;
                    }else {
                        stop.remove(stop.size()-1);
                        result[idx++] = temp.getName();
                        gap -= temp.getTime();
                    }
                }
            }
            before = current;
        }
        
        //마지막에 시작한 과제는 끝까지 수행할 수 있으므로 바로 끝내기
        result[idx++] = before.getName();
        
        //잠시 멈춘 과제 중에 끝내지 못한 과제 끝내기
        while(stop.size()>0){
            result[idx++] = stop.get(stop.size()-1).getName();
            stop.remove(stop.size()-1);
        }
        
        return result;
    }
}