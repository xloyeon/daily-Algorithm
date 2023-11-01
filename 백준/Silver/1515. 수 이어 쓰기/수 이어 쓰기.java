import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split("") ;   //최대 3000자리
        
        int idx = 0;    //앞에 붙일 수라고 가정
        int max = 0;
        
        while(true) {
            max++;
            
            String temp = String.valueOf(max);
            
            for(int i = 0; i<temp.length(); i++){
                if(temp.charAt(i) == N[idx].charAt(0))
                    idx++;
                if(idx == N.length) {
                    System.out.println(max);
                    return;
                }
            }
        }
        
    }
}