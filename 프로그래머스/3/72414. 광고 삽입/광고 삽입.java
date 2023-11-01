class Solution {
    public int convertToTime(String s) {
        String[] time = s.split(":");
        int result = 0;
        
        result += Integer.parseInt(time[0]) * 60 * 60;
        result += Integer.parseInt(time[1]) * 60;
        result += Integer.parseInt(time[2]);
        
        return result;
    }
    
    public String convertToString(int time) {
        
        int h = (time/3600);
        
        int m = (time%3600)/60;
        
        int s = (time%3600)%60;
        
        String hour = h<10 ? "0" + h : "" + h;
        String minute = m < 10? "0"+m : "" + m;
        String second = s < 10 ? "0" + s : ""+s;
        
        return hour + ":" + minute + ":" + second;
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        //최적의 공익광고 위치 -> 시청자들이 가장 많이 본 구간 
        //가장 많은 사용자가 보고, 가장 재생시간 겹치는 구간이 큰 것
        //한 시간에 3600초 -> 24시간에 86400초
        //logs의 최대 -> 30만
        
        int total = convertToTime(play_time);   //전체 재생 시간을 초로 계산
        int adv = convertToTime(adv_time);  //전체 광고 시간을 초로 계산
        
        int[] play = new int[total];    //전체 재생 시간 초로 나눔
        
        for(String log : logs) {
            String[] s = log.split("-");
            int start = convertToTime(s[0]);
            int end = convertToTime(s[1]);
            
            for(int i = start; i<end; i++){
                play[i] ++;
            }
        }
        
        long max = 0;   //최대 광고 시간 초
        long tempTime = 0;  //갱신할 시간
        int result = 0;
        
        //초기값 설정
        for(int i = 0; i<adv; i++){
            max += play[i];
        }
        
        tempTime = max; //초기값을 0초에서 시작하는 광고 시간으로 함.
        
        for(int i = adv; i<total; i++){
            tempTime += play[i] - play[i-adv];
            
            if(tempTime > max) {
                max = tempTime;
                result = i - adv + 1;
            }
        }
        
        return convertToString(result);
    }
}