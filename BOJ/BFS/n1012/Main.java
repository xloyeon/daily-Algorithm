package BOJ.BFS.n1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[][] field, visited;
    static int[] positionX = new int[]{1, 0, 0, -1};
    static int[] positionY = new int[]{0, 1, -1, 0};

    public static void placeWorms(int width, int length){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{width, length});

        while(!queue.isEmpty()){
            int[] cabbage = queue.poll();
            int cabbageX = cabbage[0];
            int cabbageY = cabbage[1];
            visited[cabbageX][cabbageY] = 1;

            for(int i = 0; i<4; i++){
                int x = cabbageX + positionX[i];
                int y = cabbageY + positionY[i];

                if(x>=0 && y>=0 && x<m && y<n){
                    if(field[x][y] == 1 && visited[x][y]==0){
                        queue.add(new int[]{x, y});
                        visited[x][y] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i<t; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            field = new int[m][n];
            visited = new int[m][n];

            for(int j = 0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            int count = 0;

            for(int width = 0; width<m; width++){
                for(int length = 0; length<n; length++){
                    if(visited[width][length]==0 && field[width][length] == 1) {
                        placeWorms(width, length);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
