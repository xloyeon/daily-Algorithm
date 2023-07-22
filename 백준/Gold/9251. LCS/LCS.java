import java.util.*;
import java.io.*;

public class Main {
    public static char[] charA;
    public static char[] charB;
    public static Integer[][] memo;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        charA = br.readLine().toCharArray();
        charB = br.readLine().toCharArray();
        
        memo = new Integer[charA.length][charB.length];
        System.out.println(lcs(charA.length-1, charB.length-1));
    }
    
    public static int lcs(int a, int b){
        if(a<0 || b <0) return 0;
        
        if(memo[a][b] == null){
            memo[a][b] = 0;
            
            if(charA[a] == charB[b])
                memo[a][b] = lcs(a-1, b-1) + 1;
            else
                memo[a][b] = Math.max(lcs(a-1, b), lcs(a, b-1));
        }
        return memo[a][b];
    }
}