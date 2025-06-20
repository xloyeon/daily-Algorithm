import java.util.*;

class Play {
    int idx;
    int count;
    
    public Play(int idx, int count){
        this.idx = idx;
        this.count = count;
    }
    
    public int getIdx(){
        return this.idx;
    }
    public int getCount(){
        return this.count;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //해시맵 하나를 만든다
        //key는 장르(classic, pop, ...), value는 재생수
        
        //장르가 key, 전체 재생수가 value인 해시맵
        HashMap<String, Integer> playCounts = new HashMap<>();
        
        //장르가 key, Play 객체 list가 value인 해시맵
        HashMap<String, List<Play>> genrePlays = new HashMap<>();
        
        for(int i = 0; i<genres.length; i++){
            //genre별 전체 재생수를 map에 저장
            playCounts.put(genres[i], playCounts.getOrDefault(genres[i], 0) + plays[i]);
            
            //genre별 play 리스트에 지금 탐색하는 Play 객체를 저장
            List<Play> playList = genrePlays.getOrDefault(genres[i], new ArrayList<>());
            playList.add(new Play(i, plays[i]));
            genrePlays.put(genres[i], playList);
        }
        
        //genre를 전체 재생수가 높은 순대로 정렬
        List<Map.Entry<String, Integer>> genreList = new LinkedList<>(playCounts.entrySet());
        genreList.sort((o1, o2) -> playCounts.get(o2.getKey()) - playCounts.get(o1.getKey()));
        
        //결과값 저장할 리스트(추후 배열로 변환)
        List<Integer> resultList = new ArrayList<>();
        
        for(Map.Entry<String, Integer> genre : genreList){
            List<Play> playList = genrePlays.get(genre.getKey());
            playList.sort((o1, o2) -> 
                         o2.getCount() - o1.getCount());
            
            if(playList.size()<=1){
                resultList.add(playList.get(0).getIdx());
                continue;
            }
            
            for(int i = 0; i<2; i++){
                resultList.add(playList.get(i).getIdx());
            }
        }
        int[] answer = new int[resultList.size()];
        
        for(int i = 0; i<resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}