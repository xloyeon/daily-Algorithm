import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] time = new int[26];
        int[] change = new int[]{2,5,8,11,14,18,21};
        
        int t = 3;
        
        for(int i = 0; i<time.length; i++){
            time[i] = t;
            
            for(int j = 0; j<change.length; j++){
                if(i == change[j])
                    t++;
            }
        }
        
        int result = 0;
        
        for(int i = 0; i<s.length(); i++){
            int k = s.charAt(i) - 'A';
            result += time[k];
        }
        System.out.println(result);
    }
}