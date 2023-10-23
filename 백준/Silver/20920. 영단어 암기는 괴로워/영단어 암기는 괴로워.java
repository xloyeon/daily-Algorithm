import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            
            if(s.length()>=M){
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        
        List<String> words = new ArrayList<>(map.keySet());
        
        Collections.sort(words, (o1, o2) -> {
            if(map.get(o1) == map.get(o2)){
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o2.length() - o1.length();
            }
            
            return map.get(o2) - map.get(o1);
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(String word : words){
            sb.append(word + "\n");
        }
        System.out.println(sb.toString());
    }
}