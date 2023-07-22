import java.util.*;
import java.io.*;

public class Main {
    static char[] charA;
    static char[] charB;
    static int[][] memo;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        charA = br.readLine().toCharArray();
        charB = br.readLine().toCharArray();
        
        memo = new int[charA.length+1][charB.length+1];
        int max = 0;
        
        for(int i = 1; i<=charA.length; i++){
            for(int j = 1; j<=charB.length; j++){
                if(charA[i-1] == charB[j-1]){
                    memo[i][j] = memo[i-1][j-1]+1;
                    max = Math.max(max, memo[i][j]);
                }
            }
        }
        
        System.out.println(max);
    }
}