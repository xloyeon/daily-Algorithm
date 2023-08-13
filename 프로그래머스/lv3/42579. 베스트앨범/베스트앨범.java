import java.util.*;

class Music implements Comparable<Music> {
    int idx;
    int play;
    String genre;
    
    public Music(int idx, int play, String genre){
        this.idx = idx;
        this.play = play;
        this.genre = genre;
    }
    
    public int compareTo(Music m){
        if(this.play == m.play)
            return this.idx - m.idx;
        return m.play - this.play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, List<Music>> musicMap = new HashMap<>();
        
        for(int i = 0; i<genres.length; i++) {
            String genre = genres[i];
            Music music = new Music(i, plays[i], genre);
            
            if(genreMap.containsKey(genre)){
                genreMap.put(genre, genreMap.get(genre) + plays[i]);
                List<Music> musics = musicMap.get(genre);
                musics.add(music);
                musicMap.put(genre, musics);
            }else{
                genreMap.put(genre, plays[i]);
                List<Music> musics = new ArrayList<>();
                musics.add(music);
                musicMap.put(genre, musics);
            }
            
         }
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(genreMap.entrySet());
        entryList.sort(((o1, o2) -> genreMap.get(o2.getKey()) - genreMap.get(o1.getKey())));
        
        List<Integer> resultList = new ArrayList<>();
        
        for(Map.Entry<String, Integer> entry : entryList){
            String genre = entry.getKey();
            List<Music> musics = musicMap.get(genre);
            
            Collections.sort(musics);
            
            if(musics.size() <=1){
                resultList.add(musics.get(0).idx);
            }else{
                resultList.add(musics.get(0).idx);
                resultList.add(musics.get(1).idx);
            }
        }
        
        int[] result = new int[resultList.size()];
        
        for(int i = 0; i<result.length; i++){
            result[i] = resultList.get(i);
        }
        
       return result;
    }
}