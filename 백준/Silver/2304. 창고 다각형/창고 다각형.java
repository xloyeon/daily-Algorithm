import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //오목한 곳 없으려면 -> 올라가는 쪽은 계속 올라가고 내려가는 쪽은 계속 내려감
        //제일 높은 기둥이 마지노선
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] columns = new int[N][2];
        
        int maxH = 0;
        int x = 0;
        
        StringTokenizer st;
        
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            columns[i][0] = Integer.parseInt(st.nextToken());
            columns[i][1] = Integer.parseInt(st.nextToken());
            
            maxH = Math.max(maxH, columns[i][1]);
        }
        
        //가로 위치 순 정렬
        Arrays.sort(columns, (o1, o2) -> {
            return o1[0]-o2[0];
        });
        
        //가장 높은 기둥(기준 기둥) 위치 구하기
        for(int i = 0; i<N; i++){
            if(columns[i][1] == maxH)
                x = i;
        }
        
        int area = 0;    //면적
        
        //높은 기둥 기준 왼쪽(올라가는 쪽) 먼저
        int l = columns[0][0];
        int h = columns[0][1];
        
        for(int i = 0; i<=x; i++){
            //더 높은 기둥 있으면
            if(columns[i][1]>=h){
                area += (columns[i][0]-l)*h;    //이전 넓이 더하기
                //위치 조정
                l = columns[i][0];
                h = columns[i][1];
            }
        }
        
        //높은 기둥 기준 오른쪽(내려가는 쪽)
        l = columns[N-1][0];
        h = columns[N-1][1];
        
        for(int i = N-1; i>=x; i--){
            if(columns[i][1]>=h){
                area += (l-columns[i][0])*h;
                //위치 조정
                l = columns[i][0];
                h = columns[i][1];
            }
        }
        
        //높은 기둥 면적 더하기
        area += maxH;
        
        System.out.println(area);
    }
}