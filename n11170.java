import java.util.*;
import java.io.*;

public class Main{
	
	public static int countZero(int n, int m){
        int count = 0;
        
        for(int i = n; i<=m; i++){
            String s = Integer.toString(i);
            for(int j = 0; j<s.length(); j++){
                if(s.charAt(j) == '0') count++;
            }
        }
        return count;
	}
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(countZero(n, m));
        }
    }
}