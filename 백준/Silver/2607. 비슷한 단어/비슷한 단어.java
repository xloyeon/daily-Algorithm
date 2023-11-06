import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = br.readLine().split("");
        
        int result = 0;
        
        for(int i = 0; i<N-1; i++){
            String s = br.readLine();
            
            if(Math.abs(s.length() - words.length)>=2)
                continue;
            
            //words가 더 길면 뺐을 때 없어야 함
            if(words.length > s.length()){
                for(int j = 0; j<words.length; j++){
                    if(s.length() == 0) continue;
                    s = s.replaceFirst(words[j]+"", "");
                }
                
                if(s.length() == 0) result++;
            } else if(words.length < s.length()){
                for(int j = 0; j<words.length; j++){
                    s = s.replaceFirst(words[j]+"", "");
                }
                
                if(s.length() == 1) result++;
            } else if (words.length == s.length()) {
                for(int j = 0; j<words.length; j++){
                    s = s.replaceFirst(words[j]+"", "");
                }
                
                if(s.length() == 0 || s.length() == 1) result++;
            }
        }
        
        System.out.println(result);
    }
}