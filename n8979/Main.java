package n8979;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        
        int[][] nations = new int[n][4];
        
        for(int i = 0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<4; j++){
                nations[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        
        int index = 0;
        
        for(int i = 0; i<n; i++) {
        	if(nations[i][0] == k)
        		index = i;
        }
        
        int count = 0;
        for(int i = 0; i<n; i++){
            if(i == index);
            else if(nations[i][1]>nations[index][1]) count++;
            else if(nations[i][1] == nations[index][1]){
                if(nations[i][2]>nations[index][2]) count++;
                else if(nations[i][2]==nations[index][2]){
                    if(nations[i][3]>nations[index][3]) count++;
                }
            }
        }
        System.out.println(count+1);
    }
}