import java.io.*;
import java.util.*;

public class Main {
    public static int n, l;
    
    public static int calCount(int[] temp){
        if(isRoad(temp)) return 1;
        return 0;
    }
    
    public static boolean isRoad(int[] heights){
        int h = heights[0];
        int len = 1;
        boolean[] visited = new boolean[n];
        
        for(int i = 1; i<n; i++){
            if(heights[i] == h) {   //높이 같을 때
                len++;
            }else if(heights[i] - h == 1) {    //올라갈 때
                if(len >=l){
                    for(int j = i-l; j<i; j++){
                        if(visited[j]) return false;    //이미 설치돼있는 경우
                        
                    }
                    h = heights[i];
                    len = 1;
                } else {
                     return false;
                }
            }else if(h-heights[i] == 1){    //내려갈 때
                if(i + (l-1)<n){
                    for(int j = i+1; j<i + l; j++){
                        if(heights[i] != heights[j] || visited[j])
                            return false;
                    }
                    
                    Arrays.fill(visited, i+1, i+l, true);
                    if(l ==1) visited[i] = true;
                    
                    h = heights[i];
                    len= 1;
                    i += l-1;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {    //가로
            int[] temp = map[i];
            answer += calCount(temp);
        }

        for (int j = 0; j < n; j++) {    //세로
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = map[i][j];
            }
            answer += calCount(temp);
        }
        
        System.out.println(answer);

    }
}