import java.util.*;
import java.io.*;

public class Main {
    public static char[] charA;
    public static char[] charB;
    public static char[] charC;
    public static int[][][] memo;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        charA = br.readLine().toCharArray();
        charB = br.readLine().toCharArray();
        charC = br.readLine().toCharArray();
        
        memo = new int[charA.length + 1][charB.length+1][charC.length+1];
        
        for(int i = 1; i<=charA.length; i++){
            for(int j = 1; j<=charB.length; j++){
                for(int k = 1; k<=charC.length; k++){
                    if(charA[i-1] == charB[j-1] && charB[j-1] == charC[k-1])
                        memo[i][j][k] = memo[i-1][j-1][k-1]+1;
                    else
                        memo[i][j][k] = Math.max(memo[i-1][j][k], Math.max(memo[i][j-1][k], memo[i][j][k-1]));
                }
            }
        }
        
        System.out.println(memo[charA.length][charB.length][charC.length]);
    }
}