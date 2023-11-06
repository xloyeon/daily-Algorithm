import java.util.*;
import java.io.*;

class Team{
    public int[] problems;    //문제 점수
    public int count;    //제출횟수
    public int time;    //제출시간
    public int total;    //총점수
    
    public Team(int[] problems, int count, int time, int total) {
        this.problems = problems;
        this.count = count;
        this.time = time;
        this.total = total;
    }
}

public class Main {
    public static int T, n, k, t, m;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            Team[] teams = new Team[n+1];
            
            for(int j = 1; j<teams.length; j++){
                teams[j] = new Team(new int[k+1], 0, m, 0);
            }
            
            for(int j = 0; j<m; j++){
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                
                teams[idx].problems[p] = Math.max(teams[idx].problems[p], s);
                teams[idx].count++;
                teams[idx].time = j;
            }
            
            for(int j = 1; j<teams.length; j++){
                int temp = 0;
                for(int l = 1; l<k+1; l++){
                    temp += teams[j].problems[l];
                }
                teams[j].total = temp;
            }
            
            Team team = teams[t];
            
            int result = 0;
            
            for(int j = 1; j<teams.length; j++){
                if(j == t) continue;
                
                if(teams[j].total > team.total) result++;
                else if(teams[j].total == team.total){
                    if(teams[j].count < team.count) result++;
                    else if(teams[j].count == team.count) {
                        if(teams[j].time<team.time) result++;
                    }
                }
            }
            
            System.out.println(result+1);
        }
    }
}