import java.util.*;
import java.io.*;

class Main {
    public static char[] charA;
    public static char[] charB;
    public static int[][] memo;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        charA = br.readLine().toCharArray();
        charB = br.readLine().toCharArray();
        
        memo = new int[charA.length+1][charB.length+1];
        
        for(int i = 1; i<=charA.length; i++){
            for(int j = 1; j<=charB.length; j++){
                if(charA[i-1] == charB[j-1])
                    memo[i][j] = memo[i-1][j-1] + 1;
                else
                    memo[i][j] = Math.max(memo[i][j-1], memo[i-1][j]);
            }
        }
        
        System.out.println(memo[charA.length][charB.length]);
        System.out.println(getLcsString());
    }
   
    public static String getLcsString(){
        int a = charA.length;
        int b = charB.length;
        StringBuilder sb = new StringBuilder();
        
        while(a>0 && b>0) {
            if(memo[a-1][b] == memo[a][b])
                a--;
            else if(memo[a][b-1] == memo[a][b])
                b--;
            else {
                sb.append(charB[b-1]);
                a--;
                b--;
            }
        }
        
        return sb.reverse().toString();
    }
    
}