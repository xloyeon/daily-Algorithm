import java.util.*;
import java.io.*;

public class Main{
    public static int N, K;
    public static int result;
    public static String[] alphas;
    
    public static void solve(int idx, int count, int bitmask){
        if(count == K){
            int chars = 0;    //글자 수
            
            for(String alpha : alphas){
                boolean flag = true;
                
                for(int i = 0; i<alpha.length(); i++){
                    if((bitmask & (1<<alpha.charAt(i)-'a')) == 0){    //방문처리가 아니라면
                        flag = false;
                        break;
                    }
                }
                if(flag) chars++;    //모든 글자 있다면
            }
            result = Math.max(result, chars);
            return;
        }
        
        for(int i = idx; i<26; i++){
            if((bitmask & (1<<i)) == 0)
                solve(i+1, count+1, bitmask|(1<<i));
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        int bitmask = 0;
        
        //모두 겹치는 글자는 a, n, t, i, c -> K-5글자 조합 가능
        bitmask |=1 <<('a'-'a');
        bitmask |=1 <<('n'-'a');
        bitmask |=1 <<('t'-'a');
        bitmask |=1 <<('i'-'a');
        bitmask |=1 <<('c'-'a');
        
        alphas = new String[N];
        for(int i = 0; i<N; i++){
            String word = br.readLine();
            word = word.substring(4, word.length()-4); //앞, 뒤는 제거
            alphas[i] = word;
           
        }
        
        solve(0, 5, bitmask);    //a, n, t, i, c이 이미 있으므로 5에서 시작
        System.out.println(result);
    }
}