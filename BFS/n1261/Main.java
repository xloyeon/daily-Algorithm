package BFS.n1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] maze;
    private static int[] rangeA = {-1, 0, 1, 0};
    private static int[] rangeB = {0, 1, 0, -1};

    private static void BFS() {
        Deque<int[]> q = new ArrayDeque<>();

        int[][] visited = new int[m][n];
        int min = n*m;

        q.offer(new int[]{0, 0});
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            int[] room = q.poll();

            int x = room[0];
            int y = room[1];

            if(x == m-1 && y == n-1){
                System.out.println(visited[x][y] -1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int a = x + rangeA[i];
                int b = y + rangeB[i];

                if (a >= 0 && a < m && b >= 0 && b < n) {
                    int temp = visited[a][b];
                    int current = visited[x][y];

                    if (temp == 0) {
                        if (maze[b][a] == 1) {
                            visited[a][b] = current + 1;
                            q.addLast(new int[]{a, b});
                        }
                        else {
                            visited[a][b] = current;
                            q.addFirst(new int[]{a, b});
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maze = new int[n][m];

        for(int i = 0; i< maze.length; i++){
            String[] str = br.readLine().split("");

            for(int j = 0; j<maze[0].length; j++){
                maze[i][j] = Integer.parseInt(str[j]);
            }
        }

        BFS();

    }
}
