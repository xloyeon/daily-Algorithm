import java.util.*;
import java.io.*;


public class Main {
    public static int N, M, r, c, d;
    public static int[][] rooms;
    public static int[] dirR = {-1, 0, 1, 0};  //북 동 남 서
    public static int[] dirC = {0, 1, 0, -1};

    public static int simulate(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        int count = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(rooms[cur[0]][cur[1]] == 0){
                count++;
                rooms[cur[0]][cur[1]] = 2;
            }

            boolean flag = false;

            // 상 하 좌 우 확인해서 청소 안 한 곳 있는지 확인
            for(int i = 0; i<4; i++){
                int checkR = cur[0] + dirR[i];
                int checkC = cur[1] + dirC[i];

                if(rooms[checkR][checkC] == 0){
                    flag = true;
                    break;
                }
            }

            //청소 안 한 곳이 있는 경우
            if(flag){
                //반시계로 90도 회전
                if(--d == -1)
                    d = 3;

                int checkR = cur[0] + dirR[d];
                int checkC = cur[1] + dirC[d];

                //앞쪽이 빈 칸이면 전진하고
                if(rooms[checkR][checkC] == 0){
                    q.add(new int[]{checkR, checkC});
                }else{
                    q.add(new int[]{cur[0], cur[1]});
                }
            }else{
                //후진시 확인
                int checkR = cur[0] - dirR[d];
                int checkC = cur[1] - dirC[d];

                if(rooms[checkR][checkC] == 1)
                    return count;

                q.add(new int[]{checkR, checkC});
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rooms = new int[N][M];

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());


        for(int i = 0; i<N; i++){
            rooms[i] = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = simulate();

        System.out.println(count);
    }
}