import java.util.*;

class Music implements Comparable<Music> {
    public int idx;
    public int time;
    public String title;
    public String score;
    
    public Music(int idx, String startTime, String endTime, String title, String score){
        this.idx = idx;
        this.title = title;
        this.score = score;
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        int startMin = Integer.valueOf(start[0])*60 + Integer.valueOf(start[1]);
        int endMin = Integer.valueOf(end[0])*60 + Integer.valueOf(end[1]);
        this.time = endMin - startMin;
    }
    
    // 정렬
    public int compareTo(Music o){
        if(this.time == o.time)
            return this.idx - o.idx;
        return o.time - this.time;
    }
    
    public void guessFullScore(){
        String initString = this.score;
        
        // 재생 시간이 음악 길이보다 긴 경우
        while(this.score.length() < this.time){
            this.score += initString;
        }
        
        // 자르기
        if(this.score.length() > this.time){
            this.score = this.score.substring(0, this.time);
        }
    }
}

class Solution {

    // '#' 음 처리
    public String normalize(String s){
        return s
            .replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("G#", "g")
            .replace("A#", "a")
            .replace("B#", "b")
            .replace("E#", "e")
            ;
    }
    
    public String solution(String m, String[] musicinfos) {
        Music[] songs = new Music[musicinfos.length];
        
        // 기억하는 멜로디도 '#' 변환
        m = normalize(m);
        
        for(int i = 0; i < musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            
            songs[i] = new Music(
                i,
                info[0],
                info[1],
                info[2],
                normalize(info[3]) 
            );
            songs[i].guessFullScore();
        }
        
        Arrays.sort(songs);
        
        for(Music song : songs){
            if(song.score.contains(m))
                return song.title;
        }
        
        return "(None)";
    }
}
